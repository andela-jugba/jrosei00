
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
public class InterestCalculatorRefactored {

    Scanner keyboard = new Scanner(System.in);

    double interestRate;
    double principalAmount;
    int yearsInFund;
    double currentBalance;
    double annually;
    double quarterly;
        
    public InterestCalculatorRefactored(double interestRate, double currentBalance) {
        this.interestRate = interestRate;
        this.currentBalance = currentBalance;
        this.annually = this.currentBalance * (1 + (this.interestRate * 4) / 100);
        this.quarterly = this.currentBalance * (1 + this.interestRate / 100);
    }
    
    public void annualInterestRate() {
        System.out.println("Annual Interest Rate: ");
        interestRate = keyboard.nextDouble();
    }

    public void princialAmount() {
        System.out.println("Initial Amount of Principal: ");
        principalAmount = keyboard.nextDouble();
    }

    public void NumberYearsToStay() {
        System.out.println("Number of Years To Stay in Fund: ");
        yearsInFund = keyboard.nextInt();
    }

    public void yearsInFund() {
        System.out.println("Year Number: " + (2017 + yearsInFund)
                + "\n Principal at Beginning of Year: " + currentBalance
                + "\n Interest Earned for the Year: " + (annually - currentBalance)
                + "\n Principal at End of Year: " + annually);
    }
}
