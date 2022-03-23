package com.example.universitydepartments.services;

public class MessageService {
    public static void askUserForInput() {
        System.out.println("Show the head of department: press 1 ");
        System.out.println("Show department statistics: press 2 ");
        System.out.println("Show the average salary for department: press 3");
        System.out.println("Show count of employee of department: press 4 ");
        System.out.println("Global search: press 5 ");
    }

    public static void showInputWarning() {
        System.out.println("Wrong input,please try again");
    }

    public static void departmentMessage() {
        System.out.println("Enter department name from list: Faculty of Economics, Faculty of Architecture, Faculty of Law");
    }
}
