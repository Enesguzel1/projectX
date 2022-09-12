package com.enes.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.enes.project.Fragments.AlSatHomePageFragment;
import com.enes.project.Fragments.myAdvertiseFragment;
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
                int itemId = item.getItemId();
                if (itemId == R.id.menu_al_sat_home) {
                    Toast.makeText(AlSatActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                    setFragment(new AlSatHomePageFragment());
                } else if (itemId == R.id.menu_al_sat_advertise) {
                    bottomSheetDialog();
                    Toast.makeText(AlSatActivity.this, "Adversite", Toast.LENGTH_SHORT).show();
                } else if (itemId == R.id.menu_al_sat_my_advertise) {
                    Toast.makeText(AlSatActivity.this, "My Adversite", Toast.LENGTH_SHORT).show();
                    setFragment(new myAdvertiseFragment());
                } else if (itemId == R.id.menu_al_sat_my_profile) {
                    Toast.makeText(AlSatActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerView2, fragment);
        transaction.commit();
    }

    private void bottomSheetDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.al_sat_bottom_sheet_modal);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations =R.style.DialoAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

}