package linked_list;

import com.Menu;

public class LL_Employee_Program {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Add new employee");
        menu.add("Remove an employee");
        menu.add("Increase salary of an employee");
        menu.add("Print employee list");
        menu.add("Quit");
        LL_EmpList empList = new LL_EmpList();
        int userChoice;
        
        do {
            userChoice = menu.getUserChoice();
            switch(userChoice) {
                case 1: empList.add(); break;
                case 2: empList.remove(); break;
                case 3: empList.increaseSalary(); break;
                case 4: empList.print(); break;
            }
        } while(userChoice > 0 && userChoice < 5);
    }
}
