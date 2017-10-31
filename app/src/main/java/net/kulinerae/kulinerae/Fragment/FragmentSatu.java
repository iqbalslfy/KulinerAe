package net.kulinerae.kulinerae.Fragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.kulinerae.kulinerae.Data.MenuItems;
import net.kulinerae.kulinerae.Data.MenuToko;
import net.kulinerae.kulinerae.R;
import net.kulinerae.kulinerae.RecyclerView.RecyclerViewAd_Toko;
import net.kulinerae.kulinerae.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentSatu extends Fragment {
    private RecyclerView recyclerView, recyclerViewToko;
    private RecyclerViewAdapter viewAdapter;
    private RecyclerViewAd_Toko viewAdapterToko;
    private RecyclerView.LayoutManager layoutManager, layoutManagerToko;
    private List<MenuItems> itemsList = new ArrayList<>();
    private List<MenuToko> tokoList = new ArrayList<>();

    public FragmentSatu() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_satu, container, false );
        View view = inflater.inflate(R.layout.fragment_satu,container, false);

        runDataMenu();
        runDataToko();

        recyclerView = view.findViewById(R.id.rc_menu);
        recyclerViewToko = view.findViewById(R.id.rc_menu_toko);

        recyclerView.setHasFixedSize(true);
        recyclerViewToko.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManagerToko = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        recyclerViewToko.setLayoutManager(layoutManagerToko);
        recyclerView.setLayoutManager(layoutManager);

        viewAdapter = new RecyclerViewAdapter(itemsList);
        viewAdapterToko = new RecyclerViewAd_Toko(tokoList);

        recyclerView.setAdapter(viewAdapter);
        recyclerViewToko.setAdapter(viewAdapterToko);

        return view;
    }

    private void runDataMenu() {
        itemsList.add(new MenuItems("ANEKA AYAM"));
        itemsList.add(new MenuItems("ANEKA BEBEK"));
        itemsList.add(new MenuItems("PILIHAN EDITOR"));
        itemsList.add(new MenuItems("ANEKA NASI"));
        itemsList.add(new MenuItems("BAKMI"));
        itemsList.add(new MenuItems("BAKSO"));
        itemsList.add(new MenuItems("BURGER"));
        itemsList.add(new MenuItems("SANDWICH"));
        itemsList.add(new MenuItems("CHINESE"));

    }

    private void runDataToko(){
        tokoList.add(new MenuToko(R.drawable.daebak, "Daebak Cafe"));
        tokoList.add(new MenuToko(R.drawable.kedai, "Kedai Cafe"));
        tokoList.add(new MenuToko(R.drawable.pencake, "Pencake Cafe"));
        tokoList.add(new MenuToko(R.drawable.pondok, "Pondok Cafe"));
        tokoList.add(new MenuToko(R.drawable.layar, "Layar Cafe"));
    }


}
