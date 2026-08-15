package com.mountreach.farmlink;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity {

    ImageView btnBack;
    ImageView imgProduct;

    EditText etProductName;
    EditText etPrice;
    EditText etQuantity;
    EditText etDescription;

    Spinner spinnerCategory;
    Spinner spinnerUnit;

    TextView btnAddProduct;

    private static final int IMAGE_PICK_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_product);


        // Find Views

        btnBack = findViewById(R.id.btnBack);

        imgProduct = findViewById(R.id.imgProduct);

        etProductName = findViewById(R.id.etProductName);
        etPrice = findViewById(R.id.etPrice);
        etQuantity = findViewById(R.id.etQuantity);
        etDescription = findViewById(R.id.etDescription);

        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerUnit = findViewById(R.id.spinnerUnit);

        btnAddProduct = findViewById(R.id.btnAddProduct);


        // --------------------------------
        // CATEGORY SPINNER
        // --------------------------------

        String[] categories = {
                "Select Category",
                "Vegetables",
                "Fruits",
                "Grains",
                "Pulses",
                "Dairy",
                "Other"
        };

        ArrayAdapter<String> categoryAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        categories
                );

        spinnerCategory.setAdapter(categoryAdapter);


        // --------------------------------
        // UNIT SPINNER
        // --------------------------------

        String[] units = {
                "Select Unit",
                "Kg",
                "Gram",
                "Litre",
                "Dozen",
                "Piece"
        };

        ArrayAdapter<String> unitAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        units
                );

        spinnerUnit.setAdapter(unitAdapter);


        // --------------------------------
        // BACK BUTTON
        // --------------------------------

        btnBack.setOnClickListener(v -> {

            finish();

        });


        // --------------------------------
        // SELECT IMAGE
        // --------------------------------

        imgProduct.setOnClickListener(v -> {

            Intent intent = new Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            );

            startActivityForResult(
                    intent,
                    IMAGE_PICK_CODE
            );

        });


        // --------------------------------
        // ADD PRODUCT
        // --------------------------------

        btnAddProduct.setOnClickListener(v -> {

            addProduct();

        });

    }


    // ==============================================
    // IMAGE RESULT
    // ==============================================

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {

        super.onActivityResult(
                requestCode,
                resultCode,
                data
        );


        if (requestCode == IMAGE_PICK_CODE &&
                resultCode == RESULT_OK &&
                data != null) {

            Uri imageUri = data.getData();

            imgProduct.setImageURI(imageUri);

            imgProduct.setScaleType(
                    ImageView.ScaleType.CENTER_CROP
            );

        }

    }


    // ==============================================
    // ADD PRODUCT FUNCTION
    // ==============================================

    private void addProduct() {

        String productName =
                etProductName.getText()
                        .toString()
                        .trim();

        String price =
                etPrice.getText()
                        .toString()
                        .trim();

        String quantity =
                etQuantity.getText()
                        .toString()
                        .trim();

        String description =
                etDescription.getText()
                        .toString()
                        .trim();


        // --------------------------------
        // VALIDATION
        // --------------------------------

        if (productName.isEmpty()) {

            etProductName.setError(
                    "Enter product name"
            );

            etProductName.requestFocus();

            return;
        }


        if (spinnerCategory.getSelectedItemPosition() == 0) {

            Toast.makeText(
                    this,
                    "Please select category",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        if (price.isEmpty()) {

            etPrice.setError(
                    "Enter price"
            );

            etPrice.requestFocus();

            return;
        }


        if (quantity.isEmpty()) {

            etQuantity.setError(
                    "Enter quantity"
            );

            etQuantity.requestFocus();

            return;
        }


        if (spinnerUnit.getSelectedItemPosition() == 0) {

            Toast.makeText(
                    this,
                    "Please select unit",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }


        if (description.isEmpty()) {

            etDescription.setError(
                    "Enter description"
            );

            etDescription.requestFocus();

            return;
        }


        // --------------------------------
        // SUCCESS
        // --------------------------------

        Toast.makeText(
                this,
                "Product added successfully!",
                Toast.LENGTH_LONG
        ).show();


        // Clear fields

        etProductName.setText("");
        etPrice.setText("");
        etQuantity.setText("");
        etDescription.setText("");

        spinnerCategory.setSelection(0);
        spinnerUnit.setSelection(0);

        imgProduct.setImageResource(
                R.drawable.ic_addc
        );

        imgProduct.setScaleType(
                ImageView.ScaleType.CENTER_INSIDE
        );

    }

}