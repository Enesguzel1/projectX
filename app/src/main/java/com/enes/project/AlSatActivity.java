package com.enes.project;


import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.enes.project.Fragments.AlSatHomePageFragment;
import com.enes.project.Fragments.alSatMyAdvertiseFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.InputStream;


public class AlSatActivity extends AppCompatActivity {
    private ImageView imgAdvertiseImg1, imgAdvertiseImg2, imgAdvertiseImg3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_al_sat);

        BottomNavigationView alSatNavBottomMenu = findViewById(R.id.alSatNavBottomMenu);

        alSatNavBottomMenu.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.menu_al_sat_home) {
                Toast.makeText(AlSatActivity.this, "HOME", Toast.LENGTH_SHORT).show();
                setFragment(new AlSatHomePageFragment());
            } else if (itemId == R.id.menu_al_sat_advertise) {
                bottomSheetDialog();
                Toast.makeText(AlSatActivity.this, "Adversite", Toast.LENGTH_SHORT).show();
            } else if (itemId == R.id.menu_al_sat_my_advertise) {
                Toast.makeText(AlSatActivity.this, "My Adversite", Toast.LENGTH_SHORT).show();
                setFragment(new alSatMyAdvertiseFragment());
            } else if (itemId == R.id.menu_al_sat_my_profile) {
                Toast.makeText(AlSatActivity.this, "Profile", Toast.LENGTH_SHORT).show();
            }
            return true;
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
        dialog.setContentView(R.layout.al_sat_add_advertise_bottom_sheet_modal);

        EditText edtTxtAdvertiseTitle = dialog.findViewById(R.id.edtTxtAdvertiseTitle);
        EditText edtTxtAdvertiseDescription = dialog.findViewById(R.id.edtTxtAdvertiseDescription);
        EditText edtTxtAdvertiseAddress = dialog.findViewById(R.id.edtTxtAdvertiseAddress);
        CardView addAdvertiseCardView1 = dialog.findViewById(R.id.addAdvertiseCardView1);
        imgAdvertiseImg1 = dialog.findViewById(R.id.imgAdvertiseImg1);
        CardView addAdvertiseCardView2 = dialog.findViewById(R.id.addAdvertiseCardView2);
        imgAdvertiseImg2 = dialog.findViewById(R.id.imgAdvertiseImg2);
        CardView addAdvertiseCardView3 = dialog.findViewById(R.id.addAdvertiseCardView3);
        imgAdvertiseImg3 = dialog.findViewById(R.id.imgAdvertiseImg3);
        CheckBox checkboxGiveFree = dialog.findViewById(R.id.checkboxGiveFree);
        EditText advertisePrice = dialog.findViewById(R.id.advertisePrice);

        addAdvertiseCardView1.setOnClickListener(view -> setImage(imgAdvertiseImg1));
        addAdvertiseCardView2.setOnClickListener(view -> setImage(imgAdvertiseImg2));
        addAdvertiseCardView3.setOnClickListener(view -> setImage(imgAdvertiseImg3));

        checkboxGiveFree.setOnClickListener(view -> advertisePrice.setEnabled(!checkboxGiveFree.isChecked()));

        Button publishAdvertise = dialog.findViewById(R.id.publishAdvertise);
        publishAdvertise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String advertiseTitle = edtTxtAdvertiseTitle.getText().toString();
                String advertiseDescription = edtTxtAdvertiseDescription.getText().toString();
                String advertiseAddress = edtTxtAdvertiseAddress.getText().toString();
                int advertisePriceTRY = checkboxGiveFree.isChecked() ? 0 : 12;

              if (!advertiseTitle.isEmpty() && !advertiseDescription.isEmpty() && !advertiseAddress.isEmpty()){
                    System.out.println("baslik: "+advertiseTitle+" aciklama"+ advertiseDescription +" adres"+ advertiseAddress+" tutar"+ advertisePriceTRY);
                }else{
                    Toast.makeText(AlSatActivity.this, "Bütün alanları doldurun.", Toast.LENGTH_SHORT).show();
              }

            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations =R.style.DialoAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void setImage(ImageView imageView) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        mStartForResult.launch(intent);
    }

    // Image upload
    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK){
                    Intent data = result.getData();
                    if(data !=null){
                        Uri selectedImg = data.getData();
                        if(selectedImg !=null){
                            try{
                                InputStream inputStream = getContentResolver().openInputStream(selectedImg);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                imgAdvertiseImg1.setImageBitmap(bitmap);
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            });
}