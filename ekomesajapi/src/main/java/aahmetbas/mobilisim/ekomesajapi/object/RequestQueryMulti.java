package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class RequestQueryMulti {
    Credential credential;
    String beginDate;
    String endDate;

    public RequestQueryMulti(Credential credential, String beginDate, String endDate) {
        this.credential = credential;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String convertJson(){
        return "{" + credential.toString() + "," + convertString() + "}";
    }

    private String convertString() {
        String post = "\"Range\":";
        post = post + "{\"Begin\":" + "\"" + beginDate + "\",\"End\":" + "\"" + endDate + "\"}";
        return post;
    }
}