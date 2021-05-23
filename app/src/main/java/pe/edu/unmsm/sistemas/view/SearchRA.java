package pe.edu.unmsm.sistemas.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

import pe.edu.unmsm.sistemas.R;
import pe.edu.unmsm.sistemas.data.Services;
import pe.edu.unmsm.sistemas.model.Product;

public class SearchRA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_r);
        this.ScanQr();
//        Services services = new Services();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                List<Product> list = services.getProductxCodigo("1234");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if(list.size()>0){
//                            Bundle bundle=new Bundle();
//                            bundle.putSerializable("producto", list.get(0));
//                            Intent intent = new Intent(SearchRA.this, ProductDetail.class);
//                            intent.putExtras(bundle);
//                            startActivity(intent);
//                        }else{
//                            //NO ENCONTRO NADA
//                        }
//                    }
//                });
//            }
//        }).start();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            Log.e("resultado", result.getContents());
            Services services = new Services();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Product> list = services.getProductxCodigo(result.getContents());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(list.size()>0){
                                Bundle bundle=new Bundle();
                                bundle.putSerializable("producto", list.get(0));
                                Intent intent = new Intent(SearchRA.this, ProductDetail.class);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }else{
                                //NO ENCONTRO NADA
                            }
                        }
                    });
                }
            }).start();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    private void ScanQr() {
        new IntentIntegrator(SearchRA.this).initiateScan();
        new IntentIntegrator(SearchRA.this).setPrompt("Escanea un producto");
    }
}