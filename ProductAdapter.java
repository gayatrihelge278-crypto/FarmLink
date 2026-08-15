package com.mountreach.farmlink;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ProductViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.tvProductName.setText(product.getProductName());
        holder.tvPrice.setText(product.getPrice());
        holder.tvFarmer.setText(product.getFarmerName());
        holder.tvDistance.setText(product.getDistance());

        holder.ivProduct.setImageResource(product.getImage());

        // Add button
        holder.btnAdd.setOnClickListener(v -> {

            // We will implement Cart functionality later
        });

        // Product card click
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(
                    v.getContext(),
                    ProductDetailsActivity.class
            );

            intent.putExtra("productName", product.getProductName());
            intent.putExtra("price", product.getPrice());
            intent.putExtra("farmerName", product.getFarmerName());
            intent.putExtra("distance", product.getDistance());
            intent.putExtra("image", product.getImage());

            v.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class ProductViewHolder
            extends RecyclerView.ViewHolder {

        ImageView ivProduct;
        TextView tvProductName;
        TextView tvPrice;
        TextView tvFarmer;
        TextView tvDistance;
        ImageButton btnAdd;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProduct = itemView.findViewById(R.id.ivProduct);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvFarmer = itemView.findViewById(R.id.tvFarmer);
            tvDistance = itemView.findViewById(R.id.tvDistance);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}