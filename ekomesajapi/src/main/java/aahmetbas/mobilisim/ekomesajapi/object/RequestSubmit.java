package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 2.05.2018.
 */

public class RequestSubmit {
    Credential credential;
    Submit submit;

    public RequestSubmit(Credential credential, Submit submit) {
        this.credential = credential;
        this.submit = submit;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Submit getSubmit() {
        return submit;
    }

    public void setSubmit(Submit submit) {
        this.submit = submit;
    }

    public String convertJson(){
        return "{" + credential.toString() + "," + submit.convertJson() + "}";
    }
}
