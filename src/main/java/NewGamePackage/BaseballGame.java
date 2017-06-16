package NewGamePackage;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DSQ7LH on 6/13/2017.
 */

public class BaseballGame extends Utils {
    //Teams - don't need to define here; using setters and getters.
    private String homeTeam;
    private String visitingTeam;

    //Players - don't need to define here; using setters and getters.
    //private String[] visitingTeamPlayers = {"vPlayer1", "vPlayer2", "vPlayer3", "vPlayer4", "vPlayer5", "vPlayer6", "vPlayer7", "vPlayer8", "vPlayer9"};
    //private String[] homeTeamPlayers = {"hPlayer1", "hPlayer2", "hPlayer3", "hPlayer4", "hPlayer5", "hPlayer6", "hPlayer7", "hPlayer8", "hPlayer9"};
    private String[] visitingTeamPlayers;
    private String[] homeTeamPlayers;

    //Game Rules
    int totalInnnings = 9;
    //boolean extraInnings = false;
    int teamSize = 9;
    int inning;
    boolean gameTied;

    //Runs and Player Hits
    int homeTeamRuns = 0;
    int visitingTeamRuns = 0;
    String[][] visitingTeamStats = new String[9][9];
    String[][] homeTeamStats = new String[9][9];
    int lastPlayerAtBat;

    //Tracking bases
    public boolean onBase1 = false;
    public boolean onBase2 = false;
    public boolean onBase3 = false;

    //Constructors - not needed due to use of getters and setters
        /*public BaseballGame(String homeTeam, String[] homeTeamPlayers, String visitingTeam, String[] visitingTeamPlayers){
            this.homeTeam = homeTeam;
            this.homeTeamPlayers = homeTeamPlayers;
            this.visitingTeam = visitingTeam;
            this.visitingTeamPlayers = visitingTeamPlayers;
        }

    public BaseballGame() {
    }*/

    //Setters and Getters
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setVisitingTeam(String visitingTeam) {
        this.visitingTeam = visitingTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public void setVisitingTeamPlayers(String[] teamPlayers) {
        this.visitingTeamPlayers = teamPlayers;
    }

    public String[] getVisitingTeamPlayers() {
        return visitingTeamPlayers;
    }

    public void setHomeTeamPlayers(String[] teamPlayers) {
        this.homeTeamPlayers = teamPlayers;
    }

    public String[] getHomeTeamPlayers() {
        return homeTeamPlayers;
    }



    //used to debug code
    public void createStatsArrays(String team, String[] teamPlayers) {
        for (int i = 0; i < teamPlayers.length; i++) {
            if (team == visitingTeam) {
                visitingTeamStats[0][i] = teamPlayers[i];
            }
            if (team == homeTeam) {
                homeTeamStats[0][i] = teamPlayers[i];
            }
            System.out.println(Arrays.toString(homeTeamStats));
            System.out.println(Arrays.toString(visitingTeamStats));
        }
    }

    public void generateGame() {
        inning = 1;
        gameTied = false;
        do {
                System.out.println("********** Start Inning:  "+inning+"  **********");
            playInning();
            System.out.println("********** End Inning:  "+inning+"  **********");
                System.out.println("Visiting Team Runs: "+visitingTeamRuns);
                System.out.println("Home Team Runs: "+homeTeamRuns);
            inning++;
        }
        while ((inning <= 9) || gameTied);
    }

    public void playInning() {
        System.out.println("********** Team Up:  "+visitingTeam+"  **********");
        playHalfInning(visitingTeam, visitingTeamStats);
        //playHalfInning(visitingTeam,visitingTeamPlayers);
        //playHalfInning(homeTeam,homeTeamPlayers);
        System.out.println("********** Team Up:  "+homeTeam+"  **********");
        playHalfInning(homeTeam, homeTeamStats);
    }

    public void playHalfInning(String teamName, String[][] team) {
        //public void playHalfInning(String teamName, String[] visitingTeam){
        int outs = 0;
        String hits;
        int visitingPlayerAtBat;
        int homePlayerAtBat;
        int adv = 0;

        while (outs < 3) {

            // Generate random number
            // Evaluate random number against switch statement or if/else-if/else
            // evaluate bases for runs TIP: use another method "evalBases()"
            for (int i = 0; i < teamSize; i++) {
                hits = generateHit();
                if (teamName == visitingTeam) {
                    visitingTeamStats[inning][i] = hits;    ///hits then players     //Integer.toString(hits);
                    if (hits.contains("Home Run")) {
                        visitingTeamRuns++;
                    }
                }
                if (teamName == homeTeam) {
                    homeTeamStats[inning][i] = hits;    ///hits then players     //Integer.toString(hits);
                    if (hits.contains("Home Run")) {
                        homeTeamRuns++;
                    }
                }
                if (hits.contains("Out")) {
                    outs++;
                }
                switch (hits) {
                    case "Single":
                        //onBase1 = true;
                        adv = 1;
                        break;
                    case "Double":
                        //onBase2 = true;
                        adv = 2;
                        break;
                    case "Triple":
                        //onBase3 = true;
                        adv = 3;
                    default:
                        break;
                }
                System.out.println(visitingTeamPlayers[i]+": "+hits);
                // Keep track of who needs to bat next.  After player 9 you need to go to 1
                if (i == 8) {
                    i = 0;
                }
                if (outs == 3) {
                    System.out.println("3 OUTS - Switch!!");
                    visitingPlayerAtBat = i;
                    break;
                }
            }

        }
    }
}

//evaluate current players base and increment by next player's hit.


