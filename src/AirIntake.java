public class AirIntake {
    private String name ;
    private int horsepowerGain ;
    private int cost ;
    
    /**
     * Constructor for objects of class AirIntake with name and horsepowerGain
     * @param name the name of the AirIntake
     * @param horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     */
    public AirIntake(String name, int horsepowerGain) {
        this.horsepowerGain = horsepowerGain ;
        this.name = name ;
    }
    
    /**
     * Constructor for objects of class AirIntake  with name, cost and horspowerGain variables
     * @param name the name of the AirIntake
     * @param horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     * @param cost the price of the AirIntake
     */
    public AirIntake(String name, int horsepowerGain, int cost) {
        this.horsepowerGain = horsepowerGain ;
        this.name = name ;
        this.cost = cost ;
    }
    
    /**
     * No argument constructor for objects of the AirIntake class. Sets name to "stock", and horsepowerGain and cost to 0
     */
    public AirIntake() {
        name = "stock" ;
        horsepowerGain = 0 ;
        cost = 0 ;
    }
    
    /**
     * setter method for horsepowerGain of intake
     * @param horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     */
    public void setHorsepowerGain(int horsepowerGain) {
        this.horsepowerGain = horsepowerGain ;
    }
    
    /**
     * getter method for cost of intake
     * @return cost the price of the AirIntake
     */
    public int getCost() {
        return cost ;
    }
    
    /**
     * getter method for horsepowerGain of intake
     * @return horsePowerGain how much the AirIntake will increase a ModifiedCar's horsepower
     */
    public int getHorsepowerGain() {
        return horsepowerGain ;
    }
    
    /**
     * setter method for name of intake
     * @param name the name of the AirIntake
     */
    public void setName(String name) {
        this.name = name ;
    }
    
    /**
     * getter method for name of intake
     * @return name the name of the AirIntake
     */
    public String getName() {
        return name ;
    }
    
    /**
     * setter method for horsepowerGain of intake
     * @param cost the price of the AirIntake
     */
    public void setCost(int cost) {
        this.cost = cost ;
    }
    
    /**
     * toString method for AirIntake objects "name - horsepowerGain" EX: "Injen - 40 HP"
     */
    public String toString() {
        return String.format("%-8s - %2d HP", name, horsepowerGain);
    }
}
