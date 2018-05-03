package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class Balance {
    int limit;
    int main;

    public Balance() {
        this.limit = 0;
        this.main = 0;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getMain() {
        return main;
    }

    public void setMain(int main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "Balance:{" + "\"Main" + main + "\"," + "\"Limit" + limit + "\"}";
    }
}
