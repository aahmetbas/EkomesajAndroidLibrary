package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.GetSettings;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.Credential;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseSetting;

/**
 * Created by alp on 4.05.2018.
 */

public class PostSettings extends AsyncTask<Void, Void, Void> {

    private RequestListener<ResponseSetting> callback;
    private Credential credential;
    private ResponseSetting responseSetting;

    public PostSettings(Credential credential, RequestListener<ResponseSetting> cb) {
        this.callback = cb;
        this.credential = credential;
    }

    @Override
    protected Void doInBackground(Void... params) {
        GetSettings getSettings = new GetSettings();
        responseSetting = getSettings.post(credential);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(responseSetting);
    }
}