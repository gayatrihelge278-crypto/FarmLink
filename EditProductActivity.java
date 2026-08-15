package com.mountreach.farmlink;

import android.app.AlertDialog;
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

public class EditProductActivity extends AppCompatActivity {

    ImageView btnBack;
    ImageView imgProduct;

    EditText etProductName;
    EditText etPrice;
    EditText etQuantity;
    EditText etDescription;

    Spinner spinnerCategory;
    Spinner spinnerUnit;

    TextView btnUpdateProduct;
    TextView btnDeleteProduct;

    private static final int IMAGE_PICK_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_product);


        // Find Views

        btnBack = findViewById(R.id.btnBack);
        imgProduct = findViewById(R.id.imgProduct);

        etProductName = findViewById(R.id.etProductName);
        etPrice = findViewById(R.id.etPrice);
        etQuantity = findViewById(R.id.etQuantity);
        etDescription = findViewById(R.id.etDescription);

        spinnerCategory = findViewById(R.id.spinnerCategory);
        spinnerUnit = findViewById(R.id.spinnerUnit);

        btnUpdateProduct = findViewById(R.id.btnUpdateProduct);
        btnDeleteProduct = findViewById(R.id.btnDeleteProduct);


        // --------------------------------
        // GET PRODUCT NAME
        // --------------------------------

        String productName = getIntent()
                .getStringExtra("product_name");

        if (productName != null) {

            etProductName.setText(productName);

        }


        // --------------------------------
        // CATEGORY
        // --------------------------------

        String[] categories = {
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
        // UNIT
        // --------------------------------

        String[] units = {
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
        // BACK
        // --------------------------------

        btnBack.setOnClickListener(v -> {

            finish();

        });


        // --------------------------------
        // CHANGE IMAGE
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
        // UPDATE
        // --------------------------------

        btnUpdateProduct.setOnClickListener(v -> {

            updateProduct();

        });


        // --------------------------------
        // DELETE
        // --------------------------------

        btnDeleteProduct.setOnClickListener(v -> {

            showDeleteDialog();

        });

    }


    // =====================================
    // IMAGE RESULT
    // =====================================

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


    // =====================================
    // UPDATE PRODUCT
    // =====================================

    private void updateProduct() {

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


        if (productName.isEmpty()) {

            etProductName.setError(
                    "Enter product name"
            );

            etProductName.requestFocus();

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


        if (description.isEmpty()) {

            etDescription.setError(
                    "Enter description"
            );

            etDescription.requestFocus();

            return;
        }


        Toast.makeText(
                this,
                "Product updated successfully!",
                Toast.LENGTH_LONG
        ).show();

        finish();

    }


    // =====================================
    // DELETE CONFIRMATION
    // =====================================

    private void showDeleteDialog() {

        new AlertDialog.Builder(this)

                .setTitle("Delete Product")

                .setMessage(
                        "Are you sure you want to delete this product?"
                )

                .setNegativeButton(
                        "Cancel",
                        null
                )

                .setPositiveButton(
                        "Delete",
                        (dialog, which) -> {

                            Toast.makeText(
                                    EditProductActivity.this,
                                    "Product deleted successfully!",
                                    Toast.LENGTH_LONG
                            ).show();

                            finish();

                        }
                )

                .show();

    }

}