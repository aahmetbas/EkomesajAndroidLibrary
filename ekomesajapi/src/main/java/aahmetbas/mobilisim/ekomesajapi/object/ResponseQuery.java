package aahmetbas.mobilisim.ekomesajapi.object;

import java.util.ArrayList;

/**
 * Created by alp on 30.04.2018.
 */

public class ResponseQuery {
    private Status status;
    private ArrayList<Query> queryList;

    public ResponseQuery() {
        this.status = new Status();
        this.queryList = new ArrayList<>();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Query> getQueryList() {
        return queryList;
    }

    public void setQueryList(ArrayList<Query> queryList) {
        this.queryList = queryList;
    }
}