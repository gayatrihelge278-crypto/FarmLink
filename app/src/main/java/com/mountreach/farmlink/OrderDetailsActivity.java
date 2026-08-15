package com.mountreach.farmlink;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderDetailsActivity extends AppCompatActivity {

    ImageView btnBack;

    TextView txtOrderId;
    TextView txtStatus;

    TextView txtCustomerName;
    TextView txtCustomerMobile;
    TextView txtCustomerAddress;

    TextView txtProductName;
    TextView txtProductQuantity;
    TextView txtProductTotal;

    TextView txtAmount;
    TextView txtTotalAmount;

    TextView btnAccept;
    TextView btnReject;
    TextView btnPreparing;
    TextView btnDelivered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_details);


        // Find Views

        btnBack = findViewById(R.id.btnBack);

        txtOrderId = findViewById(R.id.txtOrderId);
        txtStatus = findViewById(R.id.txtStatus);

        txtCustomerName = findViewById(R.id.txtCustomerName);
        txtCustomerMobile = findViewById(R.id.txtCustomerMobile);
        txtCustomerAddress = findViewById(R.id.txtCustomerAddress);

        txtProductName = findViewById(R.id.txtProductName);
        txtProductQuantity = findViewById(R.id.txtProductQuantity);
        txtProductTotal = findViewById(R.id.txtProductTotal);

        txtAmount = findViewById(R.id.txtAmount);
        txtTotalAmount = findViewById(R.id.txtTotalAmount);

        btnAccept = findViewById(R.id.btnAccept);
        btnReject = findViewById(R.id.btnReject);
        btnPreparing = findViewById(R.id.btnPreparing);
        btnDelivered = findViewById(R.id.btnDelivered);


        // --------------------------------
        // ORDER ID
        // --------------------------------

        String orderId = getIntent()
                .getStringExtra("order_id");

        if (orderId != null) {

            txtOrderId.setText(orderId);

        }


        // --------------------------------
        // BACK
        // --------------------------------

        btnBack.setOnClickListener(v -> finish());


        // --------------------------------
        // ACCEPT
        // --------------------------------

        btnAccept.setOnClickListener(v -> {

            txtStatus.setText("Accepted");

            btnAccept.setVisibility(
                    TextView.GONE
            );

            btnReject.setVisibility(
                    TextView.GONE
            );

            btnPreparing.setVisibility(
                    TextView.VISIBLE
            );

            Toast.makeText(
                    this,
                    "Order accepted",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // --------------------------------
        // REJECT
        // --------------------------------

        btnReject.setOnClickListener(v -> {

            showRejectDialog();

        });


        // --------------------------------
        // PREPARING
        // --------------------------------

        btnPreparing.setOnClickListener(v -> {

            txtStatus.setText("Preparing");

            btnPreparing.setVisibility(
                    TextView.GONE
            );

            btnDelivered.setVisibility(
                    TextView.VISIBLE
            );

            Toast.makeText(
                    this,
                    "Order is now preparing",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // --------------------------------
        // DELIVERED
        // --------------------------------

        btnDelivered.setOnClickListener(v -> {

            txtStatus.setText("Delivered");

            btnDelivered.setVisibility(
                    TextView.GONE
            );

            Toast.makeText(
                    this,
                    "Order marked as delivered",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }


    // ==========================================
    // REJECT DIALOG
    // ==========================================

    private void showRejectDialog() {

        new AlertDialog.Builder(this)

                .setTitle("Reject Order")

                .setMessage(
                        "Are you sure you want to reject this order?"
                )

                .setNegativeButton(
                        "Cancel",
                        null
                )

                .setPositiveButton(
                        "Reject",
                        (dialog, which) -> {

                            txtStatus.setText("Rejected");

                            btnAccept.setVisibility(
                                    TextView.GONE
                            );

                            btnReject.setVisibility(
                                    TextView.GONE
                            );

                            Toast.makeText(
                                    OrderDetailsActivity.this,
                                    "Order rejected",
                                    Toast.LENGTH_SHORT
                            ).show();

                        }
                )

                .show();

    }

}