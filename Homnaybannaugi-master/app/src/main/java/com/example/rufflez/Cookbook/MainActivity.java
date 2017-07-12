package com.example.rufflez.Cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.Cookbook.fragments.FavoritesFragment;
import com.example.rufflez.Cookbook.fragments.HomeFragment;
import com.example.rufflez.Cookbook.fragments.ShoppingListFragment;
import com.example.rufflez.myapplication.R;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private MaterialSearchView searchView;
    private BottomBar bottomBar;
    FoodModel foodModel;
    private Toolbar toolbar;
    private String isMonSang = "Món sáng", isMonKhaiVi = "Món khai vị" , isMonChinh = "Món chính" , isMonTrangMieng = "Món tráng miệng";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //HomeFragment
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFragment).commit();
        toolbar.setTitle("Hôm nay bạn nấu gì?");
        //
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Search
        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
        searchView.setEllipsize(true);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(getSupportFragmentManager().getBackStackEntryCount()==1){
            finish();
        }else{
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            HomeFragment homeFragment = new HomeFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content,homeFragment);
            ft.addToBackStack(homeFragment.getClass().getName());
            ft.commit();
            toolbar.setTitle("Hôm nay bạn nấu gì?");

        } else if (id == R.id.nav_fav) {
            FavoritesFragment favoritesFragment = new FavoritesFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content,favoritesFragment);
            ft.addToBackStack(favoritesFragment.getClass().getName());
            ft.commit();
            toolbar.setTitle("Món ăn yêu thích của bạn");
        } else if (id == R.id.nav_shop) {
            ShoppingListFragment shoppingListFragment = new ShoppingListFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content,shoppingListFragment);
            ft.addToBackStack(shoppingListFragment.getClass().getName());
            ft.commit();
            toolbar.setTitle("Đi chợ mua gì?");
        } else if (id == R.id.nav_mon_sang) {
            Intent intent = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("isMonSang" , isMonSang);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (id == R.id.nav_mon_khai_vi) {
            Intent intent2 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("isMonSang" , isMonKhaiVi);
            intent2.putExtras(bundle2);
            startActivity(intent2);
        } else if (id == R.id.nav_mon_chinh) {
            Intent intent3 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle3 = new Bundle();
            bundle3.putString("isMonSang" , isMonChinh);
            intent3.putExtras(bundle3);
            startActivity(intent3);
        } else if (id == R.id.nav_mon_trang_mieng) {
            Intent intent4 = new Intent(getBaseContext(), MoreActivity.class);
            Bundle bundle4 = new Bundle();
            bundle4.putString("isMonSang" , isMonTrangMieng);
            intent4.putExtras(bundle4);
            startActivity(intent4);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
