package aahmetbas.mobilisim.ekomesajapi.object;

/**
 * Created by alp on 30.04.2018.
 */

public class QueryStats {
    private int year;
    private int month;
    private int delivered;
    private int undelivered;
    private int count;

    public QueryStats() {
        this.year        = 0;
        this.month       = 0;
        this.delivered   = 0;
        this.undelivered = 0;
        this.count       = 0;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDelivered() {
        return delivered;
    }

    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    public int getUndelivered() {
        return undelivered;
    }

    public void setUndelivered(int undelivered) {
        this.undelivered = undelivered;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Year: " + year + " Month: " + month + " Delivered: " + delivered + " Undelivered: " + undelivered + " Count: " + count;
    }
}
