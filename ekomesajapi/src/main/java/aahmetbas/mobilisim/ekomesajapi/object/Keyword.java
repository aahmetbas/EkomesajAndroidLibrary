package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 4.05.2018.
 */

public class Keyword {
    String serviceNumber = "";
    String value         = "";
    String timeStamp     = "";
    int validity         = 0;

    public Keyword() {
        this.serviceNumber = "";
        this.value = "";
        this.timeStamp = "";
        this.validity = 0;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "ServiceNumber: " + serviceNumber + " Value " + value + " Timestamp: " + timeStamp + " Validity: " + validity;
    }
}