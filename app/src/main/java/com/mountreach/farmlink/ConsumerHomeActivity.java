package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConsumerHomeActivity extends AppCompatActivity {

    ImageView ivProfile;

    Button btnAddTomato;
    Button btnAddPotato;

    TextView tvViewAll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_consumer_home);


        // =========================
        // INITIALIZE VIEWS
        // =========================

        ivProfile = findViewById(R.id.ivProfile);

        btnAddTomato = findViewById(R.id.btnAddTomato);

        btnAddPotato = findViewById(R.id.btnAddPotato);

        tvViewAll = findViewById(R.id.tvViewAll);


        // =========================
        // PROFILE
        // =========================

        ivProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ConsumerHomeActivity.this,
                    ProfileActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // VIEW ALL PRODUCTS
        // =========================

        tvViewAll.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ConsumerHomeActivity.this,
                    ProductListActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // TOMATO
        // =========================

        btnAddTomato.setOnClickListener(v -> {

            addProductToCart(
                    "Fresh Tomatoes",
                    "₹30 / kg"
            );
        });


        // =========================
        // POTATO
        // =========================

        btnAddPotato.setOnClickListener(v -> {

            addProductToCart(
                    "Potatoes",
                    "₹25 / kg"
            );
        });

    }


    // =====================================
    // ADD PRODUCT TO CART
    // =====================================

    private void addProductToCart(
            String productName,
            String price
    ) {

        CartItem cartItem = new CartItem(
                productName,
                price,
                android.R.drawable.ic_menu_gallery,
                1
        );

        CartManager.addToCart(cartItem);


        Toast.makeText(
                ConsumerHomeActivity.this,
                productName + " added to cart",
                Toast.LENGTH_SHORT
        ).show();
    }
}