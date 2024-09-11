public class DriverXp extends Resource{
    protected static int driLvl = 0;
    protected int score;
    protected static int nextLvl = 2;
    protected static int lvl2xP = 100;
    protected static int lvl3xP = 250;
    protected static int lvl4xP = 400;
    protected static int lvl5xP = 800;
    protected static int lvl6xP = 1100;
    protected static int lvl7xP = 1500;
    protected static int lvl8xP = 2000;
    protected static int lvl9xP = 2400;
    protected static int lvl10xP = 3000;
    protected static boolean upAva;
    DriverXp(String driverName, int xpPoints, boolean driIsCritical, int dri){
        super(driverName, xpPoints, driIsCritical);
        this.driLvl = dri;
    }
    public static void startDriver(){
        DriverXp dri1 = new DriverXp("Lewis Hamilton", 1, false, 1);
        TextManagementGame.addResource(dri1);
    } 
    public static int getDriLvl(){
        return driLvl;
    }
    public static int getDriXp(){
        return TextManagementGame.resources.get(4).getQuantity();
    }
    public static int getNextLvl(){
        return nextLvl;
    }
    public static void nextLvl(){
        nextLvl++;
    }
    public static boolean hasUpAva(){
        if (nextLvl == 2){
            if (getDriXp() >= lvl2xP){
            System.out.println("Upgrade to Level 2 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 3){
            if (getDriXp() >= lvl3xP){
            System.out.println("Upgrade to Level 3 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 4){
            if (getDriXp() >= lvl4xP){
            System.out.println("Upgrade to Level 4 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 5){
            if (getDriXp() >= lvl5xP){
            System.out.println("Upgrade to Level 5 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 6){
            if (getDriXp() >= lvl6xP){
            System.out.println("Upgrade to Level 6 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 7){
            if (getDriXp() >= lvl7xP){
            System.out.println("Upgrade to Level 7 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 8){
            if (getDriXp() >= lvl8xP){
            System.out.println("Upgrade to Level 8 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 9){
            if (getDriXp() >= lvl9xP){
            System.out.println("Upgrade to Level 9 available");
            upAva = true;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        if (nextLvl == 10){
            if (getDriXp() >= lvl10xP){
            System.out.println("Upgrade to Level 10 available");
            upAva = true;
        }
        if (nextLvl > 10){
            System.out.println("You have reached max level");
            upAva = false;
        }
            else {
            System.out.println("Not enough xP to upgrade");
            upAva = false;
        }
    }
        return upAva;
    }
    public static void upDriLvl(boolean enoughXp){
        if (enoughXp == true){
            DriverXp.driLvl++;
            nextLvl++;
            System.out.println("Hamilton's level is now " + driLvl);
        }
    }
    @Override
    public String toString(){
        return "Driver: " +this.getName() + ", Level: "+driLvl + ", Total Xp: "+this.getQuantity();
    }
    @Override
    public int scoreImpact() {
         if (driLvl > 1){
            score = driLvl * 10;
        }
            return this.score;
    }
}
