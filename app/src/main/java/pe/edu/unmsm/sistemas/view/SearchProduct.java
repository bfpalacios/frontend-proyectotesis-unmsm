package pe.edu.unmsm.sistemas.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.edu.unmsm.sistemas.R;
import pe.edu.unmsm.sistemas.data.Services;
import pe.edu.unmsm.sistemas.model.Product;
import pe.edu.unmsm.sistemas.view.recycler.RecyclerProductAdapter;

public class SearchProduct extends AppCompatActivity {

    List<Product> listaProductos = new ArrayList();
    RecyclerView recyclerView;
    RecyclerProductAdapter productAdapter;
    EditText txtsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        txtsearch = findViewById(R.id.editTextTextPersonName);
        recyclerView = findViewById(R.id.listView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new RecyclerProductAdapter(listaProductos);
        recyclerView.setAdapter(productAdapter);

        this.initConfig();
        this.getCargarLista();

        productAdapter.setOnItemClickListener(new RecyclerProductAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Bundle bundle=new Bundle();
                bundle.putSerializable("producto", listaProductos.get(position));
                Intent intent = new Intent(SearchProduct.this, ProductDetail.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        txtsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0){
                    List<Product> tmp = new ArrayList();
                    for(Product p: listaProductos){
                        if(p.getNombreProducto().contains(s.toString())){
                            tmp.add(p);
                        }
                    }
                    productAdapter.searchProduct(tmp);
                }else{
                    productAdapter.searchProduct(listaProductos);
                }
            }
        });

    }

    private void initConfig() {
        TextView title = findViewById(R.id.toolbar_base_text);
        title.setText("Buscar producto");
    }

    public void getCargarLista() {

        Services services = new Services();
        new Thread(new Runnable() {
            @Override
            public void run() {
                listaProductos = services.getListaProductos();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        productAdapter.actualizar();
                    }
                });
            }
        }).start();
    }


}