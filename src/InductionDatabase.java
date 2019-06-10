public class InductionDatabase {
    private InductionSystem[] induction ;
    public static int size ;
    
    /**
     * Constructor for InductionDatabase objects. Creates 5 InductionSystem objects and assigns them to induction[] array elements 
     */
    public InductionDatabase() {
        size = 5 ;      // size of the array
        induction = new InductionSystem[size] ;
        induction[0] = new InductionSystem("Small supercharger", 100, 3000) ;       // 100 HP increase, 3000 coins
        induction[1] = new InductionSystem("Small Turbo", 120, 3500) ;              // 120 HP increase, 3500 coins
        induction[2] = new InductionSystem("Pro-Charger", 140, 5000) ;              // 140 HP increase, 5000 coins
        induction[3] = new InductionSystem("Big supercharger", 160, 5500) ;         // 160 HP increase, 5500 coins          
        induction[4] = new InductionSystem("Big Turbo", 180, 6000) ;                // 180 HP increase, 6000 coins
    }
    
    /**
     * Getter for elements inside the intakes[] array
     * @parameter index the index of the element in the array that will be returned
     * @return InductionSystem - the InductionSystem at the given index 
     */
    public InductionSystem getInduction(int index) {
        return induction[index] ;
    }
    
    /**
     * Displays all elements in the InductionDatabase. Displays their name, cost, and HP increase
     */
     public void showInductionDatabase() {
        int number = 1 ;
        for(int i = 0; i < induction.length; i++) {
            System.out.print(number + ". " + induction[i] + " ") ;
            int length = induction[i].getName().length() ;
            int formatSpaces = 20 - length ;
            for (int j = 0; j < formatSpaces; j++) {
               System.out.print("-") ;
           }
           System.out.printf(" %,d coins\n", induction[i].getCost()) ;
            number++ ;
        }
    }
}
