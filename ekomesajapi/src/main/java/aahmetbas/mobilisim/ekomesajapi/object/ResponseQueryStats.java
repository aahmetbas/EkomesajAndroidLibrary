package aahmetbas.mobilisim.ekomesajapi.object;

import java.util.ArrayList;

/**
 * Created by alp on 30.04.2018.
 */

public class ResponseQueryStats {
    private Status status;
    private ArrayList<QueryStats> queryStatsList;

    public ResponseQueryStats() {
        this.status = new Status();
        this.queryStatsList = new ArrayList<>();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<QueryStats> getQueryStatsList() {
        return queryStatsList;
    }

    public void setQueryStatsList(ArrayList<QueryStats> queryStatsList) {
        this.queryStatsList = queryStatsList;
    }
}