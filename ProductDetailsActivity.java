package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ProductDetailsActivity extends AppCompatActivity {

    ImageView ivBack, ivCart, ivProduct;

    TextView tvProductName;
    TextView tvPrice;
    TextView tvFarmer;
    TextView tvDistance;

    MaterialButton btnAddToCart;

    String productName;
    String price;
    String farmerName;
    String distance;
    int image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_details);


        // =========================
        // FIND VIEWS
        // =========================

        ivBack = findViewById(R.id.ivBack);
        ivCart = findViewById(R.id.ivCart);
        ivProduct = findViewById(R.id.ivProduct);

        tvProductName = findViewById(R.id.tvProductName);
        tvPrice = findViewById(R.id.tvPrice);
        tvFarmer = findViewById(R.id.tvFarmer);
        tvDistance = findViewById(R.id.tvDistance);

        btnAddToCart = findViewById(R.id.btnAddToCart);


        // =========================
        // RECEIVE PRODUCT DATA
        // =========================

        productName = getIntent().getStringExtra("productName");
        price = getIntent().getStringExtra("price");
        farmerName = getIntent().getStringExtra("farmerName");
        distance = getIntent().getStringExtra("distance");

        image = getIntent().getIntExtra("image", 0);


        // =========================
        // DISPLAY PRODUCT DATA
        // =========================

        if (productName != null) {
            tvProductName.setText(productName);
        }

        if (price != null) {
            tvPrice.setText(price);
        }

        if (farmerName != null) {
            tvFarmer.setText(farmerName);
        }

        if (distance != null) {
            tvDistance.setText(distance);
        }

        if (image != 0) {
            ivProduct.setImageResource(image);
        }


        // =========================
        // BACK BUTTON
        // =========================

        ivBack.setOnClickListener(v -> {
            finish();
        });


        // =========================
        // ADD TO CART
        // =========================

        btnAddToCart.setOnClickListener(v -> {

            if (productName == null || price == null) {

                Toast.makeText(
                        ProductDetailsActivity.this,
                        "Product information unavailable",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }


            // Create Cart Item
            CartItem cartItem = new CartItem(
                    productName,
                    price,
                    image,
                    1
            );


            // Add product to CartManager
            CartManager.addToCart(cartItem);


            Toast.makeText(
                    ProductDetailsActivity.this,
                    productName + " added to cart",
                    Toast.LENGTH_SHORT
            ).show();


            // =========================
            // OPEN CART ACTIVITY
            // =========================

            Intent intent = new Intent(
                    ProductDetailsActivity.this,
                    CartActivity.class
            );

            startActivity(intent);

        });


        // =========================
        // CART ICON
        // =========================

        ivCart.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProductDetailsActivity.this,
                    CartActivity.class
            );

            startActivity(intent);

        });

    }
}