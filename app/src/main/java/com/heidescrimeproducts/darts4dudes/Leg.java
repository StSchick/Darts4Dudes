package com.heidescrimeproducts.darts4dudes;

import java.util.ArrayList;

/**
 * Created by tak3r07 on 4/5/15.
 * <p/>
 * This class represents a leg which is being played. It can be stored for statistics. Each user has
 * a list of his played legs. A game contains two legs.
 */
public class Leg {

    /**
     * This ArrayList contains String in the Form of something like "T20,T20,D20" which stands for
     * triple 20, triple 20 and double 20
     */
    private ArrayList<String> shots;


    /**
     * Constructor initializes a new Leg
     */
    Leg() {
        this.shots = new ArrayList<>();
    }

    /**
     * Adds a new shot to the leg
     *
     * @param shot String like "T20,T20,D20"
     */
    public void addShot(String shot) {
        this.shots.add(shot);
    }

    /**
     * Getter for shots
     *
     * @return ArrayList of shots of this leg
     */
    public ArrayList<String> getShots() {
        return shots;
    }

    /**
     * Setter for shots
     *
     * @param shots ArrayList of shots for this leg
     */
    public void setShots(ArrayList<String> shots) {
        this.shots = shots;
    }

    /**
     * Calculates 3-Dart average of this leg
     * @return
     */
    public double get3DartAverage() {
        double average = 0;
        //Iterate over all shots
        for (String shot : shots) {
            //Get integer of the string
            average += ShotAnalyzer.shotStringToInt(shot);
        }
        //Divide by shot-size
        average = average / shots.size();
        //Maybe do average = average/(shots.size()+0.d) for double casting
        return average;
    }


}
