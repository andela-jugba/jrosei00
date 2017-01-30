package com.mycompany.summativearray;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class SummativeArray {
    public static void main(String [] args) {
        
        int array1[] = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int array2[] = {999, -60, -77, 14, 160, 301};
        int array3[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};
        
        int sum1 = 0;
        for (var arrayPosition = 0; arrayPosition < array1.length)
            sum1 += 1;
        int sum2 = 0;
        for (var arrayPosition2 = 0; arrayPosition < array2.length)
            sum2 += 1;
        int sum3 = 0;
        for (var arrayPosition3 = 0; arrayPosition < array3.length)
            sum3 += 1;
            
        System.out.println("#1 Array Sum: " + sum1);
        System.out.println("#2 Array Sum: " + sum2);
        System.out.println("#3 Array Sum: " + sum3);
        
    }
}
