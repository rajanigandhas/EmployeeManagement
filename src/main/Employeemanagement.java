package main;

import java.util.List;
import java.util.Scanner;

import dao.Departmentserviceimpl;
import Model.Department;

public class Employeemanagement {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Departmentserviceimpl obj = new Departmentserviceimpl();
        
        while (true) {
        	
        System.out.println("-----------------------------------------");
        System.out.println("1. Display all department details");
        System.out.println("2. Display department details by dept ID");
        System.out.println("3. Delete records");
        System.out.println("4. Exit");
        System.out.println("-----------------------------------------");

        System.out.print("Choose the option: ");
        int option = s1.nextInt();

        switch (option) {
            case 1:
                List<Department> departments = obj.getAllDepartmentss();
                System.out.println("Department details are:");
                for (Department d : departments) {
                    System.out.println(d); // uses toString()
                }
                break;

            case 2:
                System.out.print("Enter Department ID: ");
                int id = s1.nextInt();
                Department dept = obj.getDepartmentById(id);
                if (dept != null) {
                    System.out.println("Department Found: " + dept);
                } else {
                    System.out.println("Department not found with ID: " + id);
                }
                break;
                
            case 3:
            	System.out.print("Enter Department ID to delete: ");
                int deleteId = s1.nextInt();
                boolean result = obj.deleteDepartmentById(deleteId);
                if (result) {
                    System.out.println("Department deleted successfully.");
                } else {
                    System.out.println("Department not found or could not be deleted.");
                }
                break;

            	
                
            case 4:
                System.out.println("Exiting program...");
                s1.close();
                System.exit(0);  
                break;

            default:
                System.out.println("Invalid option.");
        }

        }
    }
}
