package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 4.05.2018.
 */

public class OperatorSettings {
    String account = "";
    String msisdn  = "";
    String variantId = "";
    String serviceId = "";
    int unitPrice = 0;

    public OperatorSettings() {
        this.account = "";
        this.msisdn = "";
        this.variantId = "";
        this.serviceId = "";
        this.unitPrice = 0;
    }

    public OperatorSettings(String account, String msisdn, String variantId, String serviceId, int unitPrice) {
        this.account = account;
        this.msisdn = msisdn;
        this.variantId = variantId;
        this.serviceId = serviceId;
        this.unitPrice = unitPrice;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        String str = "Account: " + account + " MSISDN: " + msisdn + " VariantId: " + variantId;
        str = str + " ServiceId: " + serviceId + " UnitPrice: " + unitPrice;
        return str;
    }
}