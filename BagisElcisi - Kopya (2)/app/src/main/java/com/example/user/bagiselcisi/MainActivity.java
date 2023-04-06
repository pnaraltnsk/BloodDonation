package com.example.user.bagiselcisi;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;
    private Button buttonregister,buttonlogin;
    public void init(){
        buttonlogin=(Button) findViewById(R.id.buttonlogin);
        buttonregister=(Button) findViewById(R.id.buttonregister);


        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin= new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intentLogin);
            }
        });

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intentLogin);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();

        VideoView videoView = findViewById(R.id.video);
        String videoPath="android.resource://" + getPackageName() + "/" +R.raw.video;
        Uri uri= Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController= new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
            Intent intent= new Intent(MainActivity.this,MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.hastaneler) {
            Intent intent= new Intent(MainActivity.this,HospitalActivity.class);
            startActivity(intent);
        } else if (id == R.id.sss) {
            Intent intent= new Intent(MainActivity.this,SSSActivity.class);
            startActivity(intent);
        } else if (id == R.id.kullanıcı_hesabı) {
            Intent intent= new Intent(MainActivity.this,UserActivity.class);
            startActivity(intent);
        }else if (id == R.id.maps) {
            Intent intent= new Intent(MainActivity.this,MapsActivity.class);
            startActivity(intent);
        }else if (id == R.id.bildirimler) {
            Intent intent= new Intent(MainActivity.this,BildirimActivity.class);
            startActivity(intent);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
