package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class Credential {
    String username = "";
    String password = "";

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String convertJson(){
        return "{" + toString() + "}";
    }

    @Override
    public String toString() {
        String post = "\"Credential\":";
        post = post + "{\"Username\":" + "\"" + username + "\",\"Password\":" + "\"" + password + "\"}";
        return post;
    }
}
