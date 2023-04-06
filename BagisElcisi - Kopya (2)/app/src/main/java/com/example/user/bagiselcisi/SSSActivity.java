package com.example.user.bagiselcisi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SSSActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sss);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Spinner mySpinner1;
        mySpinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter1= new ArrayAdapter<String>(SSSActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.SSS));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(myAdapter1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.anasayfa) {
            Intent intent= new Intent(SSSActivity.this,MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.hastaneler) {
            Intent intent= new Intent(SSSActivity.this,HospitalActivity.class);
            startActivity(intent);
        } else if (id == R.id.sss) {
            Intent intent= new Intent(SSSActivity.this,SSSActivity.class);
            startActivity(intent);
        } else if (id == R.id.kullanıcı_hesabı) {
            Intent intent= new Intent(SSSActivity.this,UserActivity.class);
            startActivity(intent);
        }else if (id == R.id.maps) {
            Intent intent= new Intent(SSSActivity.this,MapsActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.bildirimler) {
            Intent intent= new Intent(SSSActivity.this,BildirimActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
