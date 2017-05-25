/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author apprentice
 */
public class GameEngine {

    public enum Choice {
    ROCK, PAPER, SCISSORS;
    //public final static int ROCK = 1;
    //public final static int PAPER = 2;
    //public final static int SCISSORS = 3;
    }
 
    public enum Player {
    TIE, PLAYER_ONE_WIN, PLAYER_TWO_WIN;
        //public final static int TIE = 0;
    //public final static int PLAYER_ONE_WIN = 1;
    //public final static int PLAYER_TWO_WIN = -1;

    private Player playerOne;
    private Player playerTwo;

    public GameEngine(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
    }

    public int playRound() throws Exception {

        int p1Choice = getPlayerChoice(playerOne);
        int p2Choice = getPlayerChoice(playerTwo);

        int result = TIE;
        if (p1Choice == ROCK) {
            if (p2Choice == PAPER) {
                result = PLAYER_TWO_WIN;
            } else if (p2Choice == SCISSORS) {
                result = PLAYER_ONE_WIN;
            }
        } else if (p1Choice == PAPER) {
            if (p2Choice == ROCK) {
                result = PLAYER_ONE_WIN;
            } else if (p2Choice == SCISSORS) {
                result = PLAYER_TWO_WIN;
            }
        } else if (p1Choice == SCISSORS) {
            if (p2Choice == ROCK) {
                result = PLAYER_TWO_WIN;
            } else if (p2Choice == PAPER) {
                result = PLAYER_ONE_WIN;
            }
        }
        // Careful, choices not exhaustive...

        return result;
    }

    private int getPlayerChoice(Player player) throws Exception {
        int choice = player.getChoice();
        if (choice < ROCK || choice > SCISSORS) {
            String msg = String.format("%s's choice (%s) is invalid!", player.getName(), choice);
            throw new Exception(msg);
        }
        return choice;
    }
}