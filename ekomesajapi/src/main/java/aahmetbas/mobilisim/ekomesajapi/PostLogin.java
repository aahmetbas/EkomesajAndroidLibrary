package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.Login;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.Credential;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseLogin;

/**
 * Created by alp on 30.04.2018.
 */

public class PostLogin extends AsyncTask<Void, Void, Void> {

    private RequestListener<ResponseLogin> callback;
    private Credential credential;
    private ResponseLogin loginResponse;

    public PostLogin(Credential credential, RequestListener<ResponseLogin> cb) {
        this.callback = cb;
        this.credential = credential;
    }

    @Override
    protected Void doInBackground(Void... params) {
        Login login = new Login();
        loginResponse = login.post(credential);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(loginResponse);
    }
}
