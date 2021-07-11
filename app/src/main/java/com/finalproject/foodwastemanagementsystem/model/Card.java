package com.finalproject.foodwastemanagementsystem.model;

public class Card {
    private String line1;
    private String line3;

    public Card(String line1,String line3) {
        this.line1 = line1;
        this.line3=line3;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine3(){
        return line3;
    }

}
