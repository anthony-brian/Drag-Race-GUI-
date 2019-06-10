public class AirIntakeDatabase {
    private AirIntake[] intakes ;
    public static int size ;
    
    /**
     * Constructor for AirIntakeDatabse objects. Creates an array of 7 AirIntakes that each have a name, cost and horsepower gain variable.
     * These are used when upgrading the user's ModifiedCar
     */
    public AirIntakeDatabase() {
        size = 7 ;
        intakes = new AirIntake[size] ;
        intakes[0] = new AirIntake("HPS", 40, 500) ;            // 40 HP increase, 500 coins
        intakes[1] = new AirIntake("Spectre", 50, 1000) ;       // 50 HP increase, 1000 coins
        intakes[2] = new AirIntake("S&B", 60, 1500) ;           // 60 HP increase, 1500 coins
        intakes[3] = new AirIntake("K&N", 70, 2000) ;           // 70 HP increase, 2000 coins           
        intakes[4] = new AirIntake("Injen", 80, 2500) ;         // 80 HP increase, 2500 coins
        intakes[5] = new AirIntake("AEM", 90, 3000) ;           // 90 HP increase, 3000 coins
        intakes[6] = new AirIntake("Holley", 100, 3500) ;        // 100 HP increase, 3500 coins
    }
    
    /**
     * Getter for elements inside the intakes[] array
     * @parameter index the index of the element in the array that will be returned
     * @return AirIntake - the intake at the given index 
     */
    public AirIntake getIntake(int index) {
        return intakes[index] ;
    }
    
    /**
     * Displays the intakeDatabase, showing the names, cost and HP increase from each intake in the array
     */
    public void showIntakeDatabase() {
       int number = 1 ;
       for(int i = 0; i < intakes.length; i++) {
           System.out.print(number + ". " + intakes[i] + " ") ;
           for (int j = 0; j < 5; j++) {
               System.out.print("-") ;
           }
           System.out.printf(" %,d coins\n", intakes[i].getCost()) ;
           number++ ;
       }
    }
}