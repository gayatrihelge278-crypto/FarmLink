package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    List<CartItem> cartItemList;

    ImageView ivBack;

    TextView tvSubtotal;
    TextView tvDelivery;
    TextView tvTotal;
    MaterialButton btnCheckout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cart);


        // Find Views

        recyclerView = findViewById(R.id.recyclerView);

        ivBack = findViewById(R.id.ivBack);

        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvDelivery = findViewById(R.id.tvDelivery);
        tvTotal = findViewById(R.id.tvTotal);
        btnCheckout = findViewById(R.id.btnCheckout);

        btnCheckout.setOnClickListener(v -> {

            Intent intent = new Intent(
                    CartActivity.this,
                    CheckOutActivity.class
            );

            startActivity(intent);
        });


        // Back Button

        ivBack.setOnClickListener(v -> finish());


        // RecyclerView Setup

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerView.setHasFixedSize(true);


        // Get Actual Cart Items

        cartItemList = CartManager.getCartItems();


        // Create Adapter

        cartAdapter = new CartAdapter(
                cartItemList,
                this::updateTotal
        );


        // Set Adapter

        recyclerView.setAdapter(cartAdapter);


        // Calculate Initial Total

        updateTotal();
    }


    // Update Cart Total

    private void updateTotal() {

        double subtotal = 0;


        for (CartItem item : cartItemList) {

            String priceText = item.getPrice();


            // Example:
            // ₹30 / kg
            // ₹25 / kg

            String numericPrice =
                    priceText
                            .replace("₹", "")
                            .split("/")[0]
                            .trim();


            try {

                double price =
                        Double.parseDouble(numericPrice);

                subtotal =
                        subtotal +
                                (price * item.getQuantity());

            } catch (NumberFormatException e) {

                e.printStackTrace();
            }
        }


        // Delivery charge

        double delivery;

        if (cartItemList.isEmpty()) {
            delivery = 0;
        } else {
            delivery = 20;
        }


        // Final total

        double total =
                subtotal + delivery;


        // Display values

        tvSubtotal.setText(
                "₹" + (int) subtotal
        );

        tvDelivery.setText(
                "₹" + (int) delivery
        );

        tvTotal.setText(
                "₹" + (int) total
        );
    }
}