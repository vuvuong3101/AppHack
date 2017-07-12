package com.example.rufflez.Cookbook;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.rufflez.Cookbook.adapter.MoreFoodGridAdapter;
import com.example.rufflez.Cookbook.databases.DatabaseHandle;
import com.example.rufflez.Cookbook.utils.Utils;
import com.example.rufflez.myapplication.R;

public class MoreActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MoreActivity.class.toString();
    private GridView grid;
    private Bundle bundle;
    private ImageView imageView;
    private MoreFoodGridAdapter adapter;
    private String isMonSang = "Món sáng", isMonKhaiVi = "Món khai vị", isMonChinh = "Món chính", isMonTrangMieng = "Món tráng miệng";
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_navigation);

        //Toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar_more_food);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.header_more);
        //adapter gridview

        grid = (GridView) findViewById(R.id.grid_view);
        bundle = getIntent().getExtras();
        String typeMoreFood = bundle.getString("isMonSang");
        if (typeMoreFood.equals(isMonSang)) {
            toolbar.setTitle("Món ăn sáng");
            imageView.setImageResource(R.drawable.monsang);
            MoreFoodGridAdapter gridAdapter1 = new MoreFoodGridAdapter(getBaseContext(), Utils.loclist(DatabaseHandle.getHandle(getBaseContext()).getListFood(), "Món sáng"));
            adapter = gridAdapter1;
            grid.setAdapter(gridAdapter1);
        } else if (typeMoreFood.equals(isMonKhaiVi)) {
            imageView.setImageResource(R.drawable.monkhaivi);
            toolbar.setTitle("Món khai vị");
            MoreFoodGridAdapter gridAdapter1 = new MoreFoodGridAdapter(getBaseContext(), Utils.loclist(DatabaseHandle.getHandle(getBaseContext()).getListFood(), "Món khai vị"));
            adapter = gridAdapter1;
            grid.setAdapter(gridAdapter1);
        } else if (typeMoreFood.equals(isMonChinh)) {
            imageView.setImageResource(R.drawable.monchinh);
            toolbar.setTitle("Món chính");
            MoreFoodGridAdapter gridAdapter1 = new MoreFoodGridAdapter(getBaseContext(), Utils.loclist(DatabaseHandle.getHandle(getBaseContext()).getListFood(), "Món chính"));
            adapter = gridAdapter1;
            grid.setAdapter(gridAdapter1);
        } else if (typeMoreFood.equals(isMonTrangMieng)) {
            imageView.setImageResource(R.drawable.montrangmieng);
            toolbar.setTitle("Món tráng miệng");
            MoreFoodGridAdapter gridAdapter1 = new MoreFoodGridAdapter(getBaseContext(), Utils.loclist(DatabaseHandle.getHandle(getBaseContext()).getListFood(), "Món tráng miệng"));
            adapter = gridAdapter1;
            grid.setAdapter(gridAdapter1);
        }

        //Navigation
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_more);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_more);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_more);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) MoreActivity.this.getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MoreActivity.this.getComponentName()));
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent home = new Intent(getBaseContext(), MainActivity.class);
            startActivity(home);
        } else if (id == R.id.nav_mon_sang) {
            Intent intent = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("isMonSang", isMonSang);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (id == R.id.nav_mon_khai_vi) {
            Intent intent2 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("isMonSang", isMonKhaiVi);
            intent2.putExtras(bundle2);
            startActivity(intent2);
        } else if (id == R.id.nav_mon_chinh) {
            Intent intent3 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle3 = new Bundle();
            bundle3.putString("isMonSang", isMonChinh);
            intent3.putExtras(bundle3);
            startActivity(intent3);
        } else if (id == R.id.nav_mon_trang_mieng) {
            Intent intent4 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle4 = new Bundle();
            bundle4.putString("isMonSang", isMonTrangMieng);
            intent4.putExtras(bundle4);
            startActivity(intent4);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_more);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
