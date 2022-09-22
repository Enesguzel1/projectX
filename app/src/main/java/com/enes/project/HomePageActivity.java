package com.enes.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePageActivity extends AppCompatActivity {
    CardView cardViewBecayis,cardViewAlSat,cardViewSoruCevap,cardViewOneri,cardViewYardım,cardViewAyarlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        cardViewBecayis=findViewById(R.id.cardViewBecayis);
        cardViewAlSat=findViewById(R.id.cardViewAlSat);
        cardViewSoruCevap=findViewById(R.id.cardViewSoruCevap);
        cardViewOneri=findViewById(R.id.cardViewOneri);
        cardViewYardım=findViewById(R.id.cardViewYardım);
        cardViewAyarlar=findViewById(R.id.cardViewAyarlar);
        //yönlendirmeler
        cardViewBecayis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBecayisActivity();
            }
        });

        cardViewAlSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAlSatActivity();
            }
        });

        cardViewSoruCevap.setOnClickListener(new View.OnClickListener() {
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