package com.heidescrimeproducts.darts4dudes;

/**
 * Created by tak3r07 on 4/5/15. This class is a helper to predict best shots
 */
public final class ShotAnalyzer {


    public static String getComb(int rest){
        //TODO: Use swich statement to determine which case and return each String Hardcoded
        return "";
    }

    /**
     * Convert a given shot from String form into an Integer like "T20,T20,S50" will be 170
     * @param shot String of the shot
     * @return Numeric value for the given String
     */
    public static int shotStringToInt(String shot) {
        String[] parts = shot.split(",");
        int value = 0;

        //Iterate over all parts of the shot and calculate the value of each part
        for (String part : parts) {
            switch (part.charAt(0)) {
                case 'S':
                    part = part.replace("S", "");
                    value += Integer.parseInt(part);
                    break;
                case 'D':
                    part = part.replace("D", "");
                    value += 2 * Integer.parseInt(part);
                    break;
                case 'T':
                    part = part.replace("T", "");
                    value += 3 * Integer.parseInt(part);
                    break;
            }
        }

        return value;
    }

}
