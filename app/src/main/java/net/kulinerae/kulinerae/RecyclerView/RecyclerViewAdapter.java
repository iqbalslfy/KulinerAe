package net.kulinerae.kulinerae.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.kulinerae.kulinerae.Data.MenuItems;
import net.kulinerae.kulinerae.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SONY on 30/10/2017.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public TextView txtMenuItem;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        txtMenuItem = (TextView)itemView.findViewById(R.id.txtMenuItems);
    }
}

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private List<MenuItems> itemsList = new ArrayList<>();

    public RecyclerViewAdapter(List<MenuItems> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu, parent, false);

        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.txtMenuItem.setText(itemsList.get(position).getItem());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}

