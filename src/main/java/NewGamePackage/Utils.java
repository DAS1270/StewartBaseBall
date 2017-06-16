package NewGamePackage;

import java.util.Arrays;

/**
 * Created by DSQ7LH on 6/13/2017.
 */

public class Utils {
    private int range = 100;
    private String[] stats;

    //Constructors
    public Utils() {
    }

    public Utils(int range) {
        this.range = range;
    }

    public String generateHit() {
        int rangeFactor = range;
        String hit;
        int nbr = (int) (Math.random() * rangeFactor);
        if (nbr < 70) {
            hit = "Out";
            //hit = 0;
            //System.out.println("Out!");
        } else if (nbr > 70 && nbr < 88) {
            hit = "Single";
            //hit = 1;
            //System.out.println("Hit: Single");
        } else if (nbr > 87 && nbr < 95) {
            hit = "Double"; //
            //hit = 2;
            //System.out.println("Hit: Double");
        } else if (nbr > 94 && nbr < 97) {
            hit = "Triple"; //
            //hit = 3;
            //System.out.println("Hit: Triple");
        } else {
            hit = "Home Run";
            //hit = 4;
            //System.out.println("Home Run!");
        }
        return hit;
    }

    //to print arrays / arraylists from baseball game FIX!!
    public void printStats(String[] stats) {
        this.stats = stats;
        System.out.println(stats);
    }

    public void printTeamsAndPlayers(String team, String[] players) {
        System.out.println("Team and Players: " + team + "\n" + Arrays.toString(players));
    }

    public int trackBases(boolean onBase1, boolean onBase2, boolean onBase3, String hits) {
        int runs = 0;
        //Set advancer
        if (hits.contains("Single")) {
            if (onBase1 = true) {
                onBase1 = false;
                onBase2 = true;
            }
            if (onBase2 = true) {
                onBase2 = false;
                onBase3 = true;
            }
            if (onBase3 = true) {
                onBase3 = false;
                runs++;
            }
        }
        if (hits.contains("Double")) {
                if (onBase1 = true) {
                    onBase1 = false;
                    onBase3 = true;
                }
                if (onBase2 = true) {
                    onBase2 = false;
                    runs++;
                }
        }
        if (hits.contains("Triple")) {
                if (onBase1 = true) {
                    onBase1 = false;
                    runs++;
                }
                if (onBase2 = true) {
                    onBase2 = false;
                    runs++;
                }
                if (onBase3 = true) {
                    onBase3 = false;
                    runs++;
                }
        }
    return runs;
    }
}