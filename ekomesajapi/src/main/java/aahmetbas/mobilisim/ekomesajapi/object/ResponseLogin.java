package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class ResponseLogin {
    Status status;
    int userId;

    public ResponseLogin() {
        this.status = new Status();
        this.userId = 0;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserId:" + userId;
    }
}