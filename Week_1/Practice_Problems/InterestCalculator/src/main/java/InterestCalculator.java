
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
public class InterestCalculator {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        double interestRate = 0.00;
        double principalAmount;
        int yearsInFund;
        double currentBalance = 0.00;
        double annually = currentBalance * (1 + (interestRate * 4) / 100);
        double quarterly = currentBalance * (1 + interestRate / 100);

        System.out.println("Please enter the following information: ");
        System.out.println("Annual Interest Rate: ");
        interestRate = keyboard.nextDouble();
        System.out.println("Initial Amount of Principal: ");
        principalAmount = keyboard.nextDouble();
        System.out.println("Number of Years To Stay in Fund: ");
        yearsInFund = keyboard.nextInt();

        System.out.println("Year Number: " + (2013 + yearsInFund)
                + "\n Principal at Beginning of Year: " + currentBalance
                + "\n Interest Earned for the Year: " + (annually - currentBalance)
                + "\n Principal at End of Year: " + annually);
    }
}
