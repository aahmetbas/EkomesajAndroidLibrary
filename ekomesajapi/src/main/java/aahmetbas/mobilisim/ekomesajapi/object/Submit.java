package aahmetbas.mobilisim.ekomesajapi.object;

import java.util.ArrayList;

/**
 * Created by alp on 2.05.2018.
 */

public class Submit {
    String dataCoding;
    String message;
    Header header;
    ArrayList<String> to;

    public Submit() {
        this.dataCoding = "";
        this.message = "";
        this.header = new Header();
        this.to = new ArrayList<>();
    }

    public String getDataCoding() {
        return dataCoding;
    }

    public void setDataCoding(String dataCoding) {
        this.dataCoding = dataCoding;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public ArrayList<String> getTo() {
        return to;
    }

    public void setTo(ArrayList<String> to) {
        this.to = to;
    }

    public String convertJson(){
        String post = "\"DataCoding\":" + "\"" + dataCoding + "\"," + header.toString() + ",\"Message\":" + "\"" + message + "\",";
        post = post + "\"To\":" + "[" + convertList() + "]";
        return  post;
    }

    private String convertList(){
        String post = "";
        for (int i = 0; i < to.size() - 1; i++) {
            post = post + "\"" + to.get(i) + "\",";
        }

        if(0 < to.size()) {
            post = post + "\"" + to.get(to.size() - 1) + "\"";
        }

        return post;
    }
}
