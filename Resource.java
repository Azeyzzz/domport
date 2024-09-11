/**
 * The Resource class represents a generic resource in the game.
 * Resources have a name, a quantity, and a status of critical or not critical.
 */
public abstract class Resource implements Score {
    protected String name;
    protected int quantity;
    protected boolean isCritical;
    
    /**
     * Creates a new Resource with the given name and initializes the quantity to 0.
     *
     * @param name the name of the resource
     */
    public Resource(String name, int quantity, boolean isCritical) {
        this.name = name;
        this.quantity = quantity;
        this.isCritical = isCritical;
    }

    /**
     * Gets the name of the resource.
     *
     * @return the name of the resource
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gets the quantity of the resource.
     *
     * @return the quantity of the resource
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Reports if a resource is critical. If a rsource is critical, reaching 0 ends the game.
     *
     * @return if the resource is critical
     */
    public boolean isCritical(){
        return isCritical;
    }

    /**
     * Sets if a given resource is critical.
     * 
     * @param boolean value for isCritical
     */
    public void setIsCrticial(boolean isCritical){
        this.isCritical = isCritical;
    }

    /**
     * Adds the specified amount to the quantity of the resource.
     *
     * @param amount the amount to add
     */
    public void add(int amount) {
        quantity += amount;
    }
    public void addUpPoints(int amt){
        UpgradePoints.upTotal += amt;
    }
    public void addToAeroRating(int upgrade){
        Aero.aRating += upgrade;
        UpgradePoints.addToPerf();
    }
    public void addEngRating(int upgrade){
        Engine.eRating += upgrade;
        UpgradePoints.addToPerf();
    }
    /**
     * Consumes the specified amount of the resource if available. Sets the resource to 0 if there is not enough to consume.
     *
     * @param amount the amount to consume
     */
    public void consume(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            quantity = 0;
            System.out.println("Not enough " + name + " to consume.");
        }
    }
    
}