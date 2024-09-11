import java.util.*;
public class Sponsorship extends Generator {
    protected int sponLevel;
    protected static int sponPrice = 5;
    protected static int totalSponAmt;
    private static int sponRate = 2;
    protected int score;
    Sponsorship(String sponName, int sponCost, int rate, int sponNum, String sponProd){
        super(sponName, sponCost, rate, sponNum, sponProd);
        totalSponAmt = sponNum;
    }
    public static int getSponPrice(){
        return sponPrice;
    }
    public static int getTotalSpon(){
        return totalSponAmt;
    }
    public static int getSponRate(){
        return sponRate;
    }
    public static int incrSponAmt(){
        totalSponAmt++;
        return totalSponAmt;
    }
    public static void startSponsorship(){
        Sponsorship firstSpon = new Sponsorship("Sponsorship: Lvl 1", sponPrice, sponRate, 1, "Money");
        incrSponAmt();
        TextManagementGame.addGenerator(firstSpon);
    }
    public static void addNewSponsorship(int lvl){
        Sponsorship newSpon = new Sponsorship("Sponsorship: " + "Lvl: " + lvl, sponPrice * lvl, sponRate * lvl, getTotalSpon(), "Money");
        incrSponAmt();
        TextManagementGame.addGenerator(newSpon);
    }
    //weekly amount of money
    public static int getSponIncome(){
        int sponIncome = 0;
        for(Generator sponsor : TextManagementGame.generators){
            if(sponsor instanceof Sponsorship){
               sponIncome += ((Generator)sponsor).getResourceProductionRate();     
            }  
        }
        return sponIncome;
    }
    @Override
    public String toString(){
        return "Name: "+this.getName() + ", Production Rate: $"+this.getResourceProductionRate() + " million, Cost: $" +this.getConstructionCost() + " million, Total Prod: " + this.numberConstructed + ", Produces: Money";
    }
    //score found by money produced each week
    @Override
    public int scoreImpact() {
        for (Generator g : TextManagementGame.generators){
            if (g instanceof Sponsorship){
           score += g.getResourceProductionRate();
            }
        }
        return this.score;
    }
}
