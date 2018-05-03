package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.GetBalance;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseBalance;
import aahmetbas.mobilisim.ekomesajapi.object.Credential;

/**
 * Created by alp on 30.04.2018.
 */

public class PostBalance extends AsyncTask<Void, Void, Void> {

    private RequestListener<ResponseBalance> callback;
    private Credential credential;
    private ResponseBalance responseBalance;

    public PostBalance(Credential credential, RequestListener<ResponseBalance> cb) {
        this.callback = cb;
        this.credential = credential;
    }

    @Override
    protected Void doInBackground(Void... params) {
        GetBalance getBalance = new GetBalance();
        responseBalance = getBalance.post(credential);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(responseBalance);
    }
}