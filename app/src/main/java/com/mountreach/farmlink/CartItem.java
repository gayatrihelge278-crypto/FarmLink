package com.mountreach.farmlink;

public class CartItem {

    private String productName;
    private String price;
    private int image;
    private int quantity;

    public CartItem(String productName, String price, int image, int quantity) {
        this.productName = productName;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public int getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}