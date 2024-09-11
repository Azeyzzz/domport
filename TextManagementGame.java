import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * The TextManagementGame class represents a text-based management game where the player manages resources and resource generators.
 */
public class TextManagementGame {
    // Define game variables
    protected static int round;
    protected static ArrayList<Resource> resources = new ArrayList<Resource>();
    protected static ArrayList<Generator> generators = new ArrayList<Generator>();
    protected int mainScore;
    Event raceScore =  new Event("Score");
    Money resScore = new Money(null, 0, false);
    UpgradePoints upScore = new UpgradePoints(null, 0, isCriticalResourceEmpty(), UpgradePoints.getPerf());
    DriverXp driScore = new DriverXp(null, 0, isCriticalResourceEmpty(), DriverXp.getDriLvl());
    Sponsorship sponScore = new Sponsorship(null, mainScore, round, mainScore, null);
    Simulator simScore = new Simulator(null, mainScore, round, mainScore, null);
    Research researchScore = new Research(null, mainScore, round, mainScore, null);
    public static int getRound(){
        return round;
    }
    // Define a Scanner for user input
    private Scanner scanner;

    /**
     * Creates a new TextManagementGame instance with initial resource and time values.
     * TODO : Add starting resources
     */
    public TextManagementGame() {
        round = 1;       // Start at time 1
        scanner = new Scanner(System.in);
    }
    
    /**
     * Check if a method should run with a 1 in number chance.
     *
     * @return true if the method should run, false otherwise
     */
    public boolean haveEventThisTurn(int number) {
        Random random = new Random();
        int chance = random.nextInt(number); // Generates a random number between 0 (inclusive) and number (exclusive)
        return chance == 0; // Returns true with a 1 in number chance
    }
    public static Resource getMoney(){
        return resources.get(1);
    }
    /**
    * Prints the list of resources
    */
    public void viewResources(){
        for(Resource r : resources){
            System.out.println(r);
        }
    }

    /**
    * Prints the list of Generators
    */
    public void viewGenerators(){
       Collections.sort(generators, new SortGen());
        System.out.println("Generators: ");
        System.out.println("\n Sponsorships:");
        for(Generator b : generators){
            if (b instanceof Sponsorship){
            System.out.println(b);
            }
        }
        System.out.println("\n Simulators:");
        for(Generator b : generators){
            if (b instanceof Simulator){
            System.out.println(b);
            }
        }
        System.out.println("\n Research:");
        for(Generator b : generators){
            if (b instanceof Research){
            System.out.println(b);
            }
        }
    }

    /**
     * Checks if a Generator can be constructed and then adds it to the list of Generators
     * TODO : ADD LOGIC
     */
    public void constructGenerator(){
        
    }

    /** 
     * Increments the time counter and then adds more resources based on what generators are present
     * TODO : Add calculations to generate resources for the next turn
     */
    public void endRound(){
        round++;
    }

    /**
     * Adds a Generator object to the ArrayList of Generators.
     *
     * @param Generator the Generator object to add
     */
    
    public static void addGenerator(Generator generator) {
        generators.add(generator);
    }

    /**
     * Adds a Resource object to the ArrayList of resources.
     *
     * @param resource the Resource object to add
     */
    public static void addResource(Resource resource) {
        resources.add(resource);
    }
     
   public static void buyGenerator(int genType, int buyLvl){

        int buyCost = 0;
        if (genType == 1){
        buyCost = Sponsorship.sponPrice * buyLvl;
         if(resources.get(0).getQuantity() < buyCost){
         System.out.println("Not enough money");
         }
         else {
            resources.get(0).consume(buyCost);
            Sponsorship.addNewSponsorship(buyLvl);
            System.out.println("You bought a level " + buyLvl + " Sponsorship for $" + buyCost + " million");
            System.out.println("Remaining money: $" + resources.get(0).getQuantity() + " million");
        }
    }
         if (genType == 2){
        buyCost = Research.resPrice * buyLvl;
         if(resources.get(0).getQuantity() < buyCost){
         System.out.println("Not enough money");
         }
         else {
            resources.get(0).consume(buyCost);
            Research.addNewResearch(buyLvl);
            System.out.println("You bought a level " + buyLvl + " Research for $" + buyCost + " million");
            System.out.println("Remaining money: $" + resources.get(0).getQuantity() + " million");
        }
    }
         if (genType == 3){
        buyCost = Simulator.simPrice * buyLvl;
         if(resources.get(0).getQuantity() < buyCost){
         System.out.println("Not enough money");
         }
         else {
            resources.get(0).consume(buyCost);
            Simulator.addNewSimulator(buyLvl);
            System.out.println("You bought a level " + buyLvl + " Simulator for $" + buyCost + " million");
            System.out.println("Remaining money: $" + resources.get(0).getQuantity() + " million");
        }
    }
    }
     public static void carUpgrade(int upChoice , int upAmt){
        if (upAmt > resources.get(1).getQuantity()){
            System.out.println("Not enough upgrade points");
        }
        else {
            resources.get(1).consume(upAmt);
            if (upChoice == 1){
                resources.get(2).addToAeroRating(upAmt * 25);
                System.out.println("Aero Rating now at " + Aero.getARating());
            }
            if (upChoice == 2){
                resources.get(3).addEngRating(upAmt * 25);
                System.out.println("Engine Rating now at " + Engine.getERating());
            }
        }
     }

    /**
     * Checks if we are out of any critical resources
     *
     * @return returns true if we are out of any critical resources returns false otherwise
    */
    public boolean isCriticalResourceEmpty(){
        for(Resource r : resources){
            if(r.isCritical() && r.getQuantity() == 0){
                return true;
            }
        }
        return false;
    }
    public static void setUpClasses(){
        Money.startMoney();
        UpgradePoints.startUpgr();
        DriverXp.startDriver();
        Sponsorship.startSponsorship();
        Research.startResearch();
        Simulator.startSimulator();
        
    }
    class SortGen implements Comparator<Generator>{
        @Override
        public int compare(Generator a, Generator b){
            return a.getResourceProductionRate() - b.getResourceProductionRate(); 
        }
    }
    public static void weeklyTotal(){
            resources.get(0).add(Sponsorship.getSponIncome());
            resources.get(1).add(Research.getResIncome());
            resources.get(4).add(Simulator.getSimIncome());
    }
    public int getTotalScore(){
        return mainScore;
    }
    public int addToScore(){
        mainScore = raceScore.scoreImpact();
        mainScore += resScore.scoreImpact();
        mainScore += upScore.scoreImpact();
        mainScore += driScore.scoreImpact();
        mainScore += sponScore.scoreImpact();
        mainScore += simScore.scoreImpact();
        mainScore += researchScore.scoreImpact();
        return mainScore;
    }
    public void tutorial(){
        boolean noTutor = false;
        System.out.println("Welcome to the Formula 1 Management Game!");
        while(noTutor == false){
            System.out.println("Would you like a tutorial? (y/n)");
            String tutorChoice = scanner.next();
            if (tutorChoice.equals("y")){
                System.out.println("The goal of the game is build generators and upgrade your car and driver.");
                System.out.println("The higher your car performance and driver level is the better you do in the races. There is 10 races every other week. Your position at the end of a race is based off driver level + performance rating.");
                System.out.println("In order to increase your chances of higher positions you must raise your driver level and performance.");
                System.out.println("Type anything to start");
                String start = scanner.next();
                System.out.println("Starting game...");
                noTutor = true;
                break;
            }
            if (tutorChoice.equals("n")){
                System.out.println("Starting game...");
                noTutor = true;
                    break;
            }
        }
    }
    /**
     * Starts the game and manages the game loop.
     */
    public void start() {
        // Main game loop
        while (!isCriticalResourceEmpty() && round <= 20) {
            System.out.println("\nWeek " + round);
            System.out.println("Score: " + getTotalScore());
            System.out.print("Weekend: ");
            Schedule.isEven(round);
            Schedule.isRaceWeekend();
            System.out.println("Resources: ");
            System.out.print("\t |" + resources.get(0).getName() + ": " + resources.get(0).getQuantity() + " million|");
            System.out.print(resources.get(1).getName() + ": " + resources.get(1).getQuantity() + "|");
            System.out.println(resources.get(4).getName() + ": lvl: " + DriverXp.driLvl + "|");
            System.out.println("Weekly Income: ");
            System.out.print("\t |" + "$" + Sponsorship.getSponIncome() + " million|");
            System.out.print(Research.getResIncome() + " points|");
            System.out.println(Simulator.getSimIncome() + " xp|");
            System.out.println("Options:");
            System.out.println("1. View resources");
            System.out.println("2. View generators");
            System.out.println("3. Buy a new Generator");
            System.out.println("4. Upgrade car");
            System.out.println("5. Upgrade Driver");
            if (Schedule.raceWeekend == true){
                System.out.println("6. Start race and end week");
            }
            else{
                System.out.println("6. End week");
            }
            System.out.println("7. Quit game");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewResources();
                    break;
                case 2:
                    viewGenerators();
                    break;
                case 3: 
                    System.out.println("Choose which generator to buy (1-3)");
                    System.out.println("Current Balance: $" + resources.get(0).getQuantity() + " million");
                    System.out.println("1. Sponsorship:" + "\t $" + Sponsorship.getSponPrice() + " million per level");
                    System.out.println("2. Research:" + "\t $" + Research.getResPrice() + " million per level");
                    System.out.println("3. Simulator:" + "\t $" + Simulator.getSimPrice() + " million per level");
                    System.out.println("4. Go Back");
                    int buy = scanner.nextInt();
                    if (buy == 4){
                        break;
                    }
                    else{
                    System.out.println("What level?");
                    int buylvl = scanner.nextInt();
                    buyGenerator(buy, buylvl);
                    break;
                    }
                case 4:
                    System.out.println("What would you like to upgrade? ");
                    System.out.println("1. " + resources.get(2).getName() + ": " + Aero.getARating() + " rating");
                    System.out.println("2. " + resources.get(3).getName() + ": " + Engine.getERating() + " rating");
                    System.out.println("You have " + resources.get(1).getQuantity() + " points");
                    int upType = scanner.nextInt();
                    if (upType == 1 || upType == 2){
                    System.out.println("How many upgrade points would you like to spend (Each point counts towards 25 performance)");
                    int upSpend = scanner.nextInt();
                    TextManagementGame.carUpgrade(upType, upSpend);
                }
                    else{
                        System.out.println("Please enter 1 or 2");
                    }
                    break;
                case 5:
                    System.out.println(resources.get(4).getName() + " Level: " + DriverXp.getDriLvl());
                    System.out.println("You have " + resources.get(4).getQuantity() + " xP");
                    if (DriverXp.hasUpAva() == true){
                        System.out.println("Would you like to upgrade? (y/n)");
                        String driChoice = scanner.next();
                        if (driChoice.equals("y")){
                            DriverXp.upDriLvl(true);
                        }
                        else {
                            System.out.println("Returning to menu");
                            break;
                        }
                    }

                break;
                case 6:
                    if (Schedule.raceWeekend == true){
                    raceScore.addScore(Race.raceSim(Schedule.raceName));
                    endRound();
                    weeklyTotal();
                    
                }
                    else{
                    endRound();
                    weeklyTotal();
                }
                addToScore();
                break;
                case 7:
                    System.exit(0);
                    break;
                    default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Game Over!");
        System.out.println("You played for " + round + " rounds");
        System.out.println("Your final score was: " + mainScore);
    }
    
    /**
     * Main method to run the game
     *
     * @param args the command-line arguments (not used in this game)
     */
    public static void main(String[] args) {
        setUpClasses();
        TextManagementGame game = new TextManagementGame();
        game.tutorial();
        game.start();
        
    }
}