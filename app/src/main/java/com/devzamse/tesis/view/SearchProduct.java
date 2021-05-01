package com.devzamse.tesis.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.devzamse.tesis.R;
import com.devzamse.tesis.model.Product;
import com.devzamse.tesis.view.recycler.RecyclerProductAdapter;

import java.util.ArrayList;
import java.util.List;

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
        recyclerView = findViewById(R.id.recyclerView);

        getCargarLista();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new RecyclerProductAdapter(listaProductos);
        recyclerView.setAdapter(productAdapter);


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

    public void getCargarLista(){

        listaProductos.add(new Product(
                    "camu camu1", "camu01",21.0,"diabetes,hipertension,colesterol",
                    "Region Selva","menu 2", "Metro Colonial",
                    "https://productosra.s3.us-east-2.amazonaws.com/productos2d/camu_camu.png"));
        listaProductos.add(new Product(
                    "camu camu2", "camu02",22.0,"diabetes,hipertension,colesterol",
                    "Region Selva","menu 1", "Metro Colonial",
                    "https://productosra.s3.us-east-2.amazonaws.com/productos2d/camu_camu.png"));
        listaProductos.add(new Product(
                    "camu camu3", "camu03",23.0,"diabetes,hipertension,colesterol",
                    "Region Selva","menu 3", "Metro Colonial",
                    "https://productosra.s3.us-east-2.amazonaws.com/productos2d/camu_camu.png"));
        listaProductos.add(new Product(
                    "camu camu4", "camu04",24.0,"diabetes,hipertension,colesterol",
                    "Region Selva","menu 4", "Metro Colonial",
                    "https://productosra.s3.us-east-2.amazonaws.com/productos2d/camu_camu.png"));
        listaProductos.add(new Product(
                    "camu camu5", "camu05",25.0,"diabetes,hipertension,colesterol",
                    "Region Selva","menu 5", "Metro Colonial",
                    "https://productosra.s3.us-east-2.amazonaws.com/productos2d/camu_camu.png"));
        listaProductos.add(new Product(
                    "camu camu6", "camu06",26.0,"diabetes,hipertension,colesterol",
                    "Region Selva","menu 6", "Metro Colonial",
                    "https://productosra.s3.us-east-2.amazonaws.com/productos2d/camu_camu.png"));
    }



}