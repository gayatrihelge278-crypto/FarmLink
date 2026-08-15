package com.mountreach.farmlink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<CartItem> cartItemList;
    private final OnCartChangedListener listener;

    public interface OnCartChangedListener {
        void onCartChanged();
    }

    public CartAdapter(
            List<CartItem> cartItemList,
            OnCartChangedListener listener) {

        this.cartItemList = cartItemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);

        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull CartViewHolder holder,
            int position) {

        CartItem item = cartItemList.get(position);

        holder.ivProduct.setImageResource(item.getImage());
        holder.tvProductName.setText(item.getProductName());
        holder.tvPrice.setText(item.getPrice());
        holder.tvQuantity.setText(
                String.valueOf(item.getQuantity())
        );

        // Plus button
        holder.btnPlus.setOnClickListener(v -> {

            item.setQuantity(item.getQuantity() + 1);

            holder.tvQuantity.setText(
                    String.valueOf(item.getQuantity())
            );

            listener.onCartChanged();
        });


        // Minus button
        holder.btnMinus.setOnClickListener(v -> {

            if (item.getQuantity() > 1) {

                item.setQuantity(item.getQuantity() - 1);

                holder.tvQuantity.setText(
                        String.valueOf(item.getQuantity())
                );

                listener.onCartChanged();
            }
        });


        // Remove button
        holder.btnRemove.setOnClickListener(v -> {

            int currentPosition =
                    holder.getAdapterPosition();

            if (currentPosition != RecyclerView.NO_POSITION) {

                cartItemList.remove(currentPosition);

                notifyItemRemoved(currentPosition);

                listener.onCartChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return cartItemList.size();
    }


    public static class CartViewHolder
            extends RecyclerView.ViewHolder {

        ImageView ivProduct;

        TextView tvProductName;
        TextView tvPrice;
        TextView tvQuantity;

        ImageButton btnPlus;
        ImageButton btnMinus;
        ImageButton btnRemove;


        public CartViewHolder(@NonNull View itemView) {

            super(itemView);

            ivProduct =
                    itemView.findViewById(R.id.ivProduct);

            tvProductName =
                    itemView.findViewById(R.id.tvProductName);

            tvPrice =
                    itemView.findViewById(R.id.tvPrice);

            tvQuantity =
                    itemView.findViewById(R.id.tvQuantity);

            btnPlus =
                    itemView.findViewById(R.id.btnPlus);

            btnMinus =
                    itemView.findViewById(R.id.btnMinus);

            btnRemove =
                    itemView.findViewById(R.id.btnRemove);
        }
    }
}