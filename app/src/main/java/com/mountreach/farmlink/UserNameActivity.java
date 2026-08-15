package com.mountreach.farmlink;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class UserNameActivity extends AppCompatActivity {

    TextInputEditText etName, etMobile, etEmail;
    TextInputEditText etPassword, etConfirmPassword;

    RadioButton rbFarmer, rbConsumer, rbBusiness;

    CheckBox cbTerms;

    MaterialButton btnRegister;

    TextView tvLogin;

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_name);

        initializeViews();

        btnBack.setOnClickListener(v -> finish());

        tvLogin.setOnClickListener(v -> {

            Intent intent = new Intent(
                    UserNameActivity.this,
                    LoginActivity.class
            );

            startActivity(intent);

            finish();
        });

        btnRegister.setOnClickListener(v -> validateRegistration());
    }

    private void initializeViews() {

        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        etEmail = findViewById(R.id.etEmail);

        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword =
                findViewById(R.id.etConfirmPassword);

        rbFarmer = findViewById(R.id.rbFarmer);
        rbConsumer = findViewById(R.id.rbConsumer);
        rbBusiness = findViewById(R.id.rbBusiness);

        cbTerms = findViewById(R.id.cbTerms);

        btnRegister = findViewById(R.id.btnRegister);

        tvLogin = findViewById(R.id.tvLogin);

        btnBack = findViewById(R.id.btnBack);
    }

    private void validateRegistration() {

        String name =
                etName.getText().toString().trim();

        String mobile =
                etMobile.getText().toString().trim();

        String email =
                etEmail.getText().toString().trim();

        String password =
                etPassword.getText().toString().trim();

        String confirmPassword =
                etConfirmPassword.getText()
                        .toString()
                        .trim();

        // Name

        if (name.isEmpty()) {

            etName.setError("Enter your full name");
            etName.requestFocus();
            return;
        }

        if (name.length() < 3) {

            etName.setError("Enter a valid name");
            etName.requestFocus();
            return;
        }

        // Mobile

        if (mobile.isEmpty()) {

            etMobile.setError("Enter mobile number");
            etMobile.requestFocus();
            return;
        }

        if (mobile.length() != 10) {

            etMobile.setError(
                    "Enter a valid 10-digit number"
            );

            etMobile.requestFocus();
            return;
        }

        // Email

        if (email.isEmpty()) {

            etEmail.setError("Enter email address");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS
                .matcher(email)
                .matches()) {

            etEmail.setError(
                    "Enter a valid email address"
            );

            etEmail.requestFocus();
            return;
        }

        // Role

        if (!rbFarmer.isChecked()
                && !rbConsumer.isChecked()
                && !rbBusiness.isChecked()) {

            Toast.makeText(
                    this,
                    "Please select your role",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // Password

        if (password.isEmpty()) {

            etPassword.setError(
                    "Create a password"
            );

            etPassword.requestFocus();
            return;
        }

        if (password.length() < 8) {

            etPassword.setError(
                    "Password must contain at least 8 characters"
            );

            etPassword.requestFocus();
            return;
        }

        // Confirm password

        if (!password.equals(confirmPassword)) {

            etConfirmPassword.setError(
                    "Passwords do not match"
            );

            etConfirmPassword.requestFocus();
            return;
        }

        // Terms

        if (!cbTerms.isChecked()) {

            Toast.makeText(
                    this,
                    "Please accept Terms & Privacy Policy",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        String role;

        if (rbFarmer.isChecked()) {

            role = "farmer";

        } else if (rbConsumer.isChecked()) {

            role = "consumer";

        } else {

            role = "business";
        }

        registerUser(
                name,
                mobile,
                email,
                password,
                role
        );
    }

    private void registerUser(
            String name,
            String mobile,
            String email,
            String password,
            String role) {

        /*
         * Backend API will be connected here.
         */

        Toast.makeText(
                this,
                "Registration data validated!",
                Toast.LENGTH_SHORT
        ).show();
    }
}