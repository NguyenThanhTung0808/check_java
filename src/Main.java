import model.ManagerFunction;

import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerFunction managerFunction = new ManagerFunction();

        int choice;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Add FullTime");
            System.out.println("2. Add Parttime");
            System.out.println("3. Show payroll list.");
            System.out.println("4. Update or edit of an employee by Id");
            System.out.println("5. Delete of an employee by Id");
            System.out.println("6. displaying an alphabetical list.");
            System.out.println("7. Show employee has highest salary");
            System.out.println("8. Show total salary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    managerFunction.addFullTime(scanner);
                    break;

                case 2:
                    managerFunction.addPartTime(scanner);
                    break;
                case 3:
                    managerFunction.showAllEmployee();
                    break;
                case 4:
                    managerFunction.UpdateEmployee();
                    break;
                case 5:
                    managerFunction.removeEmployee();
                    break;
                case 6:
                    managerFunction.sortName();
                    break;
                case 7:
                    managerFunction.sortSalary();

                    break;
                case 8:
                    managerFunction.showTotalSalary();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }
}


