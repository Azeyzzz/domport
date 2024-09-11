import java.util.*;
public class Research extends Generator {
    protected int resLevel;
    protected static int resPrice = 4;
    protected static int totalResAmt;
    private static int resRate = 1;
    protected int score;
    Research(String resName, int resCost, int rate, int resNum, String resProd){
        super(resName, resCost, rate, resNum, resProd);
        totalResAmt = resNum;
    }
    public static int getResPrice(){
        return resPrice;
    }
    public static int getTotalRes(){
        return totalResAmt;
    }
    public static int getResRate(){
        return resRate;
    }
    public static int incrResAmt(){
        totalResAmt++;
        return totalResAmt;
    }
    public static void startResearch(){
        Research firstRes = new Research("Research: Lvl 1", resPrice, resRate, 1, "Upgrade points");
        incrResAmt();
        TextManagementGame.addGenerator(firstRes);
    }
    public static void addNewResearch(int lvl){
        Research newRes = new Research("Research: " + "Lvl: " + lvl, resPrice * lvl, resRate * lvl, getTotalRes(), "Upgrade points");
        incrResAmt();
        TextManagementGame.addGenerator(newRes);
    }
    public static int getResIncome(){
        int resIncome = 0;
        for(Generator research : TextManagementGame.generators){
            if(research instanceof Research){
               resIncome += ((Generator)research).getResourceProductionRate();     
            }  
        }
        return resIncome;
    }
    @Override
    public String toString(){
        return "Name: "+this.getName() + ", Production Rate: "+this.getResourceProductionRate() + " upgrade points, Cost: $" +this.getConstructionCost() + " million, Total Prod: " + this.numberConstructed + ", Produces: Upgrade points";
    }
    @Override
    public int scoreImpact() {
        for (Generator g : TextManagementGame.generators){
            if(g instanceof Research){
                score += g.getResourceProductionRate();
            }
        }
        return this.score;
    }
}