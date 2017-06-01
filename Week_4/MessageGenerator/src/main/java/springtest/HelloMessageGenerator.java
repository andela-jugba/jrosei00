/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springtest;

import static springtest.HelloMessageGenerator.m;

/**
 *
 * @author apprentice
 */
public interface HelloMessageGenerator {
    MessageGenerator g = new HelloMessageGenerator();
    Messenger m = new Messenger(g);
    System.out.println(m.getMessage());
}
