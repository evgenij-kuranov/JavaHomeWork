package com.pb.kuranov.hw7;

public class Skirt extends Clothes implements WoomanClothes {

    private String name;

    public Skirt(Size size, String colour, int price, String name) {
        super(size, colour, price);
        this.name = name;
    }
    @Override
    public void dressWooMan() {
        System.out.println("название: " + name +
                " размер: " + this.getSize() +
                " цена: " + this.getPrice() +
                " цвет: " + this.getColour());
    }
}
