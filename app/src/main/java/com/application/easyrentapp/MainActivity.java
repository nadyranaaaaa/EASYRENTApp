package com.application.easyrentapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.Iklan);

        bottomNavigationView.setOnNavigationItemReselectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.Iklan:

                case R.id.Tambah:
                    startActivity(new Intent(getApplicationContext(), AddActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return;

                case R.id.Masej:
                    startActivity(new Intent(getApplicationContext(), MessageActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return;

                case R.id.Profil:
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    finish();
                    overridePendingTransition(0, 0);
                    return;
            }
        });
        
    
}}