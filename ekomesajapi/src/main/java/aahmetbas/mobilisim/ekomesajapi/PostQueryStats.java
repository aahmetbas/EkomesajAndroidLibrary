package aahmetbas.mobilisim.ekomesajapi;

import android.os.AsyncTask;

import aahmetbas.mobilisim.ekomesajapi.json.QueryStatsJson;
import aahmetbas.mobilisim.ekomesajapi.listener.RequestListener;
import aahmetbas.mobilisim.ekomesajapi.object.Credential;
import aahmetbas.mobilisim.ekomesajapi.object.ResponseQueryStats;

/**
 * Created by alp on 30.04.2018.
 */

public class PostQueryStats extends AsyncTask<Void, Void, Void> {

    private RequestListener<ResponseQueryStats> callback;
    private Credential credential;
    private ResponseQueryStats responseQueryStats;

    public PostQueryStats(Credential credential, RequestListener<ResponseQueryStats> cb) {
        this.callback = cb;
        this.credential = credential;
    }

    @Override
    protected Void doInBackground(Void... params) {
        QueryStatsJson queryStatsJson = new QueryStatsJson();
        responseQueryStats = queryStatsJson.post(credential);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        callback.onTaskComplete(responseQueryStats);
    }
}