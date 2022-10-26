package org.iesch.practica1.practica5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Album> lista;
    private Context context;

    public Adaptador(ArrayList<Album> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Album getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Album album = getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item_musica, null);
        ImageView imgAlbum = view.findViewById(R.id.imgAlbum);
        TextView txtArtista = view.findViewById(R.id.txtArtista);
        TextView txtAno = view.findViewById(R.id.txtAño);
        TextView txtAlbum = view.findViewById(R.id.txtAlbum);

        imgAlbum.setImageResource(album.getFoto());
        txtArtista.setText(album.getCantante());
        txtAlbum.setText(album.getTitulo());
        txtAno.setText(album.getAno());

        return view;
    }
}
