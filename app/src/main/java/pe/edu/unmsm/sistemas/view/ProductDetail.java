package pe.edu.unmsm.sistemas.view;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import pe.edu.unmsm.sistemas.R;
import pe.edu.unmsm.sistemas.model.Product;

public class ProductDetail extends AppCompatActivity {

    static String url = "https://devzamse.github.io/mapiframe/3d.html";
    public WebView webView;
    ListView listView;
    ArrayAdapter adapter;
    List lista = new ArrayList<>();
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        listView = findViewById(R.id.listView);

        this.initConfig();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(adapter);

        if(getIntent().hasExtra("producto")){
            product = (Product) getIntent().getSerializableExtra("producto");
            Log.e("PRODUCTO",product.toString());
            cargarListaCombate();
        }
    }

    void initConfig(){
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(this.url);

        TextView title = findViewById(R.id.toolbar_base_text);
        title.setText("Detalle del producto");
    }

    void cargarListaCombate(){
        String[] splitCombate = product.getEnfermedadCronicaQueCombate().split(",");
        for(int i=0;i<splitCombate.length;i++){
            lista.add(splitCombate[i]);
        }
        adapter.notifyDataSetChanged();
    }
}