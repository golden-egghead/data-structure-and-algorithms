package BST;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class PhoneNode implements Comparable{
    String code;
    int price;
    PhoneNode left,right;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PhoneNode(String code, int price) {
        this.code = code;
        this.price = price;
    }
    
    @Override
    public int compareTo(Object o) {
        return this.code.compareTo(((PhoneNode)o).code);
    }
    
}
