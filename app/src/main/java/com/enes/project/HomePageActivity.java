package com.enes.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {
    private Button becayisButton,alSatButton,soruCevapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        becayisButton = findViewById(R.id.becayisButton);
        alSatButton = findViewById(R.id.alSatButton);
        soruCevapButton = findViewById(R.id.soruCevapButton);

        //aktivitelere yönlendirme
        becayisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBecayisActivity();
            }
        });
        alSatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAlSatActivity();
            }
        });
        soruCevapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSoruCevapActivity();
            }
        });



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