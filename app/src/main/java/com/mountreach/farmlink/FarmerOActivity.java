package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FarmerOActivity extends AppCompatActivity {

    ImageView btnBack;

    TextView filterAll;
    TextView filterNew;
    TextView filterAccepted;
    TextView filterPreparing;
    TextView filterDelivered;

    TextView btnViewOrder1;
    TextView btnViewOrder2;
    TextView btnViewOrder3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_farmer_oactivity);


        // Find Views

        btnBack = findViewById(R.id.btnBack);

        filterAll = findViewById(R.id.filterAll);
        filterNew = findViewById(R.id.filterNew);
        filterAccepted = findViewById(R.id.filterAccepted);
        filterPreparing = findViewById(R.id.filterPreparing);
        filterDelivered = findViewById(R.id.filterDelivered);

        btnViewOrder1 = findViewById(R.id.btnViewOrder1);
        btnViewOrder2 = findViewById(R.id.btnViewOrder2);
        btnViewOrder3 = findViewById(R.id.btnViewOrder3);


        // Back

        btnBack.setOnClickListener(v -> finish());


        // Filters

        filterAll.setOnClickListener(v ->
                showFilterMessage("All Orders")
        );

        filterNew.setOnClickListener(v ->
                showFilterMessage("New Orders")
        );

        filterAccepted.setOnClickListener(v ->
                showFilterMessage("Accepted Orders")
        );

        filterPreparing.setOnClickListener(v ->
                showFilterMessage("Preparing Orders")
        );

        filterDelivered.setOnClickListener(v ->
                showFilterMessage("Delivered Orders")
        );


        // View Orders

        btnViewOrder1.setOnClickListener(v -> {

            openOrderDetails("FL1024");

        });


        btnViewOrder2.setOnClickListener(v -> {

            openOrderDetails("FL1023");

        });


        btnViewOrder3.setOnClickListener(v -> {

            openOrderDetails("FL1022");

        });

    }


    private void showFilterMessage(String message) {

        Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
        ).show();

    }


    private void openOrderDetails(String orderId) {

        Intent intent = new Intent(
                FarmerOActivity.this,
                OrderDetailsActivity.class
        );

        intent.putExtra(
                "order_id",
                orderId
        );

        startActivity(intent);

    }

}