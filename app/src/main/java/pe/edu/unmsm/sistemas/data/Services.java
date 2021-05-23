package pe.edu.unmsm.sistemas.data;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import pe.edu.unmsm.sistemas.model.FinishService;
import pe.edu.unmsm.sistemas.model.Product;

public class Services {

    public void getListaProductos(FinishService finishService){
        List tmp = new ArrayList();
        String res = "";
        String url = "http://ec2-3-137-167-78.us-east-2.compute.amazonaws.com/Productos/v1.0/";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            res = response.body().string();
            Log.e("KIG",res);

        } catch (IOException e) {
            e.printStackTrace();
        }

        finishService.responseService(res);
    }


    public List getProductxCodigo(String codigo){
        List tmp = new ArrayList();
        String url = "http://ec2-3-137-167-78.us-east-2.compute.amazonaws.com//Productos/v1.0/ObtenerInformacionRA/";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n  \"codigoPatron\":\""+codigo+"\"\n}");
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String respuesta = response.body().string();
            Log.e("HOLA", respuesta);
            JSONObject res = new JSONObject(respuesta);
            JSONArray array = res.getJSONArray("listarProductos");
            for (int i = 0; i < array.length(); i++) {
                try{
                    JSONObject json = array.getJSONObject(i);
                    tmp.add(new Product(
                            json.getInt("idProducto"),
                            json.getString("codigoPatron"),
                            json.getString("nombreProducto"),
                            json.getString("codigoProducto"),
                            json.getDouble("precioProducto"),
                            json.getString("enfermedadCronicaQueCombate"),
                            json.getString("regionOriunda"),
                            json.getString("menuAPreparar"),
                            json.getString("localDondeComprar"),
                            json.getString("rutaImagen"),
                            json.getString("rutaImagen3D")
                    ));
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
            return tmp;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();
    }


    public JSONObject sendEmail(int id){
        String url = "18.116.202.159:3000/email";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n  \"id\":"+id+"\n}");
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String respuesta = response.body().string();
            Log.e("HOLA", respuesta);
            JSONObject res = new JSONObject(respuesta);
            return res;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return new JSONObject();
    }

}
