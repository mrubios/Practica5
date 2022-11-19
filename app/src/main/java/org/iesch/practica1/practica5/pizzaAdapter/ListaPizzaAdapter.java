package org.iesch.practica1.practica5.pizzaAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.iesch.practica1.practica5.R;
import org.iesch.practica1.practica5.modelo.Pizza;

import java.util.ArrayList;
import java.util.List;

public class ListaPizzaAdapter extends RecyclerView.Adapter<ListaPizzaAdapter.ViewHolder> {

    private List<Pizza> dataset;
    private Context context;

    public ListaPizzaAdapter(Context context){
        this.context=context;
        this.dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaPizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPizzaAdapter.ViewHolder holder, int position) {
        Pizza p = dataset.get(position);
        holder.nombreTextView.setText(p.getName());
        holder.descripcionTextView.setText(p.getDescription());

        Glide.with(context).load(p.getImage()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarPizza(List<Pizza> listaPizza) {
        this.dataset.addAll(listaPizza);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoImageView;
        private TextView nombreTextView;
        private TextView descripcionTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoImageView = itemView.findViewById(R.id.fotoImageView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
        }
    }
}
