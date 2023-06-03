package com;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String> {
    public Menu() {
        super();
    }

    public int getUserChoice() {
        int choice = 0;
        int i;
        System.out.println();
        for(i = 0; i < this.size(); i++) {
            System.out.println( (i + 1) + "-" + this.get(i));
        }
        System.out.print("Select an option: 1.." + i + ":");
        Scanner scan = new Scanner(System.in);
        choice = Integer.parseInt(scan.nextLine());
        return choice;
    }
}
