
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
public class App {

    public static void main(String[] args) {

        SimpleCalculator mySimpleCalc = new SimpleCalculator();

        double operativeA = 0;
        double operativeB = 0;
        int addition = 1;
        int subtraction = 2;
        int multiplication = 3;
        int division = 4;
        int operationDecision;
        double addResult;
        double subResult;
        double multResult;
        double divResult;
        boolean redo = true;

        Scanner sc = new Scanner(System.in);

        do {
            //Choosing Numbers
            System.out.println("Choose your first number that is greater than 0.");
            operativeA = sc.nextDouble();
            sc.nextLine();
            System.out.println("Choose your second number");
            operativeA = sc.nextDouble();
            sc.nextLine();

            //Choosing Operation
            System.out.println("Type the number for your operation: 1 = addition; 2 = subtraction; 3 = multiplication; 4 = division; or 5 = To Exit");
            operationDecision = sc.nextInt();
            sc.nextLine();

            if (operationDecision == 1) {
                addResult = mySimpleCalc.add(operativeA, operativeB);
                System.out.println(addResult);
            } else if (operationDecision == 2) {
                subResult = mySimpleCalc.sub(operativeA, operativeB);
                System.out.println(subResult);
            } else if (operationDecision == 3) {
                multResult = mySimpleCalc.mult(operativeA, operativeB);
                System.out.println(multResult);
            } else if (operationDecision == 4) {
                divResult = mySimpleCalc.div(operativeA, operativeB);
                System.out.println(divResult);
            }

if (operationDecision == 5) {
                System.out.println("Thank you for using this calculator.");
                redo = false;
            }
        }     while (redo == true);
    }
}