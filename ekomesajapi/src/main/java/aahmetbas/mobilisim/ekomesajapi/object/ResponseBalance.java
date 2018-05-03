package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class ResponseBalance {
    Status status;
    Balance balance;

    public ResponseBalance() {
        this.status = new Status();
        this.balance = new Balance();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
