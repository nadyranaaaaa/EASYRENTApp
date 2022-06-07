package com.application.easyrentapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.application.easyrentapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.Iklan);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.Iklan:

                    case R.id.Tambah:
                        startActivity(new Intent(getApplicationContext(),AddActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.Masej:
                        startActivity(new Intent(getApplicationContext(),MessageActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;

                    case R.id.Profil:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return;
                }
            }
        });
    }
}
