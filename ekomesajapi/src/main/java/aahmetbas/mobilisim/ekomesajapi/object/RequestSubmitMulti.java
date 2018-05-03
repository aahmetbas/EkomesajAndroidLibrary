package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 2.05.2018.
 */

public class RequestSubmitMulti {
    Credential credential;
    SubmitMulti submitMulti;

    public RequestSubmitMulti(Credential credential, SubmitMulti submitMulti) {
        this.credential = credential;
        this.submitMulti = submitMulti;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public SubmitMulti getSubmitMulti() {
        return submitMulti;
    }

    public void setSubmitMulti(SubmitMulti submitMulti) {
        this.submitMulti = submitMulti;
    }

    public String convertJson(){
        return "{" + credential.toString() + "," + submitMulti.convertJson() + "}";
    }
}
