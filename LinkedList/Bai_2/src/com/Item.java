package com;

import java.lang.Comparable;

public class Item {
    String code = "";
    String name = "";
    int price = 0;
    int guaranty = 0;
    public Item() {
    }
    public Item(String c, String n, int s, int g) {
        this.code = c;
        this.name = n;
        this.price = s;
        this.guaranty = g;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuaranty() {
        return guaranty;
    }
    public void setGuaranty(int guaranty) {
        this.guaranty = guaranty;
    }

    @Override
    public String toString() {
        return this.code + "\t" + this.name + "\t" + this.price + "\t" + this.guaranty;
    }
    
    public boolean equals(Item item) {
        return item.getCode().equals(this.getCode()) &&
                item.getName().equals(this.getName()) &&
                item.getPrice() == this.getPrice() &&
                item.getGuaranty() ==  this.getGuaranty();
    }
}
