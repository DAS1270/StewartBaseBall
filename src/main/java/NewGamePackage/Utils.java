package NewGamePackage;

/**
 * Created by DSQ7LH on 6/13/2017.
 */

public class Utils {
    private int range = 100;
    private String[] stats;

    //Constructors
    public Utils(){}

    public Utils(int range){
        this.range = range;
    }

    public String generateHit() {
        int rangeFactor = range;
        String hit;
        int nbr = (int) (Math.random()* rangeFactor);
        if (nbr < 70) {
            hit = "Out";
            //hit = 0;
            System.out.println("Out!");
        } else if (nbr > 70 && nbr < 88) {
            hit = "Single";
            //hit = 1;
            System.out.println("Hit: Single");
        } else if (nbr > 87 && nbr < 95) {
            hit = "Double"; //
            //hit = 2;
            System.out.println("Hit: Double");
        } else if (nbr > 94 && nbr < 97) {
            hit = "Triple"; //
            //hit = 3;
            System.out.println("Hit: Triple");
        } else {
            hit = "Home Run";
            //hit = 4;
            System.out.println("Home Run!");
        }
        return hit;
    }

    //to print arrays / arraylists from baseball game FIX!!
    public void printStats(String[] stats){
        this.stats = stats;
        System.out.println(stats);
    }

}