package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.QueryMultiJson;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.RequestQueryMulti;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseQueryMulti;

/**
 * Created by alp on 30.04.2018.
 */

public class PostQueryMulti extends AsyncTask<Void, Void, Void> {

    private RequestListener<ResponseQueryMulti> callback;
    private RequestQueryMulti requestQueryMulti;
    private ResponseQueryMulti responseQueryMulti;

    public PostQueryMulti(RequestQueryMulti requestQueryMulti, RequestListener<ResponseQueryMulti> cb) {
        this.callback = cb;
        this.requestQueryMulti = requestQueryMulti;
    }

    @Override
    protected Void doInBackground(Void... params) {
        QueryMultiJson queryMulti = new QueryMultiJson();
        responseQueryMulti = queryMulti.post(requestQueryMulti);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(responseQueryMulti);
    }
}

