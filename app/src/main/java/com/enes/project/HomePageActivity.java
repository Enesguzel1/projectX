package com.enes.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);




    }

    public void goToBecayisActivity(){
        Intent intent=new Intent(HomePageActivity.this,BecayisActivity.class);
        startActivity(intent);
    }
    public void goToAlSatActivity(){
        Intent intent=new Intent(HomePageActivity.this,AlSatActivity.class);
        startActivity(intent);
    }
    public void goToSoruCevapActivity(){
        Intent intent=new Intent(HomePageActivity.this,SoruCevapActivity.class);
        startActivity(intent);
    }


}