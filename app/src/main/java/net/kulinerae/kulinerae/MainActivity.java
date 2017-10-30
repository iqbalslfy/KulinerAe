package net.kulinerae.kulinerae;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import net.kulinerae.kulinerae.Activity.Setting;
import net.kulinerae.kulinerae.Data.MenuItems;
import net.kulinerae.kulinerae.Fragment.FragmentDua;
import net.kulinerae.kulinerae.Fragment.FragmentSatu;
import net.kulinerae.kulinerae.Fragment.FragmentTiga;
import net.kulinerae.kulinerae.RecyclerView.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter viewAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<MenuItems> itemsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();


        final NavigationView view = (NavigationView) findViewById(R.id.nav_view);
        view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_menu1){
                   mDrawerLayout.closeDrawer(id);
                }

                if (id == R.id.nav_menu2){

                    startActivity(new Intent(MainActivity.this, Setting.class));
                    mDrawerLayout.closeDrawers();
                }

                if (id == R.id.nav_menu3){
                    Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_SHORT).show();

                }

                return true;
            }
        });

        runDataMenu();
        recyclerView = (RecyclerView)findViewById(R.id.rc_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        viewAdapter = new RecyclerViewAdapter(itemsList);
        recyclerView.setAdapter(viewAdapter);
    }

    private void runDataMenu() {
        itemsList.add(new MenuItems("Menu 1"));
        itemsList.add(new MenuItems("Menu 2"));
        itemsList.add(new MenuItems("Menu 3"));
        itemsList.add(new MenuItems("Menu 4"));
        itemsList.add(new MenuItems("Menu 5"));
        itemsList.add(new MenuItems("Menu 6"));
        itemsList.add(new MenuItems("Menu 7"));
        itemsList.add(new MenuItems("Menu 8"));
        itemsList.add(new MenuItems("Menu 9"));
        itemsList.add(new MenuItems("Menu 10"));

    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentSatu(), "SATU");
        adapter.addFrag(new FragmentDua(), "DUA");
        adapter.addFrag(new FragmentTiga(), "TIGA");
        adapter.addFrag(new FragmentSatu(), "EMPAT");
        adapter.addFrag(new FragmentDua(), "LIMA");
        adapter.addFrag(new FragmentTiga(), "ENAM");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentTitleList.size();
        }

        public void addFrag (Fragment fragment, String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
