/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BST;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Phones {

    PhoneNode root;
    Scanner sc = new Scanner(System.in);

    public Phones() {
        root = null;
    }

    PhoneNode search(String code) {
        if (root == null) {
            return null;
        }
        PhoneNode p = this.root;
        int d = code.compareTo(p.code);
        while (p != null && d != 0) {
            d = code.compareTo(p.code);
            if (d < 0) {
                p = p.left;
            } else if (d > 0) {
                p = p.right;
            }
        }
        return p;
    }

    public void insert(String code, int price) {
        if (root == null) {
            root = new PhoneNode(code, price);
            return;
        }
        PhoneNode p = root, prev = null;
        while (p != null) {
            prev = p;
            if (code.compareTo(p.code) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (prev.code.compareTo(code) < 0) {
            prev.right = new PhoneNode(code, price);
        } else {
            prev.left = new PhoneNode(code, price);
        }
    }

    public void insert() {
        String code;
        int price;
        PhoneNode p = null;
        do {
            System.out.println("Enter the code of new phone");
            code = sc.nextLine().trim().toUpperCase();
            p = this.search(code);
            if (p != null) {
                System.out.println("This code is duplicated");
            }
        } while (p != null);
        do {
            System.out.println("Enter the price of new phone");
            price = Integer.parseInt(sc.nextLine());
            if (price < 0) {
                System.out.println("A positivie integer is required");
            }
        } while (price < 0);
        insert(code, price);
        System.out.println("The new phone was added");
    }

    public void printCode(PhoneNode p) {
        if (p != null) {
            if (p.left != null) {
                printCode(p.left);
            }
            System.out.println(p.code + "," + p.price);
            if (p.right != null) {
                printCode(p.right);
            }

        }
    }

    public void printPrice(PhoneNode p, int low, int high) {
        if (low > high) {
            int t = low;
            low = high;
            high = t;
        }
        if (p != null) {
            if (p.left != null) 
                printPrice(p.left, low, high);
            
            if (p.price >= low && p.price <= high) {
                System.out.println(p.code + "," + p.price);
                
            if (p.right != null) printPrice(p.right, low, high);
            }
        }
    }
    
    public void printPrice(){
        int low,high;
        System.out.println("Enter the low price");
        low = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the high price");
        high = Integer.parseInt(sc.nextLine());
        printPrice(root, low, high);
    }
}
