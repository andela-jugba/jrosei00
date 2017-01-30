package com.mycompany.healthyhearts;

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
public class HealthyHearts {
    public static void main(String[] args) {

    System.out.println("What is your age?");
    Scanner ageScanner = new Scanner (System.in);
    int age = ageScanner.nextInt();

    System.out.println("Your maximum heart rate should be " + (200 - age) + " beats per minute.");
    
    System.out.println("Your target HR zone is " + ((200 - age) * .5) + " - " + ((200 - age) * .85) + "beats per minute.");
    
    }
    
}
