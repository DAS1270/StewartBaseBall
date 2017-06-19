package NewGamePackage;

/**
 * Created by DSQ7LH on 6/13/2017.
 */
public class PlayGameMain {
    public static void main(String[] args) {
        String homeTeam = "Sandy Springs Storm";
        String[] homeTeamPlayers =   {"Stewart","Hopper","Davis","Holbrook","Kirksey","Goodman","Nava","Hassler", "Zdanciwik"};
        //String[] homeTeamPlayers = { 0          1        2       3          4         5         6      7          8};

        String visitingTeam = "Sandy Plains Ice";
        String[] visitingTeamPlayers = {"Jones","Jackson","Smith","Reed","Green","Ganeson","Frank","Kelly", "Jeffery"};

        //BaseballGame startGame = new BaseballGame(visitingTeam, visitingTeamPlayers, homeTeam, homeTeamPlayers);
        BaseballGame startGame = new BaseballGame();
        startGame.setHomeTeam(homeTeam);
        startGame.setHomeTeamPlayers(homeTeamPlayers);
        startGame.setVisitingTeam(visitingTeam);
        startGame.setVisitingTeamPlayers(visitingTeamPlayers);
        startGame.generateGame();

        }
    }

/*    Output should be:

        Team A won game!
        Team A (5) - Team B (3)

        ----- Stats ------------
        Inning 1: Team A => Player 1(hit); Player 3(double); Player 4(triple)
        Inning 1: Team B => Player 2(hit);
        -------------------------
        Inning 2:
*/