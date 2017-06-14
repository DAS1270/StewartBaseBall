package NewGamePackage;

/**
 * Created by DSQ7LH on 6/13/2017.
 */

public class Utils {
    private int range = 4;
    private String[] stats;

    //Constructors
    public Utils(){}

    public Utils(int range){
        this.range = range;
    }

    public int generateHit() {
        int rangeFactor = range;
        int hit = (int) (Math.random()* rangeFactor);
        return hit;
    }

    //to print arrays / arraylists from baseball game FIX!!
    public void printStats(String[] stats){
        this.stats = stats;
        System.out.println(stats);
    }

    public void playInning()
}