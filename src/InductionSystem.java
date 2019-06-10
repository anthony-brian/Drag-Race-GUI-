public class InductionSystem {
   private int horsepowerGain ;
   private String name ;
   private int cost ;

    /**
     * Constructor for objects of class InductionSystem
     * @param name the name of the induction system
     * @param horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     */
    public InductionSystem(String name, int horsepowerGain) {
        this.horsepowerGain = horsepowerGain ;
        this.name = name ;
    }
    
    /**
     * @param horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     * @param name the name of the induction system
     * @param cost the price of installing the InductionSystem
     */
    public InductionSystem(String name, int horsepowerGain, int cost) {
        this.horsepowerGain = horsepowerGain ;
        this.name = name ;
        this.cost = cost ;
    }
    
    /**
     * No argument constructor for InductionSystem objects. Sets horsepowerGain and cost to 0, and name to "natural aspiration"
     */
    public InductionSystem() {
        horsepowerGain = 0 ;
        cost = 0 ;
        name = "natural aspiration" ;
    }
    
    /**
     * getter method for the cost of InductionSystem
     * @return cost the price of installing the InductionSystem
     */
    public int getCost () {
        return cost ;
    }
    
    /**
     * @return horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     */
    public int getHorsepowerGain() {
        return horsepowerGain ;
    }
    
    /**
     * getter for the name of InductionSystem
     * @return name the name of the induction system
     */
    public String getName() {
        return name ;
    }
    
    /**
     * setter method for horsepowerGain
     * @param horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     */
    public void setHorsepowerGain() {
        this.horsepowerGain = horsepowerGain ;
    }
    
    /**
     * setter method for name of the name of the induction system
     * @param name the name of the induction system
     */
    public void setName(String name) {
        this.name = name ;
    }
    
    /**
     * setter method for cost of the InductionSystem
     * @param cost the price of installing the InductionSystem
     */
    public void setCost(int cost) {
        this.cost = cost ;
    }
    
    /**
     * toString method for InductionSystem objects
     */
    public String toString() {
        return horsepowerGain + " HP " + name ;
    }
}
