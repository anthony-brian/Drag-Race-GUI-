import java.util.Scanner ;
import java.util.InputMismatchException ;
/**
 * <h2> Main.java - Driver class for a 5-level Drag Racing game where the user picks a car, and installs upgrades to win 5 different 1/4 mile 
 * races </h2>
 * <p> Problem Statement: Write a program that emulates a 1/4 mile drag racing game, with 5 levels. The user will upgrade a vehicle by installing
 * an aftermarket air intake, a forced induction system and performing weight reductions. Use a coin currency for upgrades. </p> 
 * <p> Algorithm: 
 *      <ol>
 *          <li> List the vehicle database stored in CarDatabase objects. </li>
 *          <li> Prompt the user to pick a car </li>
 *          <li> Subtract the cost of the car from the user's coins (coins are stored in ModifiedCar class) </li>
 *          <li> LOOP while the game is incomplete, and the user has not exited the game intentionally  </li>
 *              <ol> 
 *                  <li> Prompt the user to enter "Race", "Upgrade", or "Exit" </li>
 *                  <li> If the user enters "Race":</li>
 *                      <ul>
 *                          <li> Enter the current level the user has to beat </li>
 *                          <li> Call the race() method to compare the user's car to the opponent's car and display results </li>
 *                          <li> return the winner of the race </li>
 *                          <li> if the user won </li>
 *                              <ul>
 *                                  <li> Congratulate the user and increase the level counter to let program know user is on the next level </li>
 *                                  <li> Reward the user with 2000 coins for winning </li>
 *                                  <li> If level = 6 </li>
 *                                      <ul>
 *                                          <li> Print a message letting the user know they have completed the game </li>
 *                                          <li> Exit the program because all 5 levels are complete </li>
 *                                      </ul>
 *                              </ul>
 *                      </ul>
 *                  <li> If the user enters "Upgrade":</li>
 *                      <ul>
 *                          <li> Call the upgrade() method in ModifiedCar class </li>
 *                          <li> upgrade() Algorithm: </li>
 *                              <ol>
 *                                   <li> List the upgrade categories (1.Air Intake, 2.Induction System, 3.Weight Reduction) </li> 
 *                                   <li> Prompt the user to enter which upgrade they want to do </li>   
 *                                   <li> List the "database" of the upgrade options for the user to choose from. </li> 
 *                                   <li> Prompt the user to choose which upgrade they want to install </li>
 *                                   <li> If the user has enough money to perform the upgrade
 *                                      <ul>
 *                                          <li> install the upgrade </li>
 *                                          <li> subtract the cost of the upgrade from the user's coins </li>
 *                                          <li> display their remaining balance </li>
 *                                      </ul>
 *                                   </li>    
 *                                   <li> If the user doesnt have sufficient funds </li>
 *                                   <ul>
 *                                          <li> throw InsuffientFundsException </li>
 *                                          <li> exit the upgrade menu </li>
 *                                   </ul>
 *                              </ol>
 *                       </ul>
 *                  <li> If the user enters "Exit":</li>
 *                      <ul>
 *                          <li> Exit the program. </li>
 *                      </ul>
 *              </ol>
 *      </ol></p>
 * @author Brian Schmidt
 * @version Final Project
 */ 
public class Main {
    public static final int LEVEL_REWARD = 2000 ;
        public static void main(String[] args) {
            
            // Introduction message to the game
            System.out.println("Welcome to my Drag Racing game. There are 5 cars to beat in a 1/4 mile race. Each level will increase" +
                                " in difficulty. Win races by upgrading your \ncar's intake, installing a turbo or supercharger, and reducing"
                                + " your car's weight. Each win, you'll be rewarded with 2000 coins.") ;
                                
            // Create a Scanner for keyboard input 
            Scanner keyboard = new Scanner(System.in) ;
            
            // Prompt user to enter the index of their desired car 
            
            System.out.println("\nStart by entering the number vehicle you would like: ") ;       // Prompt user to enter number
            System.out.printf("Your coins: 20,000\n") ;
            CarDatabase allCars = new CarDatabase() ;                                           // Create new CarDatabase object 
            allCars.showCarDatabase() ;                                                         // Show the CarDatabase to user
            System.out.print("\nvehicle #") ;               
            
            // UserCar will be the user's ModifiedCar
            ModifiedCar userCar = new ModifiedCar();
            int userNum = 0 ;                                   // userNum will be the keyboard input for car choice
            boolean valid = false ;                             // boolean value for looping until a valid number is entered for userNum
            while (!valid) {
                try {          
                    int input = keyboard.nextInt() ;        // User input, int
                    if (input > 0 && input < 11) {  
                        userNum = input ;                   // If input is an int between 1 and 10, assign it to userNum  
                        valid = true ;                      // Make valid true to exit the boolean-controlled loop
                    }
                    else {
                        System.out.println("Invalid Number, enter a number 1-10 please.") ;   // If int is greater than 10 or less than 1
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid... Enter a whole number 1 - 10 only") ;     // InputMismatchException (if input is not an int)
                    keyboard.next() ;       // Get the next user input
                }
            }
            
            
            
            userCar = allCars.getCar(userNum - 1) ;     // set userCar to the car the user chose
            System.out.print("You chose a " + userCar) ;
            Car winner  = new Car();                    // winner will store the winner after each race
            
            userCar.setCoins(userCar.getCoins() - userCar.getCost()) ;  // subtract the price of the user's car from th user's coins
            System.out.printf(". You have %,d coins left\n", userCar.getCoins()) ; // display how many coins user has left
            
            int level = 1 ;                     // level stores the current level the user is on
            boolean gameComplete = false ;      // when all five levels are passed, gameComplete will be true, game loop will be exited
            while(!gameComplete) {
                    System.out.println("-----------------------------------------------------------------------------------------------------") ;              
                    System.out.println("Enter \"Race\" to do your next race.") ;                // "Race" will let you race your current level
                    System.out.println("Enter \"Upgrade\" to modify your car.") ;               // "Upgrade" will let you upgrade your car
                    System.out.println("Enter \"Exit\" to exit the game.") ;                    // "Exit" input will exi the game
                    String input = "" ;     
                
                    input = keyboard.next() ;                       // input from the user that will determine whether to Race, Upgrade or Exit
                
                    if (input.equalsIgnoreCase("Race")) {
                        // If level reaches 5, then do not race anymore
                        if (level >= 1 && level <= 5) {
                            winner = level(userCar, level) ;        // this is where the race occurs, inside the level() method
                        }
                        // If the user won the race
                        if (winner.equals(userCar)) {
                            System.out.println("Congratulations, Level " + level + " complete. You have been rewarded " + LEVEL_REWARD + 
                                                " coins.\n") ;
                            level++ ;               // go to the next level
                            userCar.setCoins(userCar.getCoins() + LEVEL_REWARD) ;
                            System.out.printf("%,d coins left\n", userCar.getCoins());
                            
                            // If all levels are complete (1-5)
                            if (level == 6) {
                                userCar.gameComplete() ;      // Call game.Complete() which prints the concluding message
                                gameComplete = true ;         // Set boolean value to true so the program exits the boolean-controlled loop 
                            }
                        }
                        else {
                            System.out.println("Sorry, you did not pass this level. Try upgrading your car.\n") ;   // if user lost the race
                        }
                    }
                    else if (input.equalsIgnoreCase("Upgrade")) {
                        userCar.upgrade() ;             // If user types "Upgrade" , call upgrade() of the modified car class
                    }
                    else if (input.equalsIgnoreCase("Exit")){
                        System.exit(0) ;                // IF user types "Exit" , exit the game completely
                    }
                    else {
                        System.out.println("** Invalid **") ;       // If user enters anything else, then display "** Invalid **" and re-loop
                    }   
            }   
        }
        
        public static Car level(Car userCar, int level) {
            Scanner keyboard = new Scanner(System.in) ;      // New Scanner object for keyboard input
            Car[] opponents = new Car[5] ;                   // Array of cars that will store opponent's cars
            
            // These are the opponent cars in each level
            opponents[0] = new Car(2016, "Honda", "Civic", 134, 3875) ;            // Level 1: 2016 Honda Civic, 707 Horspower, 4448 lbs
            opponents[1] = new Car(2018, "Ford", "Mustang GT", 375, 3825) ;        // Level 2: 2018 Ford Mustang, 375 Horspower, 3825 lbs
            opponents[2] = new Car(2019, "Porsche", "911 GT3-RS", 420, 3953) ;     // Level 3: 2019 Porsche 911 GT3-RS, 707 Horspower, 4448 lbs
            opponents[3] = new Car(2019, "Dodge", "Challenger Hellcat", 707, 4448) ; // Level 4: 2019 Dodge Challenger, 134 Horspower, 4547 lbs
            opponents[4] = new Car(2015, "Lamborghini", "Huracan", 620, 3488) ;   // Level 5: 2015 Lamborghini Huracan, 500 Horspower, 3135 lbs
            
            // Set currentOpponent to the level - 1 because level begins counting at 1, while array index starts a 0.
            Car currentOpponent = opponents[level - 1] ;
            
            // Display the opponent's vehicle to the console, then prompt user to enter any key to begin the race
            System.out.println("-------------") ;
            System.out.println("Level " + level + ":") ;
            System.out.println("-------------") ;
            System.out.print("Objective: Beat a " + currentOpponent + " in a 1/4 mile Drag Race. ") ;
            System.out.print("Enter any key to begin the Race! ") ;
            keyboard.next() ;
            
            // Print the results of the race and set winner to whichever car won the race
            System.out.println("\n****** Results ******") ;
            Car winner = Car.race(userCar, currentOpponent) ;
            return winner ;
        }
}
