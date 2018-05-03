package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.SubmitJson;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.Credential;
import aahmetbas.mobilisim.ekomesajapi.object.RequestSubmit;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseSubmit;

/**
 * Created by alp on 2.05.2018.
 */

public class PostSubmit extends AsyncTask<Void, Void, Void> {
    private RequestListener<ResponseSubmit> callback;
    private RequestSubmit requestSubmit;
    private ResponseSubmit responseSubmit;

    public PostSubmit(RequestSubmit requestSubmit, RequestListener<ResponseSubmit> cb) {
        this.callback = cb;
        this.requestSubmit = requestSubmit;
    }

    @Override
    protected Void doInBackground(Void... params) {
        SubmitJson submitJson = new SubmitJson();
        responseSubmit = submitJson.post(requestSubmit);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(responseSubmit);
    }
}