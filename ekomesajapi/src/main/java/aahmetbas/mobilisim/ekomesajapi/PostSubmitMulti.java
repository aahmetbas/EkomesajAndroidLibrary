package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.SubmitMultiJson;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.RequestSubmitMulti;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseSubmitMulti;

/**
 * Created by alp on 2.05.2018.
 */

public class PostSubmitMulti extends AsyncTask<Void, Void, Void> {
    private RequestListener<ResponseSubmitMulti> callback;
    private RequestSubmitMulti requestSubmitMulti;
    private ResponseSubmitMulti responseSubmitMulti;

    public PostSubmitMulti(RequestSubmitMulti requestSubmitMulti, RequestListener<ResponseSubmitMulti> cb) {
        this.callback = cb;
        this.requestSubmitMulti = requestSubmitMulti;
    }

    @Override
    protected Void doInBackground(Void... params) {
        SubmitMultiJson submitMultiJson = new SubmitMultiJson();
        responseSubmitMulti = submitMultiJson.post(requestSubmitMulti);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(responseSubmitMulti);
    }
}
