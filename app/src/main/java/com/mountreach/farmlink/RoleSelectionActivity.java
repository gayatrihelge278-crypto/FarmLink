package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class RoleSelectionActivity extends AppCompatActivity {

    MaterialCardView cardFarmer, cardConsumer;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_role_selection);

        // Find Views
        cardFarmer = findViewById(R.id.cardFarmer);
        cardConsumer = findViewById(R.id.cardConsumer);
        ivBack = findViewById(R.id.ivBack);


        // =========================
        // BACK BUTTON
        // =========================

        ivBack.setOnClickListener(v -> {
            finish();
        });


        // =========================
        // FARMER SELECTION
        // =========================

        cardFarmer.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RoleSelectionActivity.this,
                    HomeActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // CONSUMER SELECTION
        // =========================

        cardConsumer.setOnClickListener(v -> {

            Intent intent = new Intent(
                    RoleSelectionActivity.this,
                    ConsumerHomeActivity.class
            );

            startActivity(intent);
        });
    }
}