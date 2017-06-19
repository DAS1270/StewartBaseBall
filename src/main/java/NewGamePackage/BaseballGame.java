package NewGamePackage;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by DSQ7LH on 6/13/2017.
 */

public class BaseballGame extends Utils {
    //Teams - don't need to define here; using setters and getters.
    private String homeTeam;
    private String visitingTeam;

    //Players - don't need to define here; using setters and getters.
    private String[] visitingTeamPlayers;
    private String[] homeTeamPlayers;

    //Game Rules
    int totalInnnings = 9;
    int inning;
    boolean gameTied;

    //Runs and Player Hits
    int homeTeamRuns = 0;
    int visitingTeamRuns = 0;
    int lastvPlayer;
    int lasthPlayer;
    String winner;


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
    public void setHomeTeam(String homeTeam) {this.homeTeam = homeTeam;}

    public String getHomeTeam() {return homeTeam;}

    public void setVisitingTeam(String visitingTeam) {this.visitingTeam = visitingTeam;}

    public String getVisitingTeam() {return visitingTeam;}

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
            System.out.println(">>>>>>>>>>>> START INNING:  " + inning + "  <<<<<<<<<<<<<<");
            playInning();
            System.out.println(">>>>>>>>>>>>>  END INNING:  " + inning + "  <<<<<<<<<<<<<<<");
            System.out.println("Score: \n"+visitingTeam+"- "+visitingTeamRuns+"\n"+homeTeam+"- "+homeTeamRuns);
            gameTied = isGameTied(visitingTeamRuns,homeTeamRuns);
            if (inning == 9 && gameTied == false){
                System.out.println(">>>>>>>>>> END OF GAME <<<<<<<<<<<");
                System.out.println(winner+" WON");
                System.out.println(visitingTeam+": "+visitingTeamRuns);
                System.out.println(homeTeam+": "+homeTeamRuns);
            }
            inning++;
        }
        while ((inning <= 9));
        if (gameTied == true){
            System.out.println("GAME TIED:  EXTRA INNINGS!!");
            System.out.println(">>>>>>>>>>>> START EXTRA INNING:  " + inning + "  <<<<<<<<<<<<<<");
            playInning();
            System.out.println(">>>>>>>>>> END OF GAME <<<<<<<<<<<");
            System.out.println(winner+" WINS!!");
            System.out.println(visitingTeam+": "+visitingTeamRuns);
            System.out.println(homeTeam+": "+homeTeamRuns);
        }
    }

    public void playInning() {
        System.out.println("**********  " + visitingTeam + "  **********");
        playVisitingInning(visitingTeam, visitingTeamPlayers);
        System.out.println("**********  " + homeTeam + "  **********");
        playHomeInning(homeTeam, homeTeamPlayers);
        if (homeTeamRuns>visitingTeamRuns){
            winner = getHomeTeam();
        } else winner = getVisitingTeam();
    }

    public void playVisitingInning(String teamName, String[] teamPlayers) {
        //convert player array to an arraylist
        ArrayList<String> visitingTeamList = new ArrayList<String>(Arrays.asList(visitingTeamPlayers));
        int outs = 0;
        String hits = "No Hit";
        int nextVisitingPlayerAtBat = 0;

        while (outs < 3) {
            for (int i = lastvPlayer; i < 10; i++) {
                //1- hit
                hits = generateHit();
                System.out.println(visitingTeamPlayers[i] + ": " + hits);

                //2- eval hit and return runs
                visitingTeamRuns = (evalHits(hits, "visitors")) + visitingTeamRuns;

                //3- eval outs
                //outs = outs + evalOut(hits);
                outs = evalOut(hits) + outs;

                //4- eval runner count... if player count = 8, start the line up over at 1
                if (i == 8) {
                    i = 0;
                }

                //5- eval out count ... if 3 outs, Record next player at bat and break
                if (outs == 3) {
                    lastvPlayer = getLastPlayer(visitingTeamList,visitingTeamPlayers[i]);
                    clearBasesBetweenInnings();
                    break;
                }
            }
        }
    }


    public void playHomeInning(String teamName, String[] team) {
        //convert player array to an arraylist
        ArrayList<String> homeTeamList = new ArrayList<String>(Arrays.asList(homeTeamPlayers));
        int outs = 0;
        String hits = "No Hit";
        int nextHomeTeamPlayerAtBat = 0;

        while (outs < 3) {
            for (int i = lasthPlayer; i < 10; i++) {
                //1- hit
                hits = generateHit();
                System.out.println(homeTeamPlayers[i] + ": " + hits);

                //2- eval hit and return runs
                homeTeamRuns = (evalHits(hits, "home")) + homeTeamRuns;

                //3- eval outs
                //outs = outs + evalOut(hits);
                outs = evalOut(hits) + outs;

                //4- eval runner count... if player count = 8, start the line up over at 1
                if (i == 8) {
                    i = 0;
                }

                //5- eval out count ... if 3 outs, Record next player at bat and break
                if (outs == 3) {
                    System.out.println("3 OUTS - Switch!!");
                    lasthPlayer = getLastPlayer(homeTeamList,homeTeamPlayers[i]);
                    clearBasesBetweenInnings();
                    break;
                }
            }
        }
    }

}



