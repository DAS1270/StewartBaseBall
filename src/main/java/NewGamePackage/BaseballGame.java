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
    ArrayList<ArrayList<String>> visitingTeamStats = new ArrayList<>();
    //String[][] visitingTeamStats = new String[9][9];
    //String[][] homeTeamStats = new String[9][9];
    int lastPlayerAtBat;


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

    public void generateGame() {
        inning = 1;
        gameTied = false;
        do {
            System.out.println("********** Start Inning:  " + inning + "  **********");
            playInning();
            System.out.println("********** End Inning:  " + inning + "  **********");
            System.out.println("Visiting Team Runs: " + visitingTeamRuns);
            System.out.println("Home Team Runs: " + homeTeamRuns);
            inning++;
        }
        while ((inning <= 9) || gameTied);
    }

    public void playInning() {
        System.out.println("********** Team Up:  " + visitingTeam + "  **********");
        playVisitingInning(visitingTeam,visitingTeamPlayers);
        //playHalfInning(visitingTeam,visitingTeamPlayers);
        //playHalfInning(homeTeam,homeTeamPlayers);
        System.out.println("********** Team Up:  " + homeTeam + "  **********");
        playHomeInning(homeTeam, homeTeamPlayers);
    }

    public void playVisitingInning(String teamName, String[] team) {
        int outs = 0;
        //Tracking bases
        boolean onBase1 = false;
        boolean onBase2 = false;
        boolean onBase3 = false;
        int adv = 0;

        String hits;
        int visitingTeamRuns = 0;
        int visitingPlayerAtBat = 0;

        while (outs < 3) {
                // Generate random number
                // Evaluate random number against switch statement or if/else-if/else
                // evaluate bases for runs TIP: use another method "evalBases()"

                for (int i = visitingPlayerAtBat; i < teamSize; i++) {
                    //hit
                    hits = generateHit();

                    //eval hit and set bases
                    switch (hits) {
                        case "Out":
                            outs++;
                            break;
                        case "HomeRun":
                            visitingTeamRuns++;
                            break;
                        case "Single":
                            if(onBase1 == true) {
                                onBase1 = false;
                                onBase2 = true;
                            }
                            if(onBase2 == true){
                                onBase2 = false;
                                onBase3 = false;
                            }
                            if(onBase3 == true){
                                onBase3 = false;
                                visitingTeamRuns++;
                            }
                            break;
                        case "Double":
                            if (onBase1 == true) {
                                onBase1 = false;
                                onBase2 = false;
                                onBase3 = true;
                            }
                            if(onBase2 == true){
                                onBase2 = false;
                                visitingTeamRuns++;
                                }
                            if(onBase3 == true){
                                onBase3 = false;
                                visitingTeamRuns++;
                                }
                                break;
                        case "Triple":
                            if (onBase1 == true) {
                                onBase1 = false;
                                onBase2 = false;
                                onBase3 = true;
                            }
                            if(onBase2 == true){
                                onBase2 = false;
                                visitingTeamRuns++;
                            }
                            if(onBase3 == true){
                                onBase3 = false;
                                visitingTeamRuns++;
                            }
                            break;

                            default: break;
                    }

                    System.out.println(visitingTeamPlayers[i] + ": " + hits);
                    // Keep track of who needs to bat next.  After player 9 you need to go to 1
                    if (i == 8) {
                        visitingPlayerAtBat = i;
                    }
                    if (outs == 3) {
                        System.out.println("3 OUTS - Switch!!");
                        visitingPlayerAtBat = i;
                        break;
                    }
                }
            }
        }
    public void playHomeInning(String teamName, String[] team) {
        int outs = 0;
        //Tracking bases
        boolean onBase1 = false;
        boolean onBase2 = false;
        boolean onBase3 = false;
        int adv = 0;

        String hits;
        int homeTeamRuns = 0;
        int homePlayerAtBat = 0;

        while (outs < 3) {
            // Generate random number
            // Evaluate random number against switch statement or if/else-if/else
            // evaluate bases for runs TIP: use another method "evalBases()"

            for (int i = homePlayerAtBat; i < teamSize; i++) {
                //hit
                hits = generateHit();

                //eval hit and set bases
                switch (hits) {
                    case "Out":
                        outs++;
                        break;
                    case "HomeRun":
                        homeTeamRuns++;
                        break;
                    case "Single":
                        if(onBase1 == true) {
                            onBase1 = false;
                            onBase2 = true;
                        }
                        if(onBase2 == true){
                            onBase2 = false;
                            onBase3 = false;
                        }
                        if(onBase3 == true){
                            onBase3 = false;
                            homeTeamRuns++;
                        }
                        break;
                    case "Double":
                        if (onBase1 == true) {
                            onBase1 = false;
                            onBase2 = false;
                            onBase3 = true;
                        }
                        if(onBase2 == true){
                            onBase2 = false;
                            homeTeamRuns++;
                        }
                        if(onBase3 == true){
                            onBase3 = false;
                            homeTeamRuns++;
                        }
                        break;
                    case "Triple":
                        if (onBase1 == true) {
                            onBase1 = false;
                            onBase2 = false;
                            onBase3 = true;
                        }
                        if(onBase2 == true){
                            onBase2 = false;
                            homeTeamRuns++;
                        }
                        if(onBase3 == true){
                            onBase3 = false;
                            homeTeamRuns++;
                        }
                        break;

                    default: break;
                }

                System.out.println(homeTeamPlayers[i] + ": " + hits);
                // Keep track of who needs to bat next.  After player 9 you need to go to 1
                if (i == 8) {
                    homePlayerAtBat = i;
                }
                if (outs == 3) {
                    System.out.println("3 OUTS - Switch!!");
                    homePlayerAtBat = i;
                    break;
                }
            }
        }
    }
    }

//evaluate current players base and increment by next player's hit.


