package com.devzamse.tesis.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

import com.devzamse.tesis.R;
import com.devzamse.tesis.model.Product;

public class ProductDetail extends AppCompatActivity {

    static String url = "https://devzamse.github.io/mapiframe/3d.html";
    public WebView webView;
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        this.initConfig();

        if(getIntent().hasExtra("producto")){
            product = (Product) getIntent().getSerializableExtra("producto");
            Log.e("PRODUCTO",product.toString());
        }

    }

    void initConfig(){
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(this.url);
    }
}