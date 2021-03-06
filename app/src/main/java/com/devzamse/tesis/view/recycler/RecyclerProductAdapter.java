package com.devzamse.tesis.view.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devzamse.tesis.R;
import com.devzamse.tesis.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerProductAdapter extends RecyclerView.Adapter<RecyclerProductAdapter.ViewHolder> {

    private OnItemClickListener mListener;
    Context ctx;

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivimagen;
        TextView txtnombre, txtcodigo, txtprecio;

        public ViewHolder(@androidx.annotation.NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            ivimagen = (ImageView) itemView.findViewById(R.id.ivimagen);
            txtnombre = (TextView) itemView.findViewById(R.id.txtnombre);
            txtcodigo = (TextView) itemView.findViewById(R.id.txtcodigo);
            txtprecio = (TextView) itemView.findViewById(R.id.txtprecio);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }


    public List<Product> listaProduct;

    public RecyclerProductAdapter(){}

    public RecyclerProductAdapter (List<Product> listaProduct){
        this.listaProduct = listaProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery,parent,false);

        ctx = parent.getContext();

        ViewHolder viewHolder = new ViewHolder(view, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Picasso.get().load(listaProduct.get(i).getRutaImagen()).fit().into(holder.ivimagen);
        holder.txtnombre.setText(listaProduct.get(i).getNombreProducto());
        holder.txtcodigo.setText("cod: "+ listaProduct.get(i).getCodigoProducto());
        holder.txtprecio.setText("Precio unitario: "+ listaProduct.get(i).getPrecioProducto());
    }

    @Override
    public int getItemCount() {
        return listaProduct.size();
    }

    public void searchProduct(List<Product> tmpLista){
        this.listaProduct = tmpLista;
        notifyDataSetChanged();
    }

}
