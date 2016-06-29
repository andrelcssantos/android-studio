package app.com.br.teste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Andre on 27/05/2016.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(SplashActivity.this, app.com.br.calculoimc.splash.MainActivity.class);
        startActivity(intent);
        finish();
    }
}
