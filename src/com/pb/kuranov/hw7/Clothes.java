package com.pb.kuranov.hw7;

public abstract class Clothes {

    private Size size;
    private String colour;
    private int price;

    public Clothes(Size size, String colour, int price) {
        this.size = size;
        this.colour = colour;
        this.price = price;
    }
    public Size getSize() {
        return size;
    }
    public String getColour() {
        return colour;
    }
    public int getPrice() {
        return price;
    }
}
