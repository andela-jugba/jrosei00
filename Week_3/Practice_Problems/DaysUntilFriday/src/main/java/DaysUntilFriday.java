
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class DaysUntilFriday {

    public static void main(String[] args) {

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Pick a day of the week.");

        String chosenDay = inputReader.nextLine();

        switch (chosenDay) {
            case "Monday":
            case "monday":
                System.out.println(4);
                break;
            case "Tuesday":
            case "tuesday":
                System.out.println(3);
                break;
            case "Wednesday":
            case "wednesday":
                System.out.println(2);
                break;
            case "Thursday":
            case "thursday":
                System.out.println(1);
                break;
            case "Friday":
            case "friday":
                System.out.println(0);
                break;
            case "Saturday":
            case "saturday":
                System.out.println(6);
                break;
            case "Sunday":
            case "sunday":
                System.out.println("5");
                break;

        }
    }
}
