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

    public static void main(String[] args) {

        int array1[] = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int array2[] = {999, -60, -77, 14, 160, 301};
        int array3[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99};

        /*int sum1 = 0;
        for (arrayPosition = 0; arrayPosition1 < array1.length) {
            sum1 += 1;
            int sum2 = 0;
            for (arrayPosition2 = 0; arrayPosition2 < array2.length) {
                sum2 += 1;
                int sum2 = 0;
                for (array3.length == 0; array3.length == 5; array3[] += sum3) {
                    
         */
        System.out.println("#1 Array Sum: " + SumArray(array1));
        System.out.println("#2 Array Sum: " + SumArray(array2));
        System.out.println("#3 Array Sum: " + SumArray(array3));

    }

    private static int SumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;

       }
}

