package com.example.universitydepartments;

import com.example.universitydepartments.services.MainService;
import com.example.universitydepartments.services.SaveEntities;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Scanner;

import static com.example.universitydepartments.services.MessageService.askUserForInput;
import static com.example.universitydepartments.services.MessageService.departmentMessage;
import static com.example.universitydepartments.services.MessageService.showInputWarning;

@SpringBootApplication
@EntityScan
public class UniversityDepartmentsApplication {
    public static Scanner scanner = new Scanner(System.in);
    public static MainService input = new MainService();

    public static void main(String[] args) {
        SpringApplication.run(UniversityDepartmentsApplication.class, args);

        SaveEntities saveEntities = new SaveEntities();
        saveEntities.saveAllModels();
        scan();

    }

    public static void continueLoop() {
        System.out.println("Do you want to continue working with the application? Y/N");
        String choise = scanner.nextLine();

        switch (choise) {
            case "Y":
                scan();
                break;
            case "N":
                System.out.println("Exit the application");
                scanner.close();
                break;
            default:
                showInputWarning();
                continueLoop();
                break;
        }
    }

    public static void scan() {
        askUserForInput();

        String next = scanner.nextLine();
        switch (next) {
            case "1":
                departmentMessage();
                input.headOfDepartment(scanner.nextLine());
                continueLoop();
                break;
            case "2":
                departmentMessage();
                input.departmentStatistics(scanner.nextLine());
                continueLoop();
                break;
            case "3":
                departmentMessage();
                input.averageSalary(scanner.nextLine());
                continueLoop();
                break;
            case "4":
                departmentMessage();
                input.countOfEmployee(scanner.nextLine());
                continueLoop();
                break;
            case "5":
                System.out.println("Search:");
                input.globalSearch(scanner.nextLine());
                continueLoop();
                break;
            default:
                showInputWarning();
                scan();
                break;
        }
    }

}
