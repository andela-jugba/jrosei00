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
        double sum = 0;
        double stBernard = Math.random();
        double chi = Math.random();
        double goldenRet = Math.random();
        double dach = Math.random();
        double sibHusky = Math.random();

        Scanner sc = new Scanner(System.in);

        System.out.println("What is your dog's name?");
        name = sc.nextLine();
        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here:");
        System.out.println(name + " is:");
        sum += stBernard;
        sum += chi;
        sum += goldenRet;
        sum += dach;
        sum += sibHusky;
        
        
        
        double stPercent = (stBernard / sum)*100;
        //int stFinal = (int)stPercent;
        double chiPercent = (chi/sum)*100;
        double goldenPercent = (goldenRet/sum)*100;
        double dachPercent = (dach/sum)*100;
        int sibPercent = 100 - ((int)stPercent + (int)chiPercent + (int)goldenPercent + (int)dachPercent);
        
        System.out.println((int)stPercent + "% St. Bernard.");
        System.out.println((int)goldenPercent + "% Golden Retriever.");
        System.out.println((int)chiPercent + "% Chihuaua.");
        System.out.println((int)dachPercent + "% Dachshund.");
        System.out.println((int)sibPercent + "% Siberian Husky.");
        
        System.out.println("Wow, that's QUITE the dog!");
    }
}
