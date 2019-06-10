import java.util.Scanner ;
public class Car {
    private int year ;                          // Year car was made
    private String make ;                       // Make of car (Ex. Toyota)
    private String model ;                      // Model of car (Ex. Corolla)
    private int horsepower ;                    // Horsepower figure of car
    private int curbWeight ;                    // Curb weight of car
    private double quarterMileTime ;            // Time car takes to travel 1/4 mile
    private double quarterMileSpeed ;           // Speed trap at 1/4 mile
    
    /**
     * Full constructor for objects of Car() class 
     * @param year stores the year the car was made
     * @param make stores the manufacturer of the car's name (Ex. Toyota, Honda, Ford... etc.)
     * @param model stores the model of the car (Ex. Corolla, Civic, F-150... etc.)
     * @param horsepower stores the horsepower figure of the car
     * @param curbWeight stores the curb weight of the car
     */
    public Car(int year, String make, String model, int horsepower, int curbWeight) {
        this.year = year ;
        this.make = make ;
        this.model = model ;
        this.horsepower = horsepower ;
        this.curbWeight = curbWeight ;   
    }
    
    /**
     * Empty constructor for objects of the Car() class
     */
    public Car() {
        year = 0 ;
        make = "Unavailable" ;
        model = "Unavailable" ;
        horsepower = 0 ;
        curbWeight = 0 ;
    }
    
    /**
     * Constructor for objects of the Car() class that takes horsepwer and curbWeight parameters
     * @param horsepower - stores the horsepower figure of the car
     * @param curbWeight - stores the curb weight of the car
     */
    public Car(int horsepower, int curbWeight) {
        this(0, "Unavailable", "Unavailable", horsepower, curbWeight) ;             
    }
    
    /**
     * Getter method for year instance variable
     * @return year - Year the car was manufactured
     */
    public int getYear() {
        return year ;
    }
    
    /**
     * Getter method for horsepower instance variable
     * @return horsepower - The horsepower rating of the car
     */
    public int getHorsepower() {
        return horsepower ;
    }
    
    /**
     * Getter method for variable make
     * @return make - String that holds the manufacturer's name of the Car
     */
    public String getMake() {
        return make ;
    }
    
    /**
     * Getter method for model instance variable
     * @return model - The model of the car (Ex. Corolla, Civic, F-150)
     */
    public String getModel() {
        return model ;
    }
    
    /**
     * Getter method for curbWeight instance variable
     * @return model - The model of the car (Ex. Corolla, Civic, F-150)
     */
    public int getWeight() {
        return curbWeight ;
    }
    
    /**
     * Setter method for make of car
     * @param make the manufacturer's name
     */
    public void setMake(String make) {
        this.make = make ;
    }
    
    /**
     * setter for model of the car
     * @param model the model name of the car
     */
    public void setModel(String model) {
        this.model = model ;
    }
    
    /**
     * setter for horsepower of the car
     * @param horsepower the new horsepower figure
     */
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower ;
    }
    
    /**
     * setter for curbWeight of the car
     * @param curbWeight the new weight of the car
     */
    public void setWeight(int curbWeight) {
        this.curbWeight = curbWeight ;
    }
    
    /**
     * Calculates the time it takes the vehicle to travel 1/4 of a mile.
     * @return quarterMileTime - time takes for car object to travel 1/4 mile 
     */
    public double calculateTime() {
        quarterMileTime = Math.pow((double)curbWeight / horsepower,.333) * 5.825 ;  // Equation for estimating 1/4 mile time: 
        return quarterMileTime ;                                                    // ((weight/HP)^333 * 5.825)
    }
    
    /**
     * Calculates the speed the car object is travelling when it passes the 1/4 mile marker (a speed trap)
     * @return quarterMileSpeed - speed at which car is travelling at 1/4 mile
     */
    public double calculateSpeed() {
        quarterMileSpeed = Math.pow((double)horsepower / curbWeight,.333) * 234 ;   // Equation for estimating 1/4 mile speed: 
        return quarterMileSpeed ;                                                   // ((HP/weight)^333 * 234)
    }
    
    /**
     * Emulates a 1/4 straight drag race between two cars
     * @param carOne one of the cars that will partake in the race
     * @param carTwo the other car that will partake in the race
     * @return the winner of the race (which car has the lower 1/4 mile time)
     */
    public static Car race(Car carOne, Car carTwo) {
        double carOneTime = carOne.calculateTime() ;                // calculate the quarter mile time for carOne
        double carTwoTime = carTwo.calculateTime() ;                // calulate the quarter mile tome for carTwo
        double carOneSpeed = carOne.calculateSpeed() ;              // calculate the speed travelled by carOne at the quarter mile mark
        double carTwoSpeed = carTwo.calculateSpeed() ;              // calculate the speed travelled by carTwo at the quarter mile mark
        
        int nameLength1 = carOne.getMake().length() + carOne.getModel().length() + 1;       // the length of the first car's name
        int nameLength2 = carTwo.getMake().length() + carTwo.getModel().length() + 1;       // the length of the second car's name
        
        int largest = nameLength1 > nameLength2 ? nameLength1 : nameLength2 ;   // find largest name of the two cars
        
        // This multi-way if statement's purpose is to format the output so that the time and speed results are lined up 
        if (largest == nameLength1) {
            // If the largest name is carOne's name: 
            
            int differenceInLength = nameLength1 - nameLength2 ;        // find the difference in length of the two names
            System.out.printf(carOne + " -  %.2f seconds @ %.2f MPH\n", carOneTime, carOneSpeed) ;  // display car One's name, time and speed
            
            System.out.print(carTwo) ;   // display the smaller car's name
            
            //Then print the a space until the difference in length is 0 between the two names
            for (int i = 0; i < differenceInLength; i++) {
                System.out.print(" ") ;
            }
            
            // Print the time & speed for carTwo, now it will now be directly underneath the time & speed of carOne 
            System.out.printf(" -  %.2f seconds @ %.2f MPH\n\n", carTwoTime, carTwoSpeed) ;
        }
        else if (largest == nameLength2) {
            // If the largest name is carTwo's name:
            
            int differenceInLength = nameLength2 - nameLength1 ;        // find the difference in length of the two names
            System.out.print(carOne) ;      // display carOne's name
            
            // Then print spaces until the difference in length is 0 between the two names
            for (int i = 0; i < differenceInLength; i++) {
                System.out.print(" ") ;
            }
            
            // Print the time and speed for carOne, now it will be directly above time & speed for carTwo
            System.out.printf(" -  %.2f seconds @ %.2f MPH\n", carOneTime, carOneSpeed) ;
            
            // Print the time and speed for carTwo
            System.out.printf(carTwo + " -  %.2f seconds @ %.2f MPH\n\n", carTwoTime, carTwoSpeed) ;
        }
        
        Car winner = new Car() ;        // will store the winning car
        
        // decide who the winner of the race is by comparing times
        if(carOneTime > carTwoTime) {
            System.out.println("The winner of the 1/4 mile race is: " + carTwo + "!") ;
            winner = carTwo ;
        }
        else if(carOneTime < carTwoTime) {
            System.out.println("The winner of the 1/4 mile race is: " + carOne + "!") ;
            winner = carOne ;
        }
        else if (carOneTime == carTwoTime) {
            System.out.println(carOne + " and " + carTwo + " tied! Race is a draw.") ;  
        }
        
        // return the winning car
        return winner ;
    }
    
    
    
    /**
     * toString() method for objects of the Car() class
     * @return the year, make, model of the car. EX: "1998 Toyota Supra"
     */
    public String toString() {
        return getYear() + " " + getMake() + " " + getModel() ;
    }
}