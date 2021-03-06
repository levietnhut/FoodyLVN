package com.nhutdu.foodylvn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.nhutdu.core.view.BaseActivity;
import com.nhutdu.core.view.Navigator;
import com.nhutdu.core.viewmodel.MainViewModel;
import com.nhutdu.foodylvn.App;
import com.nhutdu.foodylvn.R;
import com.nhutdu.foodylvn.adapters.ViewPagerAdapter;
import com.nhutdu.foodylvn.databinding.ActivityMainBinding;
import com.nhutdu.foodylvn.fragments.CategoryFragment;
import com.nhutdu.foodylvn.fragments.LatestRestaurantsFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel>
        implements NavigationView.OnNavigationItemSelectedListener {
    Navigator mNavigator;
    TabLayout mTabLayout;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.sharedComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().show();
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LatestRestaurantsFragment(), "Latest News");
        adapter.addFragment(new CategoryFragment(), "Category");
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("DISMISS", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_create_news) {
            startActivity(new Intent(MainActivity.this,CreateRestaurantActivity.class));
        } else if (id == R.id.nav_about) {
            startActivity(new Intent(MainActivity.this,AboutActivity.class));
        } else if (id == R.id.nav_contact) {
            startActivity(new Intent(MainActivity.this,ContactActivity.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
