package pe.edu.unmsm.sistemas.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import pe.edu.unmsm.sistemas.R;


public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        this.Init();
    }
    
    private void Init(){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Menu.class);
                startActivity(i);
            }
        }, 2050);
    }
}