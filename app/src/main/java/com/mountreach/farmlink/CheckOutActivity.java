package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class CheckOutActivity extends AppCompatActivity {

    ImageView ivBack;

    TextView tvCustomerName;
    TextView tvMobile;
    TextView tvAddress;

    TextView tvItems;
    TextView tvSubtotal;
    TextView tvDelivery;
    TextView tvTotal;

    MaterialButton btnPlaceOrder;

    List<CartItem> cartItemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_check_out);


        // Find Views

        ivBack = findViewById(R.id.ivBack);

        tvCustomerName = findViewById(R.id.tvCustomerName);
        tvMobile = findViewById(R.id.tvMobile);
        tvAddress = findViewById(R.id.tvAddress);

        tvItems = findViewById(R.id.tvItems);
        tvSubtotal = findViewById(R.id.tvSubtotal);
        tvDelivery = findViewById(R.id.tvDelivery);
        tvTotal = findViewById(R.id.tvTotal);

        btnPlaceOrder = findViewById(R.id.btnCheckout);


        // Get Cart Items

        cartItemList = CartManager.getCartItems();


        // Back Button

        ivBack.setOnClickListener(v -> finish());


        // Customer Details
        // Temporary details for testing

        tvCustomerName.setText("Krishna Chaudhari");

        tvMobile.setText("+91 98765 43210");

        tvAddress.setText(
                "At. Khasala, Amravati,\nMaharashtra - 444607"
        );


        // Calculate Checkout Amount

        calculateCheckoutTotal();


        // Place Order Button

        btnPlaceOrder.setOnClickListener(v -> {



            if (cartItemList.isEmpty()) {

                Toast.makeText(
                        CheckOutActivity.this,
                        "Your cart is empty",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            Intent intent = new Intent(
                    CheckOutActivity.this,
                    PaymentActivity.class
            );

            startActivity(intent);
        });

        Toast.makeText(this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();

    }


    private void calculateCheckoutTotal() {

        double subtotal = 0;

        int totalItems = 0;


        for (CartItem item : cartItemList) {

            String priceText = item.getPrice();

            String numericPrice =
                    priceText
                            .replace("₹", "")
                            .split("/")[0]
                            .trim();


            try {

                double price =
                        Double.parseDouble(numericPrice);

                subtotal +=
                        price * item.getQuantity();

                totalItems += item.getQuantity();

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


        // Final amount

        double total = subtotal + delivery;


        // Display values

        tvItems.setText(
                totalItems + " items"
        );

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