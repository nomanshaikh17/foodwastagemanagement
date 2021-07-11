package com.finalproject.foodwastemanagementsystem.model;

public class GuestCard {
    private String line1;
    private String line2;

    public GuestCard(String line1,String line2) {
        this.line1 = line1;
        this.line2=line2;
    }

    public String getLine2() {
        return line2;
    }

    public String getLine1() {
        return line1;
    }
}
