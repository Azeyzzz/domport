
public class UpgradePoints extends Resource {
    protected static int perf = 0;
    protected static int upTotal = 0;
    protected int score;
    UpgradePoints(String uName, int uTotal, boolean uIsCrit, int perf){
        super(uName, uTotal, uIsCrit);
        this.perf = perf;
        upTotal = uTotal;
    }
    public static int getUpTotal() {
        return upTotal;
    }
    public static void startUpgr(){
    Aero startAero = new Aero("Aero", getUpTotal(), false, perf, 50);
    Engine startEngine = new Engine("Engine", getUpTotal(), false, perf, 50);
    UpgradePoints startUp = new UpgradePoints("Upgrade Points", 5, false, addToPerf());
    TextManagementGame.addResource(startUp);
    TextManagementGame.addResource(startAero);
    TextManagementGame.addResource(startEngine);
    }
    public static int getPerf(){
        return perf;
    }
    public static int addToPerf(){
        perf = Aero.getARating() + Engine.getERating();
        return perf;
    }
    @Override
    public String toString(){
        return "Resource: "+this.getName() + ", Performance Lvl: " + perf + ", Amount: " + this.getQuantity() + " points" + ", Is Critical? " + this.isCritical() ;
}
//score if found by the amount performance has been changed from the starting perf.
    @Override
    public int scoreImpact() {
        // TODO Auto-generated method stub
        if (perf > 50){
            score = perf - 50;
            score = score/5;
        }
        return this.score;
    }
}
class Aero extends UpgradePoints{
    protected static int aRating;
    Aero(String aName, int aTotal, boolean aIsCrit, int aPerf, int aRating){
        super(aName, aTotal, aIsCrit, aPerf);
        this.aRating = aRating;
    }
    public static int getARating(){
            return aRating;
        }
        public String toString(){
            return "\tUpgrade Point: "+this.getName() + ": " + aRating + " rating";
        }
    }

class Engine extends UpgradePoints{
    protected static int eRating;
    Engine(String eName, int eTotal, boolean eIsCrit, int ePerf, int eRating){
        super(eName, eTotal, eIsCrit, ePerf);
        this.eRating = eRating;
    }
    public static int getERating(){
        return eRating;
    }
        public String toString(){
            return "\tUpgrade Point: "+this.getName() + ": " + eRating + " rating";
        }

}
