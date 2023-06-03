package linked_list;

import com.Menu;

public class LL_Item_Program {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Add new item");
        menu.add("Remove an item");
        menu.add("Update price of an item");
        menu.add("Update guaranty of an item");
        menu.add("Print item list");
        menu.add("Quit");
        LL_Item itemList = new LL_Item();
        int userChoice;
        
        do {
            userChoice = menu.getUserChoice();
            switch(userChoice) {
                case 1: itemList.add(); break;
                case 2: itemList.remove(); break;
                case 3: itemList.updatePrice(); break;
                case 4: itemList.updateGuaranty(); break;
                case 5: itemList.print(); break;
            }
        } while(userChoice > 0 && userChoice < 6);
    }
}
