public class WeightReduction {
    private int weight ;
    private int cost ;

    /**
     * Constructor for objects of class WeightReduction that only have a weight. 
     * @param weight the amount of weight that is reduced from the ModifiedCar upon "installation"
     */
    public WeightReduction(int weight) {
        this.weight = weight ;
        cost = 0 ;
    }
    
    /**
     * Constructor for objects of the WeightReduction class
     * @param weight the amount of weight that is reduced from the ModifiedCar upon "installation"
     */
    public WeightReduction(int weight, int cost) {
        this.weight = weight ;
        this.cost = cost ;
    }
    
    /**
     * No argument constructor. Sets cost and weight to 0.
     */
    public WeightReduction() {
        weight = 0 ;
        cost = 0 ;
    }
    
    /**
     * getter method for weight
     * @return weight - the amount of weight that is reduced from the ModifiedCar upon "installation"
     */
    public int getWeight() {
        return weight ;
    }
    
    /**
     * getter method for cost
     * @return cost - the price of the AirIntake
     */
    public int getCost() {
        return cost ;
    }
    
    /**
     * setter method for weight
     * @param weight the amount of weight that is reduced from the ModifiedCar upon "installation"
     */
    public void setWeight(int weight) {
        this.weight = weight ;
    }
    
    /**
     * setter method for cost
     * @param cost - the price of the AirIntake
     */
    public void setCost(int cost) {
        this.cost = cost ;
    }
    
    /**
     * toString() method for WeightReduction objects. Prints "Weight Reduction: <code>weight</code> lbs"
     */
    public String toString() {
        return "Weight reduction: " + weight  + " lbs.";
    }
}
