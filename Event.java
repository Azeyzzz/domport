import java.util.*;
/**
 * The Event class represents a generic randomly occuring event in the game.
 * Events have a name
 */
public class Event implements Score{
    private String name;

    /**
     * Creates a new Event with the given name
     *
     * @param name the name of the event
     */
    public Event(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the event.
     *
     * @return the name of the event
     */
    public String getName() {
        return name;
    }
    protected int score;
        @Override
        public int scoreImpact() {
            return this.score;
            
        }
        public void addScore(int s) {
            if (s == 10){
                this.score += 10;
            }
            if (s == 9){
                this.score += 20;
            }
            if (s == 8){
                this.score += 30;
            }
            if (s == 7){
                score += 40;
            }
            if (s == 6){
                score += 50;
            }
            if (s == 5){
                score += 60;
            }
            if (s == 4){
                score += 70;
            }
            if (s == 3){
                score += 90;
            }
            if (s == 2){
                score += 110;
            }
            if (s == 1){
                score = score + 150;
            }
        }
    
}