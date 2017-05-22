
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CheckerboardIO {
    
    public static void main(String[] args) throws IOException {
        
        PrintWriter out = new PrintWriter(new FileWriter("Checkerboard.txt"));
        
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Checkerboard.txt")))
;
        for (int i = 1; i < 9; i++) {
            if (i % 2 != 0) {
                for (int j = 1; j < 9; j++) {
                    if (j % 2 == 0) {
                        out.println(" w ");
                    } else {
                        out.println(" b ");
                    }
                }
            } else {
                for (int j = 1; j < 9; j++) {
                    if (j % 2 == 0) {
                        out.println(" b ");
                    } else {
                        out.println(" w ");
                    }
                }
            }
            out.println("\n");
        }
        while(sc.hasNextLine());
        String currentLine = sc.nextLine();
        System.out.println(currentLine);
out.flush();
out.close();
    }
    
    
}
