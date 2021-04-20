package com.devzamse.tesis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devzamse.tesis.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void searchRA(View view) {
        this.goTo(SearchRA.class);
    }

    public void searchProduct(View view) {
        this.goTo(SearchProduct.class);
    }

    public void information(View view) {
        this.goTo(Information.class);
    }

    private void goTo(Class name) {
        Intent i = new Intent(Menu.this, name);
        startActivity(i);
    }
}