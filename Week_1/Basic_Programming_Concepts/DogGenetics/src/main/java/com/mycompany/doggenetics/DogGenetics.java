package com.mycompany.doggenetics;

import java.util.Random;
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
public class DogGenetics {

    public static void main(String[] args) {

        String name;
        int percentage = 100;
        int stBernard = 0;
        int chi = 0;
        int goldenRet = 0;
        int dach = 0;
        int sibHusky = 0;

        Random randomizer = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your dog's name?");
        name = sc.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here:");
        System.out.println(name + " is:");
        stBernard = randomizer.nextInt(101);
        stBernard = Math.min(stBernard, percentage);
        System.out.println(stBernard + "% St. Bernard.");
        chi = randomizer.nextInt(101);
        chi = Math.min(chi, percentage);
        System.out.println(chi + "% Chihuaua.");
        goldenRet = randomizer.nextInt(101);
        goldenRet = Math.min(goldenRet, percentage);
        System.out.println(goldenRet + "% Golden Retriever.");
        dach = randomizer.nextInt(101);
        dach = Math.min(dach, percentage);
        System.out.println(dach + "% Dachshund.");
        sibHusky = randomizer.nextInt(101);
        System.out.println(sibHusky + "% Siberian Husky.");
        
        Math.min(1, 100);
        
        System.out.println("Wow, that's QUITE the dog!");
    }
}
