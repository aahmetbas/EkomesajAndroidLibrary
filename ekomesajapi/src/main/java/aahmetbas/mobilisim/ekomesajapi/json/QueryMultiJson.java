package aahmetbas.mobilisim.ekomesajapi.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;

import aahmetbas.mobilisim.ekomesajapi.object.QueryMulti;
import aahmetbas.mobilisim.ekomesajapi.object.RequestQueryMulti;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseQueryMulti;
import aahmetbas.mobilisim.ekomesajapi.object.Status;

/**
 * Created by alp on 30.04.2018.
 */

public class QueryMultiJson {
    public ResponseQueryMulti post(RequestQueryMulti requestQueryMulti) {
        ResponseQueryMulti responseQueryMulti = new ResponseQueryMulti();
        Status status = new Status();
        HttpURLConnection urlConnection;

        String data     = requestQueryMulti.convertJson();
        String result   = "";
        try {
            URL url = new URL("http://gw.barabut.com/v1/json/syncreply/QueryMulti");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestMethod("POST");
            urlConnection.setReadTimeout(60000);
            urlConnection.setConnectTimeout(60000);
            urlConnection.connect();

            OutputStream outputStream = urlConnection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(data);
            writer.close();
            outputStream.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String line = null;
            StringBuilder sb = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            bufferedReader.close();
            result = sb.toString();

            JSONObject reader = new JSONObject(result);

            status.setCode(reader.getJSONObject("Response").getJSONObject("Status").getInt("Code"));
            status.setDescription(reader.getJSONObject("Response").getJSONObject("Status").getString("Description"));
            if(status.getCode() == 200){
                JSONObject report = reader.getJSONObject("Response").getJSONObject("Report");
                JSONArray reportItem = report.getJSONArray("List");

                ArrayList<QueryMulti> arrayList = new ArrayList<>();

                for (int i = 0; i < reportItem.length(); i++) {
                    QueryMulti queryMulti = new QueryMulti();
                    queryMulti.setCoding(reportItem.getJSONObject(i).getString("Coding"));
                    queryMulti.setCost(reportItem.getJSONObject(i).getInt("Cost"));
                    queryMulti.setCount(reportItem.getJSONObject(i).getInt("Count"));
                    queryMulti.setId(reportItem.getJSONObject(i).getInt("Id"));
                    queryMulti.setMessage(reportItem.getJSONObject(i).getString("Message"));
                    queryMulti.setReceived(reportItem.getJSONObject(i).getString("Received"));
                    queryMulti.setSender(reportItem.getJSONObject(i).getString("Sender"));
                    queryMulti.setSent(reportItem.getJSONObject(i).getString("Sent"));
                    queryMulti.setState(reportItem.getJSONObject(i).getString("State"));
                    queryMulti.setDeliveredCount(reportItem.getJSONObject(i).getInt("DeliveredCount"));
                    queryMulti.setUndeliveredCount(reportItem.getJSONObject(i).getInt("UndeliveredCount"));
                    arrayList.add(queryMulti);

                    System.gc();
                    if(queryMulti != null){
                        queryMulti = null;
                    }
                }

                responseQueryMulti.setQueryMultiList(arrayList);
            }
            responseQueryMulti.setStatus(status);
        }catch (SocketTimeoutException ste) {
            ste.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseQueryMulti;
    }
}
