package aahmetbas.mobilisim.ekomesajapi.object;

import java.util.ArrayList;

/**
 * Created by alp on 4.05.2018.
 */

public class Settings {
    Balance balance = new Balance();
    ArrayList<Sender> senders = new ArrayList<>();
    ArrayList<Keyword> keywords = new ArrayList<>();
    OperatorSettings operatorSettings = new OperatorSettings();

    public Settings() {
        this.balance = new Balance();
        this.senders = new ArrayList<>();
        this.keywords = new ArrayList<>();
        this.operatorSettings =  new OperatorSettings();
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public ArrayList<Sender> getSenders() {
        return senders;
    }

    public void setSenders(ArrayList<Sender> senders) {
        this.senders = senders;
    }

    public ArrayList<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<Keyword> keywords) {
        this.keywords = keywords;
    }

    public OperatorSettings getOperatorSettings() {
        return operatorSettings;
    }

    public void setOperatorSettings(OperatorSettings operatorSettings) {
        this.operatorSettings = operatorSettings;
    }
}
