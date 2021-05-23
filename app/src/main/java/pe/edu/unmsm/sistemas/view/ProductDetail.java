package pe.edu.unmsm.sistemas.view;

import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mercadopago.android.px.core.MercadoPagoCheckout;
import com.mercadopago.android.px.model.Issuer;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import pe.edu.unmsm.sistemas.R;
import pe.edu.unmsm.sistemas.data.Services;
import pe.edu.unmsm.sistemas.model.Product;
import pe.edu.unmsm.sistemas.view.recycler.RecyclerAyudaAdapter;

public class ProductDetail extends AppCompatActivity {
    DecimalFormat df = new DecimalFormat("#.00");
    public WebView webView;
    TextView dondeComprar, precio, regionOriunda, menuPreparar;
    RecyclerView recycler;
    RecyclerAyudaAdapter adapter;
    List lista = new ArrayList<>();
    Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        recycler = findViewById(R.id.recycler);
        dondeComprar = findViewById(R.id.dondeComprar);
        regionOriunda = findViewById(R.id.regionoriunda);
        menuPreparar = findViewById(R.id.menupreparar);
        precio = findViewById(R.id.txtprecio);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAyudaAdapter(lista);
        recycler.setAdapter(adapter);

        if(getIntent().hasExtra("producto")){
            this.product = (Product) getIntent().getSerializableExtra("producto");
            this.initConfig(product);
            dondeComprar.setText(ucFirst(product.getLocalDondeComprar().trim()));
            menuPreparar.setText(ucFirst(product.getMenuAPreparar().trim()));
            regionOriunda.setText(ucFirst(product.getRegionOriunda().trim()));
            precio.setText("PRECIO: S/ "+df.format(product.getPrecioProducto()));
            Log.e("PRODUCTO",product.toString());
            this.cargarListaCombate();
        }
    }

    private void initConfig(Product product){
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(product.getRutaImagen3d());

        TextView title = findViewById(R.id.toolbar_base_text);
        title.setText(product.getNombreProducto().trim().toUpperCase());
    }

    private void cargarListaCombate(){
        String[] splitCombate = product.getEnfermedadCronicaQueCombate().split(",");
        for(int i=0;i<splitCombate.length;i++){
            lista.add(splitCombate[i]);
        }
        adapter.actualizar();
    }

    public void buy(View view) {
        final MercadoPagoCheckout checkout = new MercadoPagoCheckout.Builder(
                "TEST-b110b671-6278-4b16-9e11-4d26083dbeea",
                product.getCodigoPatron()
        ).build();
        checkout.startPayment(ProductDetail.this, 200);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
//
//        Log.e("MERCADO PAGO", requestCode+" "+resultCode);
//
        if(requestCode == 200) {
            Services services = new Services();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        JSONObject json = services.sendEmail(product.getIdProducto());
                        if(json.getBoolean("success")){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    AlertDialog alertDialog = new AlertDialog.Builder(ProductDetail.this).create();
                                    alertDialog.setTitle("Mensaje");
                                    alertDialog.setMessage("Compra satisfactoria");
                                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Entendido",
                                            new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    alertDialog.show();
                                }
                            });
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        AlertDialog alertDialog = new AlertDialog.Builder(ProductDetail.this).create();
                        alertDialog.setTitle("Mensaje");
                        alertDialog.setMessage("Compra satisfactoria");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Entendido",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
            }).start();
            Log.e("RESULTADO TRANS", "TRANSACCION EXISTOSA");
        } else {
            Log.e("RESULTADO TRANS", "TRANSACCION NO EXITOSA");

        }
    }


    public String ucFirst(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    }

}