package com.example.studentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        navController= Navigation.findNavController(this,R.id.frame_layout);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation_View);

        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_devoloper:
                gotoDevolopers();
                Toast.makeText(this, "Devoloper", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_theme:
                Toast.makeText(this, "Theme", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_website:
                gotoUrl("https://www.siberindia.edu.in/");
                Toast.makeText(this, "Website", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_rate:
                Toast.makeText(this, "Rate", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    private void gotoDevolopers() {
        startActivity(new Intent(this,DevolopersAS.class));
    }

    private void gotoUrl(String s) {
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}