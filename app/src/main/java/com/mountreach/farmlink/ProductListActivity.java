package com.mountreach.farmlink;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mountreach.farmlink.Product;
import com.mountreach.farmlink.ProductAdapter;
import com.mountreach.farmlink.R;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    List<Product> productList;

    ImageView ivBack, ivFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_list);

        // Find views
        recyclerView = findViewById(R.id.recyclerView);
        ivBack = findViewById(R.id.ivBack);
        ivFilter = findViewById(R.id.ivFilter);

        // Back button
        ivBack.setOnClickListener(v -> finish());

        // RecyclerView
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        recyclerView.setHasFixedSize(true);

        // Product list
        productList = new ArrayList<>();

        productList.add(new Product(
                "Fresh Tomatoes",
                "₹30 / kg",
                "ABC Farm",
                "2.5 km away",
                R.drawable.img_3
        ));

        productList.add(new Product(
                "Potatoes",
                "₹25 / kg",
                "XYZ Farm",
                "3 km away",
                R.drawable.img_4
        ));

        productList.add(new Product(
                "Onions",
                "₹28 / kg",
                "Kisan Farm",
                "2 km away",
                R.drawable.img_5
        ));

        productList.add(new Product(
                "Fresh Spinach",
                "₹20 / bunch",
                "Green Farm",
                "1.8 km away",
                R.drawable.img_6
        ));

        productList.add(new Product(
                "Fresh Apples",
                "₹120 / kg",
                "Nature Farm",
                "4 km away",
                R.drawable.img_7
        ));

        // Adapter
        productAdapter = new ProductAdapter(productList);

        recyclerView.setAdapter(productAdapter);
    }
}