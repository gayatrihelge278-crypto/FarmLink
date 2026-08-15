package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    ImageView btnBack;

    TextView txtName;
    TextView txtFarmerId;
    TextView txtMobile;
    TextView txtEmail;
    TextView txtAddress;

    TextView btnEditProfile;
    TextView btnMyProducts;
    TextView btnOrderHistory;
    TextView btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);


        // Find Views

        btnBack = findViewById(R.id.btnBack);

        txtName = findViewById(R.id.txtName);
        txtFarmerId = findViewById(R.id.txtFarmerId);
        txtMobile = findViewById(R.id.txtMobile);
        txtEmail = findViewById(R.id.txtEmail);
        txtAddress = findViewById(R.id.txtAddress);

        btnEditProfile = findViewById(R.id.btnEditProfile);
        btnMyProducts = findViewById(R.id.btnMyProducts);
        btnOrderHistory = findViewById(R.id.btnOrderHistory);
        btnLogout = findViewById(R.id.btnLogout);


        // Static Profile Data

        txtName.setText("Ramesh Farmer");

        txtFarmerId.setText("Farmer ID: FL1001");

        txtMobile.setText("+91 9876543210");

        txtEmail.setText("ramesh@gmail.com");

        txtAddress.setText(
                "Village Road, Amravati, Maharashtra"
        );


        // Back Button

        btnBack.setOnClickListener(v -> {

            finish();

        });


        // Edit Profile

        btnEditProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    EditProfileActivity.class
            );

            startActivity(intent);

        });


        // My Products

        btnMyProducts.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    MyProductActivity.class
            );

            startActivity(intent);

        });


        // Order History


        btnOrderHistory.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    FarmerOActivity.class
            );

            startActivity(intent);

        });


        // Logout

        btnLogout.setOnClickListener(v -> {

            Toast.makeText(
                    ProfileActivity.this,
                    "Logged out successfully",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(
                    ProfileActivity.this,
                    LoginActivity.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);

            finish();

        });

    }
}