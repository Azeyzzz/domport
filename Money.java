public class Money extends Resource {
    protected int score;
    protected int pastScore = 6;
    Money(String mName, int moneyTotal, boolean mIsCrit){
        super(mName, moneyTotal, mIsCrit);
    }
    
    public static void startMoney(){
    Money startAmount = new Money("Money", 6, true);
    TextManagementGame.addResource(startAmount);
    }
    public static Resource monDisplay(){
        return TextManagementGame.resources.get(0);
    }
    public static int moneyTotal(){
        return TextManagementGame.resources.get(0).getQuantity();
    }
    @Override
    public String toString(){
        return "Resource: "+this.getName() + ", Amount: " + this.getQuantity() + " million" + ", Is Critical? " + this.isCritical();
    }

    @Override
    public int scoreImpact() {
       if (moneyTotal() > pastScore){
        score += moneyTotal() - pastScore;
       }
       pastScore = this.score;
        return this.score;
    } 

}
