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

import aahmetbas.mobilisim.ekomesajapi.object.Query;
import aahmetbas.mobilisim.ekomesajapi.object.RequestQuery;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseQuery;
import aahmetbas.mobilisim.ekomesajapi.object.Status;

/**
 * Created by alp on 30.04.2018.
 */

public class QueryJson {
    public ResponseQuery post(RequestQuery requestQuery) {
        ResponseQuery responseQuery = new ResponseQuery();
        Status status = new Status();
        HttpURLConnection urlConnection;

        String data     = requestQuery.convertJson();
        String result   = "";
        try {
            URL url = new URL("http://gw.barabut.com/v1/json/syncreply/Query");
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
                JSONArray reportItem = reader.getJSONObject("Response").getJSONObject("ReportDetail").getJSONArray("List");

                ArrayList<Query> arrayList = new ArrayList<>();
                for (int i = 0; i < reportItem.length(); i++) {
                    Query query = new Query();
                    query.setId(reportItem.getJSONObject(i).getInt("Id"));
                    query.setNetwork(reportItem.getJSONObject(i).getInt("Network"));
                    query.setMsisdn(reportItem.getJSONObject(i).getString("MSISDN"));
                    query.setCost(reportItem.getJSONObject(i).getInt("Cost"));
                    query.setSubmitted(reportItem.getJSONObject(i).getString("Submitted"));
                    query.setLastUpdate(reportItem.getJSONObject(i).getString("LastUpdated"));
                    query.setState(reportItem.getJSONObject(i).getString("State"));
                    query.setSequence(reportItem.getJSONObject(i).getInt("Sequence"));
                    query.setErrorCode(reportItem.getJSONObject(i).getInt("ErrorCode"));
                    query.setPayLoad(reportItem.getJSONObject(i).getString("Payload"));
                    query.setXser(reportItem.getJSONObject(i).getString("Xser"));
                    arrayList.add(query);

                    System.gc();
                    if(query != null){
                        query = null;
                    }
                }

                responseQuery.setQueryList(arrayList);
            }
            responseQuery.setStatus(status);
        }catch (SocketTimeoutException ste) {
            ste.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseQuery;
    }
}
