package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText etEmail, etPassword;
    MaterialButton btnLogin;

    TextView tvRegister, tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        // Initialize views
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);

        tvRegister = findViewById(R.id.tvRegister);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);


        // =========================
        // LOGIN BUTTON
        // =========================

        btnLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    RoleSelectionActivity.class
            );

            startActivity(intent);

        });


        // =========================
        // REGISTER
        // =========================

        tvRegister.setOnClickListener(v -> {

            Intent intent = new Intent(
                    LoginActivity.this,
                    UserNameActivity.class
            );

            startActivity(intent);
        });


        // =========================
        // FORGOT PASSWORD
        // =========================

        tvForgotPassword.setOnClickListener(v -> {

            // Keep your existing forgot password action here
        });
    }
}