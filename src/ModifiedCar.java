import java.util.Scanner ;
import java.util.InputMismatchException ;
/**
 * <h2> ModifiedCar - a child class of the Car class, ModifiedCars can have upgrades such as AirIntake, InductionSystem and WeightReduction </h2>
 */
public class ModifiedCar extends Car {
    private AirIntake airIntake ;
    private InductionSystem inductionSystem ;
    private WeightReduction weightReduction ;
    private int cost ;
    private int coins = 14000;
    
    /**
     * Constructor for objects of class ModifiedCar
     * @param year the year of production of the ModifiedVehicle
     * @param make the manufacturer of the ModifiedVehicle
     * @param model the model of the ModifiedVehicle
     * @param horsepower horsepower of the ModifiedVehicle
     * @param airIntake the custom airIntake installed on the ModifiedVehicle
     * @param inductionSystem the custom induction system (i.e turbo, supercharger) installed on the MOdifiedCar
     * @param weightReduction the custom weightReduction of the car
     */
    public ModifiedCar(int year, String make, String model, int horsepower, int curbWeight, AirIntake airIntake, InductionSystem inductionSystem,
                        WeightReduction weightReduction) {
       super(year, make, model, horsepower, curbWeight) ;
       this.airIntake = airIntake ;
       this.inductionSystem = inductionSystem ;
       this.weightReduction = weightReduction ;
       
       installIntake() ;
       installInductionSystem() ;
       reduceWeight() ;
    }
    
    /**
     * Constructor for objects of class ModifiedCar
     * @param year the year of production of the ModifiedVehicle
     * @param make the manufacturer of the ModifiedVehicle
     * @param model the model of the ModifiedVehicle
     * @param horsepower horsepower of the ModifiedVehicle
     * @cost the cost of the vehicle
     */
    public ModifiedCar(int year, String make, String model, int horsepower, int curbWeight, int cost) {
        super(year, make, model, horsepower, curbWeight) ;
        airIntake = new AirIntake() ;
        inductionSystem = new InductionSystem() ;
        weightReduction = new WeightReduction() ;
        this.cost = cost ;
    }
    
    /**
     * No argument Constructor for objects of the ModifiedCar class.  
     */
    public ModifiedCar() {
       super() ;
       airIntake = null ;
       inductionSystem = null ; 
       weightReduction = null ;
    } 
    
    // Getters ---------------------------------------------------------------------------------------------------------------------
    
    /**
     * getter for coins
     * @return coins variable
     */
    public int getCoins() {
        return coins ;
    }
    
    /**
     * getter for cost
     * @return the cost of the ModifiedVehicle
     */
    public int getCost() {
        return cost ;
    }
    
    /**
     * getter for the ModifiedCar's AirIntake variable
     */
    public AirIntake getAirIntake() {
        return airIntake ;
    }
    
    /**
     * getter for the ModifiedCar's InductionSystem variable 
     */
    public InductionSystem getInductionSystem() {
        return inductionSystem ;
    }
    
    /**
     * getter for the ModifiedCar's WeightReduction variable
     */
    public WeightReduction getWeightReduction() {
        return weightReduction ;
    }
    
    // Setters ---------------------------------------------------------------------------------------------------------------------
    
    /**
     * setter for how many coins the user has
     * @param coins the new amount of coins user has
     */
    public void setCoins(int coins) {
        this.coins = coins ;
    }
    
    /**
     * setter for AirIntake variable on a ModifiedCar
     * @param airIntake the new air intake to be installed on the ModifiedCar
     */
    public void setAirIntake(AirIntake airIntake) {
        removeIntake() ;
        this.airIntake = airIntake ;
        installIntake() ;
    }
    
    /**
     * setter for inductionSystem variable on a ModifiedCar
     * @param inductionSystem the new inductionSystem to be installed on the ModifiedCar
     */
    public void setInductionSystem(InductionSystem inductionSystem) {
        removeInductionSystem() ;
        this.inductionSystem = inductionSystem ;
        installInductionSystem() ;
    }
    
    /**
     * setter for weightReduction variable on a ModifiedCar
     * @param weightReduction the new weightReduction to give the ModifiedCar
     */
    public void setWeightReduction(WeightReduction weightReduction) {
        this.weightReduction = weightReduction ;
        reduceWeight() ;
    }
    
    /**
     * setter for cost variable
     * @param cost the new cost
     */
    public void setCost(int cost) {
        this.cost = cost ;
    }
    
    // Methods -----------------------------------------------------------------------------------------------------------------
    
    /**
     * removes intake upgrade from a ModifiedCar by subtracting the horsepwer gain of the intake by the ModifiedCar's horspower
     */
    public void removeIntake() {
        if (getAirIntake() != null) {
            setHorsepower(getHorsepower() - airIntake.getHorsepowerGain()) ;
        }
    }
    
    /**
     * removes inductionSystem by subtracting the horsepwer gain of the induction system by the ModifiedCar's horspower
     */
    public void removeInductionSystem() {
        if (getInductionSystem() != null) {
            setHorsepower(getHorsepower() - inductionSystem.getHorsepowerGain()) ;
        }
    }
    
    /**
     * "Installs" and intake system on a ModifiedCar by adding the horsepower gain of the intake to the ModifiedCar's horsepower
     */
    public void installIntake() {
        setHorsepower(getHorsepower() + airIntake.getHorsepowerGain()) ;
    }
    
    /**
     * "installs" an induction system on a ModifiedCar by increasing the object's horsepower by the horsepower gain of the induction system
     */
    public void installInductionSystem() {
        setHorsepower(getHorsepower() + inductionSystem.getHorsepowerGain()) ;
    }
    
    /**
     * Reduces weight for the car when setWeight() is called by upgrade() method
     */
    public void reduceWeight() {
        setWeight(getWeight() - weightReduction.getWeight()) ;
    }
    
    /**
     * Allows the user to upgrade their vehicle's Air Intake, Induction System, or Reduce the car's weight. Calling the method enters a menu
     * for choosing what to upgrade on the ModifiedCar
     */
    public void upgrade() {
        Scanner keyboard = new Scanner(System.in) ;
       
        System.out.println("\nWhat would you like to upgrade?") ;       // Prompt the user to enter what upgrade they want
        System.out.println("1. Air Intake") ;                           // If user enters 1: upgrade air intake
        System.out.println("2. Forced Induction") ;                     // If user enters 2: upgrade induction system
        System.out.println("3. Weight Reduction") ;                     // If user enters 3: upgrade weight reduction
        
        int upgrade = 0 ;               // upgrade will store 1,2, or 3, depending on what upgrade the user wants to do
        
        // Try block for getting upgrade input from the user, and checking for InputMismatchException
        try {
            boolean done = false ;          // done is the boolean case, when its true it will exit input loop and input is valid
            while (!done) {
                upgrade = keyboard.nextInt() ;          
                if (upgrade > 0 && upgrade <= 3) {
                    done = true ;                       // If user input is 1 2 or 3 then exit the loop
                }
                else {
                    System.out.println("Invalid number. Enter 1,2 or 3.") ;     // If input is an int not between 1-3, print this
                }
            }
        }
        catch (InputMismatchException e) {
           System.out.println("Invalid entry. Enter 1, 2 or 3 only.") ;     // If the input was not of type int, catch InputMismatchException
        }
            
        // The multi-way if statement that will guide the user through the upgrade they chose through keyboard input
        // If user enters 1: then lead the user through upgrading air intake by showing the airIntakeDatabase
        if (upgrade == 1) {
            System.out.println("\nAir intakes:") ;          
            System.out.println("--------------") ;
            AirIntakeDatabase intakes = new AirIntakeDatabase() ;       // create a new AirIntakeDatabase object
            intakes.showIntakeDatabase() ;                              // print the database to console with showIntakeDatabase()
            System.out.print("Choose an intake by entering its number (enter 0 to exit): ") ;   //Prompt user to enter index of desired intake
            
            int userInput = 0 ;             // will store the intake index that the user enters
            boolean valid = false ;         // valid will be the boolean case for validating proper user input
            
            // While valid is false, it will prompt the user to enter a air intake 
            while (!valid) {
                // try-block for catching InputMismatchException
                try {
                    int next = keyboard.nextInt() ;     // user input
                    // if the user enters an int between 1-7, then valid will become true, loop will be exited
                    if (next >= 1 && next <= AirIntakeDatabase.size) {
                        userInput = next ;
                        valid = true ;
                    }
                    else if (next == 0) {
                        return ;            // if user enters 0, exits the upgrade menu
                    }
                    else {
                        System.out.println("Enter a number 1-7, Or \"0\" to exit upgrade menu.") ; // if user enters an invalid int
                    }
                }
                catch (InputMismatchException e) {
                    System.out.print("Invalid input. Enter a whole number only.") ;     // if user does not enter an int
                    keyboard.next() ;   
                }
            }
            
            AirIntake userIntake = intakes.getIntake(userInput - 1) ;        // set userIntake to the intake the user chose from the list
            
            // Try-block to attempt to install userIntake to the user's car, InsufficientFundsException will be thrown if the user does not
            // have enough coins to buy the intake 
            try {
                if (userIntake.getCost() > coins) {
                    // If cost of intake is greater than the amount of coins the user has, then throw insufficient funds exception
                    throw new InsufficientFundsException("You do not have enough coins. Intake not installed.") ;
                }
                coins -= userIntake.getCost() ;         // subtract the cost of the air intake from the user's coins
                setAirIntake(userIntake) ;              // install the new intake onto the user's car
                System.out.println("\n** " + userIntake.getName() + " intake installed. Your horsepower is now: " + getHorsepower()+ " **") ;
                System.out.print("Coins left: ") ;      // Let the user know how many coins they have
                System.out.printf("%,d\n", coins) ;
            }
            catch (InsufficientFundsException e) {
                 // If insufficient funds, print the exception's message
                System.out.println("You only have " + coins + " coins, upgrade not installed.") ;   
            }
        } 
        else if (upgrade == 2) {
                System.out.println("\nInduction Systems:") ;    
                System.out.println("--------------------") ; 
                InductionDatabase induction = new InductionDatabase() ;    // create new InductionDatabase object 
                
                induction.showInductionDatabase() ;     // Display the induction systems
                System.out.print("Choose an intake by entering its number (enter 0 to exit):") ; // Prompt user to choose a system
                
                int userInput = 0 ;                 // input will store the user's induction system choice
                boolean valid = false ;             
                
                // boolean controlled loop to get userInput for choosing an induction system to install
                while (!valid) {
                    try {
                        int next = keyboard.nextInt() ;             // next will store the number the user enters
                        
                        // multi-way if statement for dealing with user input if user enters an int
                        if (next > 0 && next <= InductionDatabase.size) {
                            // if the number is a valid entry:
                            
                            userInput = next ;          // assign next to userInput becuase next is local to the if statements
                            valid = true ;              // exit the boolean controlled input loop
                        }
                        else if (next == 0) {
                            return ;                // if user enters "0", exit the upgrade menu
                        }
                        else {
                            System.out.println("Enter a number 1-5, Or \"0\" to exit upgrade menu.") ;      // invalid number
                        }
                    }
                    catch (InputMismatchException e) {
                        // catching InputMismatchException if usr does not enter an int
                        System.out.print("Invalid input. Enter a whole number only.") ; 
                        keyboard.next() ;           // throw away the invalid user input
                    }
                }
                
                InductionSystem userInduction = induction.getInduction(userInput - 1) ;    // set userInduction to the system they chose 
                
                // Try-block to attempt to install userInduction to the user's car, InsufficientFundsException will be thrown if the user does
                // not have enough coins to buy the system
                try {
                    if (userInduction.getCost() > coins) {
                        // If cost of system is greater than the amount of coins the user has, then throw InsufficientFundsException
                        throw new InsufficientFundsException("You do not have enough coins. Induction System not installed.") ;
                    }
                    setInductionSystem(userInduction) ;         // install the userInduction to the user's car
                    coins -= userInduction.getCost() ;          // subtract the cost of the induction system form user's coins
                    System.out.print("\n** " + userInduction + " installed. You horsepower is now: " + getHorsepower() + ".** \nCoins left: ") ;
                    System.out.printf("%,d\n", coins) ;         // display how many coins user has after buying upgrade
                }
                catch (InsufficientFundsException e) {
                    System.out.println("You only have " + coins + " coins, upgrade not installed.") ;       
                }                
        } 
        else if (upgrade == 3) {
                System.out.println("\nWeight Reductions:") ;
                System.out.println("--------------------") ;
                
                WeightDatabase weightReductions = new WeightDatabase() ;            // create new WeightDatabse object
                weightReductions.showWeightDatabase() ;                             // show the objects in the databse
                
                // Prompt the user to choose a weight reduction upgrade
                System.out.print("Choose a weight reduction amount by entering its number (enter 0 to exit):") ;
                int userInput = 0 ;                 // user's input in loop
                boolean valid = false ;             
                
                // boolean controlled loop for getting userInput on which upgrade they choose
                while (!valid) {
                    try {
                        int next = keyboard.nextInt() ;     // get integer from user
                        if (next > 0 && next <= weightReductions.size) {
                            // If user's input is valid:
                            
                            // if the chosen weight reduction brings the car's weight under 2000 lbs, then throw MinimumWeightException
                            if (getWeight() - weightReductions.getWeight(next - 1).getWeight() < 2000) {
                                throw new MinimumWeightException() ;
                            }
                            
                            userInput = next ;      // assign the input to userInput
                            valid = true ;          // exit the input loop
                        }
                        else if (next == 0) {
                            return ;                // exit the upgrade menu if user enters "0"
                        }
                        else {
                            System.out.println("Enter a number 1-5, Or \"0\" to exit upgrade menu.") ;     // invalid number
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.print("Invalid input. Enter a whole number only.") ;         // when user doesn't enter an int
                        keyboard.next() ;       // throw away the invlaid input
                    }
                    catch (MinimumWeightException e2) {
                        System.out.println(e2.getMessage()) ;
                        System.out.print("Choose another option: ") ;
                    }
                }   
                
                // set the userWeightReduction to the one user chose from the database
                WeightReduction userWeightReduction = weightReductions.getWeight(userInput - 1) ; 
                
                
                // Try-block to attempt to install userWeightReduction to the user's car, InsufficientFundsException will be thrown if the
                // user does not have enough coins to buy the weight reduction
                try {
                    if (userWeightReduction.getCost() > coins) {
                        // If cost of reduction is greater than the amount of coins the user has, then throw InsufficientFundsException
                        throw new InsufficientFundsException("You do not have enough coins. Weight has not been reduced.") ;
                    }
                    setWeightReduction(userWeightReduction) ;       // install the weightReduction onto the user's car
                    coins -= userWeightReduction.getCost() ;        // subtract the cost of the weight reduction from the user's coins
                    System.out.println("\n** Weight reduced by " + userWeightReduction.getWeight() + 
                                        " lbs. Your car's weight is now " + getWeight() + "lbs. **") ;
                    System.out.print("Coins left: ") ;         
                    System.out.printf("%,d\n", coins) ;             // display how mnay coins user has after upgrade
                }
                catch (InsufficientFundsException e) {
                    System.out.println("You only have " + coins + " coins, upgrade not installed.") ;
                }
        }
    }
    
    /**
     * A concluding message that is printed upon completion of the game
     * <p> "Congratulations, you have completed the game. Your <code> horsePower </code> horsepower <code> year </code> <code> make </code>
     *      <code> model </code> proved to be king of the strip." </p>
     */
    public void gameComplete() {
        System.out.println("Congratulations, you have completed the game.") ;
        System.out.print("Your " + getHorsepower() + " horsepower " + getYear() + " " + getMake() + " " + getModel()) ;
        System.out.print(" proved to be king of the strip.") ;
    }
      
    /**
     * toString() method for objects of the ModifiedCar class
     * @return The year, make and model of the ModifiedCar
     */
    public String toString() {
        return getYear() + " " + getMake() + " " + getModel() ;
    }
}