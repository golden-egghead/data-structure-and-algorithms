package linked_list;

import com.Item;
import java.util.Scanner;

public class LL_Item extends SLL {
    Scanner sc = null;

    public LL_Item() {
        super();
        sc = new Scanner(System.in);
    }

    private SLLNode<Item> find(String code) {
        SLLNode<Item> ref;
        for (ref = this.getHead(); ref != null; ref = ref.next) {
            if (ref.info.getCode().equals(code)) {
                return ref;
            }
        }

        return null;
    }

    public void add() {
        String code = "";
        String name = "";
        int price = 0;
        int guaranty = 0;
        System.out.println("Add new item");
        boolean proceed = false;
        do {
            System.out.println("Enter Item's code:");
            code = sc.nextLine().toUpperCase();
            proceed = find(code) != null;
            if (proceed == true) {
                System.out.println("This code is Duplicate!");
            }
        } while (proceed);

        do {
            System.out.println("Enter Item's name:");
            name = sc.nextLine().trim();
            proceed = (name.length() == 0);
            if (proceed == true) {
                System.out.println("Item name must be inputted");
            }
        } while (proceed);

        do {
            System.out.println("Enter item's price:");
            price = Integer.parseInt(sc.nextLine());
            if (price <= 0) {
                System.out.println("Item's price must be greater than 0");
            }
        } while (price <= 0);

        do {
            System.out.println("Enter guaranty");
            guaranty = Integer.parseInt(sc.nextLine());
            if (guaranty < 0) {
                System.out.println("Item's guaranty must be greater than 0");
            }
        } while (guaranty <= 0);

        Item emp = new Item(code, name, price, guaranty);
        this.addToTail(emp);
        System.out.println("This Item is added");
    }

    public void remove() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            String code = "";
            System.out.print("Enter the code of item who will be removed.");
            code = sc.nextLine().toUpperCase();
            SLLNode<Item> ref = find(code);
            if (ref == null) {
                System.out.println("The item does not exsit");
            } else {
                this.delete(ref.info);
                System.out.println("The item has been removed");
            }
        }
    }

    public void updatePrice() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            String code = "";
            System.out.println("Enter the code of item to update price: ");
            code = sc.nextLine().toUpperCase();
            SLLNode<Item> ref = find(code);
            if (ref == null) {
                System.out.println("The item does not exist");
            } else {
                int oldPrice = ref.info.getPrice();
                int newPrice;

                do {
                    System.out.println("Old price: " + oldPrice + ", new price:");
                    newPrice = Integer.parseInt(sc.nextLine());
                } while (newPrice <= oldPrice);

                ref.info.setPrice(newPrice);
                System.out.println("Price has been updated");
            }
        }
    }

    public void updateGuaranty() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            String code = "";
            System.out.println("Enter the code of item to update guaranty: ");
            code = sc.nextLine().toUpperCase();
            SLLNode<Item> ref = find(code);
            if (ref == null) {
                System.out.println("The item does not exist");
            } else {
                int oldGuaranty = ref.info.getGuaranty();
                int newGuaranty;

                do {
                    System.out.println("Old price: " + oldGuaranty + ", new price:");
                    newGuaranty = Integer.parseInt(sc.nextLine());
                } while (newGuaranty <= oldGuaranty);

                ref.info.setGuaranty(newGuaranty);
                System.out.println("Guaranty has been updated");
            }
        }
    }

    void print() {
        if (this.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            System.out.println("ITEM LIST");
            this.printAll();
        }
    }
}
