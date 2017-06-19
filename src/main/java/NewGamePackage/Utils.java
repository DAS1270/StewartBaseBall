package NewGamePackage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DSQ7LH on 6/13/2017.
 */

public class Utils {
    private int range = 100;
    int out;
    boolean onBase1 = false;
    boolean onBase2 = false;
    boolean onBase3 = false;

    //private String homeTeam = getHomeTeam();
    //private String visitingTeam = startUtil.getVisitingTeam();

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
            hit = "Double";
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


    public void printTeamsAndPlayers(String team, String[] player) {
        System.out.println(team + "\n Players:" + Arrays.toString(player) + "\n");
    }

    //set next batter
     /*public int setNextVisitingBatter(String[] teamArray, String playerNum) {
        getArrayIndex(teamArray, visitingTeamPlayers[i] + 1));
        } else {
            nextVisitingPlayerAtBat = (getArrayIndex(visitingTeamPlayers, visitingTeamPlayers[i]));
        }
    }*/

    //evaluates hit and returns runs, based on team given.
    public int evalHits(String hit, String team) {
        int visitingHitRuns = 0;
        int homeHitRuns = 0;

        switch (hit) {
            //case "Out":
            //outs++;
            //break;
            case "Single":
                //set the basemen
                if (onBase3 == true) {
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (onBase2 == true) {
                    onBase2 = false;
                    onBase3 = true;
                }
                if (onBase1 == true) {
                    onBase1 = false;
                    onBase2 = true;
                }
                //set the runner
                onBase1 = true;
                break;
            case "Double":
                if (onBase3 == true) {
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (onBase2 == true) {
                    onBase2 = false;
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (onBase1 == true) {
                    onBase1 = false;
                    onBase2 = false;
                    onBase3 = true;
                }
                onBase2 = true;
                break;
            case "Triple":
                if (onBase3 == true) {
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (onBase2 == true) {
                    onBase2 = false;
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (onBase1 == true) {
                    onBase1 = false;
                    onBase2 = false;
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                onBase3 = true;
                break;
            case "Home Run":
                if (onBase1 == true) {
                    onBase1 = false;
                    onBase2 = false;
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (onBase2 == true) {
                    onBase2 = false;
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (onBase3 == true) {
                    onBase3 = false;
                    if (team == "visitors") {
                        visitingHitRuns++;
                    } else homeHitRuns++;
                }
                if (team == "visitors") {
                visitingHitRuns++;
                } else homeHitRuns++;
                break;
            default:
                break;
        }
        if (team == "visitors") {
            return visitingHitRuns;
        } else return homeHitRuns;
    }

    public int evalOut(String hit) {
        if (hit.contains("Out")) {
            out = 1;
        } else out = 0;
        return out;
    }

    public int getLastPlayer(ArrayList<String> teamPlayers, String player) {
        for (int i = 0; i < teamPlayers.size(); i++) {
            if (teamPlayers.get(i).equalsIgnoreCase(player)) {
                return i + 1;
            }
        }
        return 0;
    }

    public void clearBasesBetweenInnings() {
        onBase1 = false;
        onBase2 = false;
        onBase3 = false;
    }
}