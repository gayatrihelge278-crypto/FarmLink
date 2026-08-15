package com.mountreach.farmlink;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    private static final List<CartItem> cartItems = new ArrayList<>();

    // Add product to cart
    public static void addToCart(CartItem item) {

        for (CartItem cartItem : cartItems) {

            if (cartItem.getProductName().equals(item.getProductName())) {

                cartItem.setQuantity(
                        cartItem.getQuantity() + 1
                );

                return;
            }
        }

        cartItems.add(item);
    }

    // Get all cart items
    public static List<CartItem> getCartItems() {
        return cartItems;
    }

    // Remove product
    public static void removeItem(int position) {

        if (position >= 0 && position < cartItems.size()) {
            cartItems.remove(position);
        }
    }

    // Clear cart
    public static void clearCart() {
        cartItems.clear();
    }
}