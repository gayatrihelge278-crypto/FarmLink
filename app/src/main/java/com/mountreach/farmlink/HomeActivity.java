package com.mountreach.farmlink;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    // Top
    TextView txtFarmerName;
    ImageView imgNotification;

    // Overview
    TextView txtProducts;
    TextView txtOrders;
    TextView txtEarnings;

    // Quick Actions
    LinearLayout layoutAddProduct;
    LinearLayout layoutMyProducts;
    LinearLayout layoutOrders;
    LinearLayout layoutProfile;

    // Recent Orders
    TextView txtViewAll;

    // Bottom Navigation
    LinearLayout navHome;
    LinearLayout navProducts;
    LinearLayout navOrders;
    LinearLayout navProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);


        // -----------------------------
        // FIND VIEWS
        // -----------------------------

        txtFarmerName = findViewById(R.id.txtFarmerName);
        imgNotification = findViewById(R.id.imgNotification);

        txtProducts = findViewById(R.id.txtProducts);
        txtOrders = findViewById(R.id.txtOrders);
        txtEarnings = findViewById(R.id.txtEarnings);

        layoutAddProduct = findViewById(R.id.layoutAddProduct);
        layoutMyProducts = findViewById(R.id.layoutMyProducts);
        layoutOrders = findViewById(R.id.layoutOrders);
        layoutProfile = findViewById(R.id.layoutProfile);

        txtViewAll = findViewById(R.id.txtViewAll);

        navHome = findViewById(R.id.navHome);
        navProducts = findViewById(R.id.navProducts);
        navOrders = findViewById(R.id.navOrders);
        navProfile = findViewById(R.id.navProfile);


        // -----------------------------
        // STATIC DATA
        // -----------------------------

        txtFarmerName.setText("Good Morning,\nRamesh Farmer 👋");

        txtProducts.setText("12");

        txtOrders.setText("8");

        txtEarnings.setText("₹2,450");


        // -----------------------------
        // NOTIFICATION
        // -----------------------------

        ImageView btnNotifications;

        btnNotifications = findViewById(R.id.imgNotification);

        btnNotifications.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    NotificationActivity.class
            );

            startActivity(intent);

        });

        // -----------------------------
        // ADD PRODUCT
        // -----------------------------

        layoutAddProduct.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    AddProductActivity.class
            );

            startActivity(intent);

        });


        // -----------------------------
        // MY PRODUCTS
        // -----------------------------

        layoutMyProducts.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    MyProductActivity.class
            );

            startActivity(intent);

        });


        // -----------------------------
        // ORDERS
        // -----------------------------

        layoutOrders.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    FarmerOActivity.class
            );

            startActivity(intent);

        });


        // -----------------------------
        // PROFILE
        // -----------------------------

        layoutProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    MyProductActivity.class
            );

            startActivity(intent);

        });


        // -----------------------------
        // VIEW ALL ORDERS
        // -----------------------------

        txtViewAll.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    FarmerOActivity.class
            );

            startActivity(intent);

        });


        // -----------------------------
        // BOTTOM NAVIGATION
        // -----------------------------

        navHome.setOnClickListener(v -> {

            Toast.makeText(
                    HomeActivity.this,
                    "You are already on Home",
                    Toast.LENGTH_SHORT
            ).show();

        });


        navProducts.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    MyProductActivity.class
            );

            startActivity(intent);

        });


        navOrders.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    FarmerOActivity.class
            );

            startActivity(intent);

        });


        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    HomeActivity.this,
                    ProfileActivity.class
            );

            startActivity(intent);

        });

    }
}