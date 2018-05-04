package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 4.05.2018.
 */

public class ResponseSetting {
    Status status;
    Settings settings;

    public ResponseSetting() {
        this.status = new Status();
        this.settings = new Settings();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
