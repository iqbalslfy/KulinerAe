package net.kulinerae.kulinerae.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.kulinerae.kulinerae.Data.MenuToko;
import net.kulinerae.kulinerae.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 31/10/2017.
 */

class RecyclerViewHolerToko extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView textNamaToko;

    public RecyclerViewHolerToko(View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.img_toko);
        textNamaToko = (TextView)itemView.findViewById(R.id.txtNamaToko);

    }
}

public class RecyclerViewAd_Toko extends RecyclerView.Adapter<RecyclerViewHolerToko>{
    private List<MenuToko> tokoList = new ArrayList<>();

    public RecyclerViewAd_Toko(List<MenuToko> tokoList) {
        this.tokoList = tokoList;
    }


    @Override
    public RecyclerViewHolerToko onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_toko, parent, false);
        return new RecyclerViewHolerToko(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolerToko holder, int position) {
        holder.imageView.setImageResource(tokoList.get(position).getGambar());
        holder.textNamaToko.setText(tokoList.get(position).getNama_toko());
    }

    @Override
    public int getItemCount() {
        return tokoList.size();
    }
}
