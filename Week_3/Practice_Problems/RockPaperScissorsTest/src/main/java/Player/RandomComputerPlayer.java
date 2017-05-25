/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Game.GameEngine;
import Game.Player;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class RandomComputerPlayer implements Player {

    private static final int[] CHOICES = new int[]{GameEngine.ROCK, GameEngine.PAPER, GameEngine.SCISSORS};

    private final String name;
    private final Random random = new Random();

    public RandomComputerPlayer(String name) {
        this.name = name + " [Computer Player]";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getChoice() {
        return CHOICES[random.nextInt(CHOICES.length)];
    }

}
