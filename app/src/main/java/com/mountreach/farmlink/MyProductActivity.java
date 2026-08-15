package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MyProductActivity extends AppCompatActivity {

    ImageView btnBack;

    ImageView btnEditProduct1;
    ImageView btnEditProduct2;
    ImageView btnEditProduct3;

    TextView btnAddProduct;

    EditText etSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_product);


        // Find Views

        btnBack = findViewById(R.id.btnBack);

        btnEditProduct1 =
                findViewById(R.id.btnEditProduct1);

        btnEditProduct2 =
                findViewById(R.id.btnEditProduct2);

        btnEditProduct3 =
                findViewById(R.id.btnEditProduct3);

        btnAddProduct =
                findViewById(R.id.btnAddProduct);

        etSearch =
                findViewById(R.id.etSearch);


        // Back

        btnBack.setOnClickListener(v -> {

            finish();

        });


        // Edit Product 1

        btnEditProduct1.setOnClickListener(v -> {

            openEditProduct("Fresh Tomatoes");

        });


        // Edit Product 2

        btnEditProduct2.setOnClickListener(v -> {

            openEditProduct("Fresh Potatoes");

        });


        // Edit Product 3

        btnEditProduct3.setOnClickListener(v -> {

            openEditProduct("Fresh Onions");

        });


        // Add New Product

        btnAddProduct.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MyProductActivity.this,
                    AddProductActivity.class
            );

            startActivity(intent);

        });

    }


    private void openEditProduct(String productName) {

        Intent intent = new Intent(
                MyProductActivity.this,
                EditProductActivity.class
        );

        intent.putExtra(
                "product_name",
                productName
        );

        startActivity(intent);

    }

}