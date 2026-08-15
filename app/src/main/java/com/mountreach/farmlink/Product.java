package com.mountreach.farmlink;
public class Product {

    private String productName;
    private String price;
    private String farmerName;
    private String distance;
    private int image;

    public Product(String productName, String price,
                   String farmerName, String distance, int image) {

        this.productName = productName;
        this.price = price;
        this.farmerName = farmerName;
        this.distance = distance;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public String getDistance() {
        return distance;
    }

    public int getImage() {
        return image;
    }
}