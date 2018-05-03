package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class QueryMulti {
    private String coding;
    private Integer cost;
    private Integer count;
    private Integer deliveredCount;
    private Integer id;
    private String message;
    private String received;
    private String sender;
    private String sent;
    private String state;
    private Integer undeliveredCount;

    public QueryMulti() {
        this.coding     = "";
        this.cost       = 0;
        this.count      = 0;
        this.id         = 0;
        this.message    = "";
        this.received   = "";
        this.sender     = "";
        this.sent       = "";
        this.state      = "";
        this.deliveredCount   = 0;
        this.undeliveredCount = 0;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDeliveredCount() {
        return deliveredCount;
    }

    public void setDeliveredCount(Integer deliveredCount) {
        this.deliveredCount = deliveredCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSent() {
        return sent;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getUndeliveredCount() {
        return undeliveredCount;
    }

    public void setUndeliveredCount(Integer undeliveredCount) {
        this.undeliveredCount = undeliveredCount;
    }

    @Override
    public String toString() {
        String messageTemp = message;
        messageTemp = messageTemp.replace("\n", " ");

        String  temp =  "Coding: " + coding + " Cost: " + cost + " Count: " + count + " Id: " + id + " Message: " + messageTemp;
        temp = temp + " Received: " + received + " Sender: " + sender + " Sent: " + sent + " State: " + state;
        temp = temp + " DeliveredCount: " + deliveredCount + " UndeliveredCount: " + undeliveredCount;
        return  temp;
    }
}
