package app.com.br.teste;

import android.app.Application;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

/**
 * Created by Andre on 27/05/2016.
 */
public class TimeActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(TimeUnit.SECONDS.toMillis(3));
    }
}
