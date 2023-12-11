package model;

import java.util.*;

public class ManagerFunction {
    public static List<Employee> employees = new ArrayList<Employee>();

    public void addFullTime(Scanner scanner) {
        System.out.println("Enter Fulltime details:");
        System.out.print("Fulltime ID: ");
        String fullTimeid = scanner.nextLine();
        System.out.print("Fulltime Name: ");
        String fullTimeName = scanner.nextLine();
        System.out.print("Birthday: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        System.out.println("WorkDay:");
        int workDay = scanner.nextInt();
        FullTime fullTime = new FullTime(fullTimeid, fullTimeName, dateOfBirth, salary, workDay);
        employees.add(fullTime);
        System.out.println("Fulltime added successfully!");

    }

    public void addPartTime(Scanner scanner) {
        System.out.println("Enter PartTime details:");
        System.out.print("PartTime ID: ");
        String partTimeid = scanner.nextLine();
        System.out.print("PartTime Name: ");
        String partTimeName = scanner.nextLine();
        System.out.print(" Birthday: ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        System.out.println("WorkDay:");
        int workDay = scanner.nextInt();
        PartTime partTime = new PartTime(partTimeid, partTimeName, dateOfBirth, salary, workDay);
        employees.add(partTime);
        System.out.println("PartTime added successfully!");
    }

    public void showAllEmployee() {
        System.out.println("----- ALL EMPLOYEE -----");
        for (int i = 0; i < employees.size(); i++) {
            Employee el = employees.get(i);
            System.out.println("ID:" + el.getId());
            System.out.println("Name: " + el.getName());
            System.out.println("DateOfBirth: " + el.getDateOfBirth());
            System.out.println("Salary: " + el.getSalary());
            if (el instanceof FullTime) {
                FullTime fullTime = (FullTime) el;
                System.out.println("Wordday FullTime: " + fullTime.getSalarynv());
            } else if (el instanceof PartTime) {
                PartTime partTime = (PartTime) el;
                System.out.println("Wordday PartTime: " + partTime.getSalarynv());
            }
        }

    }

    public void UpdateEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee code that needs to be updated");
        String ID = sc.nextLine();
        Employee found = null;
        int index = 0;
        for (Employee nv : employees) {
            if (ID.equalsIgnoreCase(nv.getId())) {
                found = nv;
                index = employees.indexOf(nv);
                break;
            }
        }
        if (found != null) {
            System.out.print("ID: ");
            String id = sc.nextLine();
            if (id.equals("") || id == null) {
                id = found.getId();
            }
            System.out.print("Name: ");
            String name = sc.nextLine();
            if (name.equals("") || name == null) {
                name = found.getName();
            }
            System.out.print("Birthday: ");
            String dateOfBirth = sc.nextLine();
            if (dateOfBirth.equals("") || dateOfBirth == null) {
                dateOfBirth = found.getId();
            }
            System.out.print("Salary: ");
            String salary = sc.nextLine();
            if (salary.equals("") || salary == null) {
                salary = String.valueOf(found.getSalary());
            }
            if (found instanceof FullTime) {
                System.out.println("WorkDay:");
                String workDay = sc.nextLine();
                if (workDay.equals("") || workDay == null) {
                    workDay = String.valueOf(((FullTime) found).getWorkDayFullTime());
                }
                Employee nv = new FullTime(id, name, dateOfBirth, Double.parseDouble(salary), Integer.parseInt(workDay));
                employees.set(index, nv);
            }
        } else {
            System.out.println("Staff does not exist !");
        }

    }

    public void removeEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee code to be deleted");
        String ID = sc.nextLine();
        Boolean check = false;
        for (Employee nv : employees) {
            if (ID.equalsIgnoreCase(nv.getId())) {
                employees.remove(nv);
                check = true;
                break;
            }
        }
        if (check == false) {
            System.out.println("staff does not exist");
        } else {
            System.out.println("employee has been removed");
        }
    }

    public void sortName() {
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee nv1, Employee nv2) {
                return nv1.getName().compareTo(nv2.getName());
            }
        };
        Collections.sort(employees, comparator);
        showAllEmployee();
    }

    public void sortSalary() {
        Comparator<Employee> comp = new Comparator<Employee>() {
            @Override
            public int compare(Employee nv1, Employee nv2) {
                if (nv1.getSalarynv() > nv2.getSalarynv()) return 1;
                else return -1;
            }
        };
        Collections.sort(employees, comp);
        showAllEmployee();
    }

    public void showTotalSalary() {
        System.out.println("-----Show Total Salary----- ");
        for (Employee pt : employees) {
            System.out.println("Name: " + pt.getName());
            if (pt instanceof FullTime) {
                FullTime fullTime = (FullTime) pt;
                System.out.println("Total salary FullTime: " + fullTime.getSalarynv());
            } else if (pt instanceof PartTime) {
                PartTime partTime = (PartTime) pt;
                System.out.println("Total salary PartTime: " + partTime.getSalarynv());
            }
        }

    }
}