import java.util.*;
public class Schedule {
    protected static String raceName;
    protected static boolean raceWeekend = false;
    protected static ArrayList<String> raceList = new ArrayList<String>();
    
    
    public boolean getIsRaceWeekend(){
        return raceWeekend;
    }
    public static void isEven(int weekNum){
        if(weekNum % 2 == 0){
            raceWeekend = true;
        }
        else if(weekNum % 2 == 1){
            raceWeekend = false;
        }
    }
   public static void isRaceWeekend(){
    if(raceWeekend == true){
        System.out.println("Race week");
        if (TextManagementGame.getRound() == 2){
            raceName = "Jeddah, Saudia Arabia";
        }
        if (TextManagementGame.getRound() == 4){
            raceName = "Melbourne, Australia";
        }
        if (TextManagementGame.getRound() == 6){
            raceName = "Miami";
        }
        if (TextManagementGame.getRound() == 8){
            raceName = "Monaco";
        }
        if (TextManagementGame.getRound() == 10){
            raceName = "Barelona, Spain";
        }
        if (TextManagementGame.getRound() == 12){
            raceName = "Budapest, Hungary";
        }
        if (TextManagementGame.getRound() == 14){
            raceName = "Singapore";
        }
        if (TextManagementGame.getRound() == 16){
            raceName = "Mexico City, Mexico";
        }
        if (TextManagementGame.getRound() == 18){
            raceName = "Sao Paulo, Brazil";
        }
        if (TextManagementGame.getRound() == 20){
            raceName = "Yas Marina, Abu Dhabi";
        }
        System.out.println("Race: "+raceName);
        System.out.println("Performance: " + UpgradePoints.getPerf()+ " rating");
        
    }
    else {
        System.out.println("No race");
    }
   }
}
