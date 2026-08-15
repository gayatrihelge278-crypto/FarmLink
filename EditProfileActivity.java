package com.mountreach.farmlink;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    ImageView btnBack;
    ImageView imgProfile;

    TextView btnChangePhoto;
    TextView btnSaveProfile;

    EditText etName;
    EditText etMobile;
    EditText etEmail;
    EditText etFarmName;
    EditText etAddress;

    Spinner spinnerFarmingCategory;

    private static final int IMAGE_PICK_CODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_profile);


        // Find Views

        btnBack = findViewById(R.id.btnBack);

        imgProfile = findViewById(R.id.imgProfile);

        btnChangePhoto =
                findViewById(R.id.btnChangePhoto);

        btnSaveProfile =
                findViewById(R.id.btnSaveProfile);

        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);
        etFarmName = findViewById(R.id.etFarmName);
        etAddress = findViewById(R.id.etAddress);

        spinnerFarmingCategory =
                findViewById(R.id.spinnerFarmingCategory);


        // --------------------------------
        // FARMING CATEGORY
        // --------------------------------

        String[] categories = {
                "Vegetable Farming",
                "Fruit Farming",
                "Grain Farming",
                "Organic Farming",
                "Dairy Farming",
                "Mixed Farming"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categories
                );

        spinnerFarmingCategory.setAdapter(adapter);


        // --------------------------------
        // BACK
        // --------------------------------

        btnBack.setOnClickListener(v -> {

            finish();

        });


        // --------------------------------
        // CHANGE PHOTO
        // --------------------------------

        btnChangePhoto.setOnClickListener(v -> {

            selectImage();

        });


        imgProfile.setOnClickListener(v -> {

            selectImage();

        });


        // --------------------------------
        // SAVE PROFILE
        // --------------------------------

        btnSaveProfile.setOnClickListener(v -> {

            saveProfile();

        });

    }


    // =========================================
    // SELECT IMAGE
    // =========================================

    private void selectImage() {

        Intent intent = new Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        );

        startActivityForResult(
                intent,
                IMAGE_PICK_CODE
        );

    }


    // =========================================
    // IMAGE RESULT
    // =========================================

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data
        );


        if (requestCode == IMAGE_PICK_CODE &&
                resultCode == RESULT_OK &&
                data != null) {

            Uri imageUri = data.getData();

            imgProfile.setImageURI(imageUri);

            imgProfile.setScaleType(
                    ImageView.ScaleType.CENTER_CROP
            );

        }

    }


    // =========================================
    // SAVE PROFILE
    // =========================================

    private void saveProfile() {

        String name =
                etName.getText()
                        .toString()
                        .trim();

        String mobile =
                etMobile.getText()
                        .toString()
                        .trim();

        String email =
                etEmail.getText()
                        .toString()
                        .trim();

        String farmName =
                etFarmName.getText()
                        .toString()
                        .trim();

        String address =
                etAddress.getText()
                        .toString()
                        .trim();


        // Validation

        if (name.isEmpty()) {

            etName.setError(
                    "Enter your name"
            );

            etName.requestFocus();

            return;
        }


        if (mobile.isEmpty()) {

            etMobile.setError(
                    "Enter mobile number"
            );

            etMobile.requestFocus();

            return;
        }


        if (email.isEmpty()) {

            etEmail.setError(
                    "Enter email"
            );

            etEmail.requestFocus();

            return;
        }


        if (farmName.isEmpty()) {

            etFarmName.setError(
                    "Enter farm name"
            );

            etFarmName.requestFocus();

            return;
        }


        if (address.isEmpty()) {

            etAddress.setError(
                    "Enter farm address"
            );

            etAddress.requestFocus();

            return;
        }


        Toast.makeText(
                this,
                "Profile updated successfully!",
                Toast.LENGTH_LONG
        ).show();

        finish();

    }

}