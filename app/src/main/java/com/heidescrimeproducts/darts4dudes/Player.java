package com.heidescrimeproducts.darts4dudes;

import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;

/**
 * Created by tak3r07 on 4/5/15. This class represents a player of a game. A player has a list of
 * all his matches
 */
public class Player {

    private ArrayList<Match> matches;
    private UUID uuid;

    private String name;

    /**
     * Constructor for Player Leave uuid NULL if player is new
     *
     * @param matches
     * @param name
     * @param uuid
     */
    public Player(ArrayList<Match> matches, String name, UUID uuid) {
        this.matches = matches;
        this.name = name;

        //If player is new: create uuid
        if (uuid == null) {
            this.uuid = UUID.randomUUID();
        } else {
            this.uuid = uuid;
        }
    }


    public ArrayList<Match> getMatches() {
        return matches;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void addMatch(Match match) {
        this.matches.add(match);
    }


    /**
     * Calculates 3-Dart-average over all played match of this player
     * @return 3-Dart-average as double
     */
    public double get3DartAverage() {
        //TODO: Calculate average over all Matches


        ArrayList<String> allShots = new ArrayList<>();
        //Get all shots from all matches and all legs
        for (Match match : matches) {
            ArrayList<Leg> playedLegs = match.getLegsByPlayer(this);
            for (Leg leg : playedLegs) {
                for(String shot : leg.getShots()){
                    allShots.add(shot);
                }
            }
        }

        //Calculate average of all shots
        double average = 0;


        for(String shot : allShots){
            average += ShotAnalyzer.shotStringToInt(shot);
        }

        average = average / allShots.size();

        return average;
    }

}
