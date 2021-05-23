package pe.edu.unmsm.sistemas.view.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pe.edu.unmsm.sistemas.R;
import pe.edu.unmsm.sistemas.model.Product;

public class RecyclerAyudaAdapter  extends RecyclerView.Adapter<RecyclerAyudaAdapter.ViewHolder>{


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView ayuda;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ayuda = (TextView) itemView.findViewById(R.id.ayuda);
        }
    }


    public List<String> lista;

    public RecyclerAyudaAdapter(){}

    public RecyclerAyudaAdapter (List<String> listaProduct){
        this.lista = listaProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ayuda,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.ayuda.setText("- "+ucFirst(lista.get(i).trim()));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }


    public void actualizar(){
        notifyDataSetChanged();
    }


    public String ucFirst(String str) {
        if (str.isEmpty()) {
            return str;
        } else {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
    }
}
