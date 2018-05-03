package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 2.05.2018.
 */

public class Header {
    String from;
    String scheduledDeliveryTime;
    int validityPeriod;

    public Header() {
        this.from = "";
        this.scheduledDeliveryTime = "";
        this.validityPeriod = 0;
    }

    public Header(String from, int validityPeriod) {
        this.from = from;
        this.validityPeriod = validityPeriod;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(int validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getScheduledDeliveryTime() {
        return scheduledDeliveryTime;
    }

    public void setScheduledDeliveryTime(String scheduledDeliveryTime) {
        this.scheduledDeliveryTime = scheduledDeliveryTime;
    }

    @Override
    public String toString() {
        String post = "\"Header\":{\"From\":" + "\"" + from + "\",\"ValidityPeriod\":" + validityPeriod + ",\"ScheduledDeliveryTime\":\"" + scheduledDeliveryTime + "\"}";
        return post;
    }
}