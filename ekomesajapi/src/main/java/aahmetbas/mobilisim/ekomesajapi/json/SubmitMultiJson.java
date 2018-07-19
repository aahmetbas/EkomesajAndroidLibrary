package aahmetbas.mobilisim.ekomesajapi.json;

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

import aahmetbas.mobilisim.ekomesajapi.object.RequestSubmitMulti;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseSubmitMulti;
import aahmetbas.mobilisim.ekomesajapi.object.Status;

/**
 * Created by alp on 2.05.2018.
 */

public class SubmitMultiJson {
    public ResponseSubmitMulti post(RequestSubmitMulti requestSubmitMulti){
        ResponseSubmitMulti responseSubmitMulti = new ResponseSubmitMulti();
        Status status = new Status();
        HttpURLConnection urlConnection;
        String data     = requestSubmitMulti.convertJson();
        String result   = "";
        try {
            URL url = new URL("http://gw.barabut.com/v1/json/syncreply/SubmitMulti");
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
                responseSubmitMulti.setMessageId(reader.getJSONObject("Response").getInt("MessageId"));
            }
            responseSubmitMulti.setStatus(status);
        }catch (SocketTimeoutException ste) {
            ste.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseSubmitMulti;
    }
}
