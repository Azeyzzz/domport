import java.util.*;
public class Simulator extends Generator {
    protected int simLevel;
    protected static int simPrice = 3;
    protected static int totalSimAmt;
    private static int simRate = 75;
    protected int score;
    Simulator(String simName, int simCost, int rate, int simNum, String simProd){
        super(simName, simCost, rate, simNum, simProd);
        totalSimAmt = simNum;
    }
    public static int getSimPrice(){
        return simPrice;
    }
    public static int getTotalSim(){
        return totalSimAmt;
    }
    public static int getSimRate(){
        return simRate;
    }
    public static int incrSimAmt(){
        totalSimAmt++;
        return totalSimAmt;
    }
    public static void startSimulator(){
        Simulator firstSim = new Simulator("Simulator: Lvl 1", simPrice, simRate, 1, "Driver Xp");
        incrSimAmt();
        TextManagementGame.addGenerator(firstSim);
    }
    public static void addNewSimulator(int lvl){
        Simulator newSim = new Simulator("Simulator: " + "Lvl: " + lvl, simPrice * lvl, simRate * lvl, getTotalSim(), "Driver Xp");
        incrSimAmt();
        TextManagementGame.addGenerator(newSim);
    }
    public static int getSimIncome(){
        int simIncome = 0;
        for(Generator simulator : TextManagementGame.generators){
            if(simulator instanceof Simulator){
               simIncome += ((Generator)simulator).getResourceProductionRate();     
            }  
        }
        return simIncome;
    }
    @Override
    public String toString(){
        return "Name: "+this.getName() + ", Production Rate: "+this.getResourceProductionRate() + " Xp, Cost: $" +this.getConstructionCost() + " million, Total Prod: " + this.numberConstructed + ", Produces: Driver Xp";
    }
    //score if found by the weekly production rate divided by 75 since 75 xp is produced each week
    @Override
    public int scoreImpact() {
        for (Generator g : TextManagementGame.generators){
            if(g instanceof Simulator){
                score += g.getResourceProductionRate()/75;
            }
        }
        return this.score;
    }
}