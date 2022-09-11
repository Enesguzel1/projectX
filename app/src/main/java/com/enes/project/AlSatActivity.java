package com.enes.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AlSatActivity extends AppCompatActivity {
    private BottomNavigationView alSatNavBottomMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_sat);

        alSatNavBottomMenu = findViewById(R.id.alSatNavBottomMenu);

        alSatNavBottomMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_al_sat_home:
                        Toast.makeText(AlSatActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_al_sat_advertise:
                        Toast.makeText(AlSatActivity.this, "Adversite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_al_sat_my_advertise:
                        Toast.makeText(AlSatActivity.this, "My Adversite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_al_sat_my_profile:
                        Toast.makeText(AlSatActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
    }

}