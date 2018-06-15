package View;

import Controller.ConsoleMethods;
import Model.Degree;
import Model.Departments;
import Model.Lectors;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    ConsoleMethods consoleMethods = new ConsoleMethods();
    public void start(){
        System.out.println("Please choose a function and enter number\n\n" +
                "To select, enter the correct number in the terminal \n" +
                "1.Head of department \n" +
                "2.Show statistic of department \n" +
                "3.Show avarage salary for department \n" +
                "4.Show count of employee for department \n" +
                "5.Global search \n" +
                "6.Exit");

        Scanner scanner = new Scanner(System.in);
        switch (scanner.next()){
            case "1":
                System.out.println("Please enter department name.");
                System.out.println(consoleMethods.headOfDepartment(returnText()));
                break;
            case "2":
                System.out.println("Please enter department name.");
                System.out.println(consoleMethods.showStatistic(returnText()));
                break;
            case "3":
                System.out.println("Please enter department name.");
                System.out.println(consoleMethods.avarageSalary(returnText()));
                break;
            case "4":
                System.out.println("Please enter department name.");
                System.out.println(consoleMethods.countOfEmployee(returnText()));
                break;
            case "5":
                System.out.println("Please enter.");
                System.out.println(consoleMethods.globalSearch(returnText()));
                break;
            case "6":
                new ConsoleMethods().endSesionFactory();
                System.exit(0);
                break;
            default:
                System.out.println("Failed");
                start();
                break;

        }
        start();
    }

    private String returnText(){
        return new Scanner(System.in).next();
    }
}
