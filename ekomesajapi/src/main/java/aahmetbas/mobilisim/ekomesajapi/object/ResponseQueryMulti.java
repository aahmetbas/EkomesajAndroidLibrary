package aahmetbas.mobilisim.ekomesajapi.object;

import java.util.ArrayList;

/**
 * Created by alp on 30.04.2018.
 */

public class ResponseQueryMulti {
    private Status status;
    private ArrayList<QueryMulti> queryMultiList;

    public ResponseQueryMulti() {
        this.status = new Status();
        this.queryMultiList = new ArrayList<>();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<QueryMulti> getQueryMultiList() {
        return queryMultiList;
    }

    public void setQueryMultiList(ArrayList<QueryMulti> queryMultiList) {
        this.queryMultiList = queryMultiList;
    }
}