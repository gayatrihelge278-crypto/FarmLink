package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class OrderSuccessActivity extends AppCompatActivity {

    MaterialButton btnViewOrders;
    MaterialButton btnContinueShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_success);

        btnViewOrders = findViewById(R.id.btnViewOrders);
        btnContinueShopping =
                findViewById(R.id.btnContinueShopping);


        // View My Orders

        btnViewOrders.setOnClickListener(v -> {

            Toast.makeText(
                    OrderSuccessActivity.this,
                    "My Orders will open here",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Continue Shopping

        btnContinueShopping.setOnClickListener(v -> {

            Intent intent = new Intent(
                    OrderSuccessActivity.this,
                    ProductListActivity.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);

            finish();
        });
    }
}