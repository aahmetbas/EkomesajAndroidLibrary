package aahmetbas.mobilisim.ekomesajapi.object;

import java.util.ArrayList;

/**
 * Created by alp on 2.05.2018.
 */

public class SubmitMulti {
    String dataCoding;
    String message;
    Header header;
    ArrayList<Envelopes> envelopes;

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

    public ArrayList<Envelopes> getEnvelopes() {
        return envelopes;
    }

    public void setEnvelopes(ArrayList<Envelopes> envelopes) {
        this.envelopes = envelopes;
    }

    public String convertJson(){
        String post = "\"DataCoding\":" + "\"" + dataCoding + "\"," + header.toString();
        post = post + ",\"Envelopes\":" + "[" + convertList() + "]";
        return  post;
    }

    private String convertList(){
        String post = "";
        for (int i = 0; i < envelopes.size() - 1; i++) {
            post = post + envelopes.get(i) + ",";
        }

        if(0 < envelopes.size()) {
            post = post + envelopes.get(envelopes.size() - 1);
        }

        return post;
    }
}