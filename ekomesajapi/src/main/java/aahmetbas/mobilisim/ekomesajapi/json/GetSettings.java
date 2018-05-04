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

import aahmetbas.mobilisim.ekomesajapi.object.Balance;
import aahmetbas.mobilisim.ekomesajapi.object.Credential;
import aahmetbas.mobilisim.ekomesajapi.object.Keyword;
import aahmetbas.mobilisim.ekomesajapi.object.OperatorSettings;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseSetting;
import aahmetbas.mobilisim.ekomesajapi.object.Sender;
import aahmetbas.mobilisim.ekomesajapi.object.Settings;
import aahmetbas.mobilisim.ekomesajapi.object.Status;

/**
 * Created by alp on 4.05.2018.
 */

public class GetSettings {
    public ResponseSetting post(Credential credential) {
        ResponseSetting responseSetting = new ResponseSetting();
        Status status = new Status();
        HttpURLConnection urlConnection;

        String data     = credential.convertJson();
        String result   = "";
        try {
            URL url = new URL("http://gw.barabut.com/v1/json/syncreply/GetSettings");
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

            JSONObject reader  = new JSONObject(result);

            status.setCode(reader.getJSONObject("Response").getJSONObject("Status").getInt("Code"));
            status.setDescription(reader.getJSONObject("Response").getJSONObject("Status").getString("Description"));

            if(status.getCode() == 200){
                JSONObject operatorSettingsJson = reader.getJSONObject("Response").getJSONObject("Settings").getJSONObject("OperatorSettings");
                Settings settings = new Settings();
                OperatorSettings operatorSettings = new OperatorSettings();
                if (operatorSettingsJson.has("Account")) {
                    operatorSettings.setAccount(operatorSettingsJson.getString("Account"));
                }
                if (operatorSettingsJson.has("MSISDN")) {
                    operatorSettings.setMsisdn(operatorSettingsJson.getString("MSISDN"));
                }
                if (operatorSettingsJson.has("VariantId")) {
                    operatorSettings.setVariantId(operatorSettingsJson.getString("VariantId"));
                }
                if (operatorSettingsJson.has("ServiceId")) {
                    operatorSettings.setServiceId(operatorSettingsJson.getString("ServiceId"));
                }
                if (operatorSettingsJson.has("UnitPrice")) {
                    operatorSettings.setUnitPrice(operatorSettingsJson.getInt("UnitPrice"));
                }

                JSONArray sendersJson = reader.getJSONObject("Response").getJSONObject("Settings").getJSONArray("Senders");
                ArrayList<Sender> senders = new ArrayList<>();
                for (int i = 0; i < sendersJson.length(); i++) {
                    Sender sender = new Sender();
                    sender.setValue(sendersJson.getJSONObject(i).getString("Value"));
                    sender.setDefault(sendersJson.getJSONObject(i).getBoolean("Default"));
                    senders.add(sender);
                }

                JSONArray keywordsJson = reader.getJSONObject("Response").getJSONObject("Settings").getJSONArray("Keywords");
                ArrayList<Keyword> keywords = new ArrayList<>();
                for (int i = 0; i < keywordsJson.length(); i++) {
                    Keyword keyword = new Keyword();
                    keyword.setServiceNumber(sendersJson.getJSONObject(i).getString("ServiceNumber"));
                    keyword.setValue(sendersJson.getJSONObject(i).getString("Value"));
                    keyword.setTimeStamp(sendersJson.getJSONObject(i).getString("Timestamp"));
                    keyword.setValidity(sendersJson.getJSONObject(i).getInt("Validity"));
                    keywords.add(keyword);
                }

                Balance balance = new Balance();
                balance.setLimit(reader.getJSONObject("Response").getJSONObject("Settings").getJSONObject("Balance").getInt("Limit"));
                balance.setMain(reader.getJSONObject("Response").getJSONObject("Settings").getJSONObject("Balance").getInt("Main"));

                settings.setOperatorSettings(operatorSettings);
                settings.setSenders(senders);
                settings.setKeywords(keywords);
                settings.setBalance(balance);
                responseSetting.setSettings(settings);
            }
            responseSetting.setStatus(status);
        }catch (SocketTimeoutException ste) {
            ste.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return responseSetting;
    }
}

