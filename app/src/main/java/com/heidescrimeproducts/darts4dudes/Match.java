package com.heidescrimeproducts.darts4dudes;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by tak3r07 on 4/5/15. This class represents a match. It contains two players playing the
 * game and the whole set
 */
public class Match {

    /**
     * Those are both players playing the game
     */
    private Player player1;
    private Player player2;

    /**
     * This is the value with how many legs a player can win the game
     */
    private int bestOf;

    /**
     * HashMap which represents the played legs in relation to the players which have played the
     * leg
     */
    private HashMap<Leg, Player> legs;

    /**
     * Date on which day the match has been played
     */
    private Date date;


    /**
     * Constructor
     *
     * @param player1 First player
     * @param player2 Second Player
     * @param bestOf  Leg-cap
     */
    public Match(Player player1, Player player2, int bestOf) {
        this.player1 = player1;
        this.player2 = player2;
        this.bestOf = bestOf;

        //Create Date String
        date = GregorianCalendar.getInstance().getTime();
    }

    /**
     * Player1 getter
     *
     * @return Player-object
     */

    public Player getPlayer1() {
        return player1;
    }

    /**
     * Player2 getter
     *
     * @return Player-object
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Leg-cap getter
     *
     * @return leg-cap
     */
    public int getBestOf() {
        return bestOf;
    }

    /**
     * Date getter
     * @return date on which the match has been played
     */
    public Date getDate(){
        return this.date;
    }

}
