package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 2.05.2018.
 */

public class Envelopes {
    String to;
    String message;

    public Envelopes() {
        this.to = "";
        this.message = "";
    }

    public Envelopes(String to, String message) {
        this.to = to;
        this.message = message;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{\"Message\":\"" + message + "\",\"To\":\"" + to + "\"}";
    }
}
