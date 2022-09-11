package com.enes.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.enes.project.Fragments.BecayisHomePageFragment;
import com.enes.project.Fragments.BecayisHomePageFragmentDirections;
import com.enes.project.Fragments.IlanEkleFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.ramotion.circlemenu.CircleMenuView;

public class BecayisActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_becayis);
        // last commit

        final CircleMenuView circleMenu=findViewById(R.id.circleMenu);

        circleMenu.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view){

            }
            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view,int buttonIndex){
                super.onButtonClickAnimationStart(view,buttonIndex);
                switch (buttonIndex){
                    case 0:
                        Toast.makeText(BecayisActivity.this, "İlan Ekle", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(BecayisActivity.this, "Profilim", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(BecayisActivity.this, "Ana Sayfa", Toast.LENGTH_SHORT).show();
                        break;



                }
            }

        });


        //

        bottomNavigationView=findViewById(R.id.becayis_bottom_nav_menu);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_becayis_anaMenu:
                        replaceFragment(new BecayisHomePageFragment());
                        break;
                    case R.id.menu_becayis_profil:
                        break;
                    case R.id.menu_becayis_ilanEkle:
                        replaceFragment(new IlanEkleFragment());



                }


                return false;
            }
        });

    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView_becayis,fragment);
        fragmentTransaction.commit();

    }

}