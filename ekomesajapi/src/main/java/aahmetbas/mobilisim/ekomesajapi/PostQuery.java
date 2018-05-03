package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.QueryJson;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.RequestQuery;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseQuery;

/**
 * Created by alp on 30.04.2018.
 */

public class PostQuery extends AsyncTask<Void, Void, Void> {

    private RequestListener<ResponseQuery> callback;
    private RequestQuery requestQuery;
    private ResponseQuery responseQuery;

    public PostQuery(RequestQuery requestQuery, RequestListener<ResponseQuery> cb) {
        this.callback = cb;
        this.requestQuery = requestQuery;
    }

    @Override
    protected Void doInBackground(Void... params) {
        QueryJson query = new QueryJson();
        responseQuery = query.post(requestQuery);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(responseQuery);
    }
}

