package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 4.05.2018.
 */

public class Sender {
    String value = "";
    Boolean isDefault = false;

    public Sender() {
        this.value = "";
        this.isDefault = false;
    }

    public Sender(String value, Boolean isDefault) {
        this.value = value;
        this.isDefault = isDefault;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    @Override
    public String toString() {
        return "Value: " + value + " Default: " + isDefault;
    }
}
