package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 2.05.2018.
 */

public class ResponseSubmitMulti {
    int messageId;
    Status status;

    public ResponseSubmitMulti() {
        this.messageId = 0;
        this.status = new Status();;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MessageId: " + messageId;
    }
}
