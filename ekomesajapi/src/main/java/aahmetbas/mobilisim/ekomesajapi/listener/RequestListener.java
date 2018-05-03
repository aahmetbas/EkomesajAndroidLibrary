package aahmetbas.mobilisim.ekomesajapi.listener;

/**
 * Created by alp on 30.04.2018.
 */

public interface RequestListener<T> {
    public void onTaskComplete(T response);
}