package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class RequestQuery {
    Credential credential;
    String messageId;
    String msisdn;

    public RequestQuery(Credential credential, String messageId, String msisdn) {
        this.credential = credential;
        this.messageId = messageId;
        this.msisdn = msisdn;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String convertJson(){
        return "{" + credential.toString() + "," + convertString() + "}";
    }

    private String convertString() {
        String post = "\"MessageId\":" + "\"" + messageId + "\",\"MSISDN\":" + "\"" + msisdn + "\"";
        return post;
    }
}