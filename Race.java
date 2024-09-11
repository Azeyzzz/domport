import java.util.*;

public class Race extends Event{
    protected static int racePosition = 0;
    static Random raceRand = new Random();
    protected static int backMin = 10;
    protected static int backMax = 5;
    protected static int middleMin = 8;
    protected static int middleMax = 1;
    protected static int topMin = 4;
    protected static int topMax = 1;
    protected static ArrayList<Race> raceResults = new ArrayList<Race>();
    Race(String rName, int racePos){
        super(rName);
        this.racePosition = racePos;
    }
    //gives a certain chance of getting a higher finishing position based off performance and driver level.
     public static int raceSim(String raceName){
        int racePerformance =0;
        racePerformance = UpgradePoints.getPerf() + (DriverXp.getDriLvl() *100);
        if (racePerformance > 1 && racePerformance <= 999){
            racePosition = raceRand.nextInt(backMin - backMax +1) + backMax;
        }    
        if (racePerformance >= 1000 && racePerformance <= 1990){
            racePosition = raceRand.nextInt(middleMin - middleMax+1) + middleMax;
        }
        if(racePerformance >= 2000){
            racePosition = raceRand.nextInt(topMin - topMax +1) + topMax;
        }
        Race newRace = new Race(raceName, racePosition);
        raceResults.add(newRace);
        System.out.println("In Race: " + raceName + ", You finished " + racePosition + " out of 10");
        return racePosition;
    }
    
    public String toString(){
        return "Race Name: " + this.getName() + ", Result: " + this.racePosition + " out of 10th";
    }
}
