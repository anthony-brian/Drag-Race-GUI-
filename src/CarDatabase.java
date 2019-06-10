import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.Scanner ;
public class CarDatabase {
    private ModifiedCar[] cars ;
    private int numOfCars ;
    
    /**
     * CarDatabase constructor that will create an array of ModifiedCars created using information stored in a text file
     */
    public CarDatabase() {
        Scanner carReader ;                     // carReader will read 
        cars = new ModifiedCar[100] ;           // create an array of ModifiedCar objects
        
        // try block for possible FileNotFoundException from reading in from a text file
        try {
            carReader = new Scanner(new File("CarList.txt")) ;          // carReader will read from "CarList.txt" text file
            int index = 0 ;                                             // index will resemble each line, which one line = one ModifiedCar
            
            while (carReader.hasNextLine()) {
                carReader.useDelimiter(",") ;                   // use comma as a delimiter becuase file contents are seperated by commas
                
                int year = carReader.nextInt() ;                // read year,
                String make = carReader.next() ;                // read make,
                String model = carReader.next() ;               // read model,
                int horsepower = carReader.nextInt() ;          // read horsepower,
                
                carReader.useDelimiter("[,\\s]+") ;             // change the delimiter to whitespace for the newline
                
                int weight = carReader.nextInt() ;              // read weight
                int cost = carReader.nextInt() ;                // read cost
                
                if (carReader.hasNextLine()) {
                    carReader.nextLine() ;                  // throw away the newline
                }
                
                // instantiate a new ModifiedCar at the index of the cars[] array, and assign it the values that were read in from the file
                cars[index] = new ModifiedCar(year, make, model, horsepower, weight, cost) ;
                
                index++ ;               // increment index to instantiate the next element in the array on the next iteration
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage()) ;
        }      
    }
    
    /**
     * getCar returns a car in the cars[] array
     * @param index the index of the ModifiedCar being returned
     */
    public ModifiedCar getCar(int index) {
        return cars[index] ;
    }
    
    /**
     * Displays the contents of the cars[] array in order. 
     */
    public void showCarDatabase() {
        int number = 1 ;
        for(int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                int length = cars[i].getMake().length() + cars[i].getModel().length() ;
                System.out.print(number + ".) " + cars[i] + " ") ;
                int formatSpaces = 20 - length ;
                if (number < 10) {
                    for (int j = 0; j < formatSpaces; j++) {
                        System.out.print("-") ;
                    }
                }
                else {
                    for (int j = 0; j < formatSpaces - 1; j++) {
                        System.out.print("-") ;
                    }
                }
                System.out.printf(" %,d coins\n", cars[i].getCost()) ;
                number++ ;
            }
        }
    }
}
