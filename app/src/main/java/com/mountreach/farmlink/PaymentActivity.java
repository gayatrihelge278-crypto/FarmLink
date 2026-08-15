package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class PaymentActivity extends AppCompatActivity {

    ImageView ivBack;

    RadioButton rbUPI;
    RadioButton rbCard;
    RadioButton rbCOD;

    MaterialButton btnPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_payment);


        // Find Views

        ivBack = findViewById(R.id.ivBack);

        rbUPI = findViewById(R.id.rbUPI);
        rbCard = findViewById(R.id.rbCard);
        rbCOD = findViewById(R.id.rbCOD);

        btnPay = findViewById(R.id.btnPay);


        // Back Button

        ivBack.setOnClickListener(v -> finish());


        // Payment Method Selection

        rbUPI.setOnClickListener(v -> {

            rbUPI.setChecked(true);
            rbCard.setChecked(false);
            rbCOD.setChecked(false);

        });


        rbCard.setOnClickListener(v -> {

            rbUPI.setChecked(false);
            rbCard.setChecked(true);
            rbCOD.setChecked(false);

        });


        rbCOD.setOnClickListener(v -> {

            rbUPI.setChecked(false);
            rbCard.setChecked(false);
            rbCOD.setChecked(true);

        });


        // Confirm & Place Order

        btnPay.setOnClickListener(v -> {

            String paymentMethod;

            if (rbUPI.isChecked()) {

                paymentMethod = "UPI";

            } else if (rbCard.isChecked()) {

                paymentMethod = "Debit / Credit Card";

            } else {

                paymentMethod = "Cash on Delivery";
            }


            Toast.makeText(
                    PaymentActivity.this,
                    "Order placed successfully!\nPayment: "
                            + paymentMethod,
                    Toast.LENGTH_LONG
            ).show();


            // Clear Cart

            CartManager.clearCart();


            // Go back to Product List/Home

            Intent intent = new Intent(
                    PaymentActivity.this,
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