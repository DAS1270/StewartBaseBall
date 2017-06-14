package NewGamePackage;

/**
 * Created by DSQ7LH on 6/13/2017.
 */

public class BaseballGame extends Utils {

        //Game Variables
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

        //Play Game
        //Game Stats
        int bases = 0;
        int homeTeamRuns = 0;
        int visitingTeamRuns = 0;

        //int visitingPlayerCount = 1;
        int homePlayerAtBat = 1;
        int rangeFactor = 100;

        //Constructors - not needed due to use of getters and setters
        /*public BaseballGame(String homeTeam, String[] homeTeamPlayers, String visitingTeam, String[] visitingTeamPlayers){
            this.homeTeam = homeTeam;
            this.homeTeamPlayers = homeTeamPlayers;
            this.visitingTeam = visitingTeam;
            this.visitingTeamPlayers = visitingTeamPlayers;
        }*/

        public BaseballGame(){}

        //Setters and Getters
        public void setHomeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
        }

        public String getHomeTeam() {
            return homeTeam;
        }

        public String getVisitingTeam() {
            return visitingTeam;
        }

        public void setVisitingTeam(String visitingTeam) {
            this.visitingTeam = visitingTeam;
        }

        public void setVisitingTeamPlayers(String[] visitingTeamPlayers) {
            this.visitingTeamPlayers = visitingTeamPlayers;
        }

        public void setHomeTeamPlayers(String[] homeTeamPlayers) {
            this.homeTeamPlayers = homeTeamPlayers;
        }

    //Method: Generate Game FIX
        public void generateGame() {
            boolean gameTied = false;
            boolean extraInnings = false;
            int inning = 1;
            do{
                //***********************First Half of Inning**************************************//
                System.out.println("****************Start Inning " + inning + "****************");
                System.out.println("Top Half of Inning " + inning + ".  Visiting Team Up!");
                int outs = 0;
                for (int i = 0; i < visitingTeamPlayers.length + 1; i++) {
                    int bat = (int) (Math.random() * rangeFactor);
                    if (bat < 70) {
                        bases = 0;
                        outs++;
                        System.out.println(visitingTeamPlayers[i] + ": OUT!");
                    } else if (bat > 70 && bat < 88) {
                        bases = 1;
                        System.out.println(visitingTeamPlayers[i] + ": Single");
                    } else if (bat > 87 && bat < 95) {
                        bases = 2;
                        System.out.println(visitingTeamPlayers[i] + ": Double");
                    } else if (bat > 94 && bat < 97) {
                        bases = 3;
                        System.out.println(visitingTeamPlayers[i] + ": Triple");
                    } else {
                        bases = 4;
                        visitingTeamRuns++;
                        System.out.println(visitingTeamPlayers[i] + ": HOME RUN!");
                    }
                    if (i == 8) {
                        i = 0;
                    }
                    if (outs == 3) break;
                }
                //***********************Start Second Half of Inning**************************************//
                outs = 0;
                System.out.println("Bottom Half of Inning " + inning + "  Home Team Up!");
                for (int i = 0; i < visitingTeamPlayers.length + 1; i++) {
                    int bat = (int) (Math.random() * rangeFactor);
                    if (bat < 70) {
                        bases = 0;
                        outs++;
                        System.out.println(visitingTeamPlayers[i] + ": OUT!");
                    } else if (bat > 70 && bat < 88) {
                        bases = 1;
                        System.out.println(visitingTeamPlayers[i] + ": Single");
                    } else if (bat > 87 && bat < 95) {
                        bases = 2;
                        System.out.println(visitingTeamPlayers[i] + ": Double");
                    } else if (bat > 94 && bat < 97) {
                        bases = 3;
                        System.out.println(visitingTeamPlayers[i] + ": Triple");
                    } else {
                        bases = 4;
                        visitingTeamRuns++;
                        System.out.println(visitingTeamPlayers[i] + ": HOME RUN!");
                    }

                    if (i == 8) {
                        i = 0;
                    }
                    if (outs == 3) break;
                }

                inning++;
                if(homeTeamRuns == visitingTeamRuns){
                    gameTied = true;
                }
                System.out.println("**************Starting Inning: " + inning + "*******************");
                System.out.println("****************End of Game!!******************");
                System.out.println("Home Team Score: " + homeTeamRuns);
                System.out.println("Visiting Team Score: " + visitingTeamRuns);

            } while ((inning <= 9 || gameTied)
        }
        //Method: Play Inning
        public void playInning(String[] visitingTeam, String[] homeTeam){
            playHalfInning(visitingTeam);
            playHalfInning(homeTeam);
        }

    //Method: Play Half Inning
        public void playHalfInning(String[] visitingTeamPlayers){
            System.out.println("Top Half of Inning " + inning + ".  Visiting Team Up!");
            int outs = 0;
            while (outs<3){
                for (int i = 0; i < visitingTeamPlayers.length + 1; i++) {
                    int bat = (int) (Math.random() * rangeFactor);
                        if (bat < 70) {
                        bases = 0;
                        outs++;
                        System.out.println(visitingTeamPlayers[i] + ": OUT!");
                    }
                    else if (bat > 70 && bat < 88) {
                        bases = 1;
                        System.out.println(visitingTeamPlayers[i] + ": Single");
                }
                    else if (bat > 87 && bat < 95) {
                        bases = 2;
                        System.out.println(visitingTeamPlayers[i] + ": Double");
                }
                    else if (bat > 94 && bat < 97) {
                        bases = 3;
                        System.out.println(visitingTeamPlayers[i] + ": Triple");
                }
                else {
                    bases = 4;
                    visitingTeamRuns++;
                    System.out.println(visitingTeamPlayers[i] + ": HOME RUN!");
                        }
                if (i == 8) i = 0;
            }
        }
}
}
