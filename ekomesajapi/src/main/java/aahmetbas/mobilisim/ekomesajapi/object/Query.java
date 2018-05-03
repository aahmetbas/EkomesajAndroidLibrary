package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class Query {
    private Integer id;
    private Integer network;
    private String msisdn;
    private Integer cost;
    private String submitted;
    private String lastUpdate;
    private String state;
    private Integer sequence;
    private Integer errorCode;
    private String payLoad;
    private String xser;

    public Query() {
        this.id         = 0;
        this.network    = 0;
        this.msisdn     = "";
        this.cost       = 0;
        this.submitted  = "";
        this.lastUpdate = "";
        this.state      = "";
        this.sequence   = 0;
        this.errorCode  = 0;
        this.payLoad    = "";
        this.xser       = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNetwork() {
        return network;
    }

    public void setNetwork(Integer network) {
        this.network = network;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }

    public String getXser() {
        return xser;
    }

    public void setXser(String xser) {
        this.xser = xser;
    }

    @Override
    public String toString() {
        String toString = "Id: " + id + " Network: " + network + " MSISDN: " + msisdn + " Cost: " + cost;
        toString = toString + " Submitted: " + submitted + " LastUpdate: " + lastUpdate + " State: " + state;
        toString = toString + " Sequence: " + sequence + " ErrorCode: " + errorCode + " PayLoad: " + payLoad + " Xser: " + xser;
        return toString;
    }
}