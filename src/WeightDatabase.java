public class WeightDatabase {
    private WeightReduction[] weightReductions ;
    public static int size ;
    
    /**
     *  Constructor for WeightDatabase objects. Creates 5 WeightReduction objects and assigns them to weightReduciton[] 
     *  array elements(instance variable) 
     */
    public WeightDatabase() {
        size = 5 ;
        weightReductions = new WeightReduction[5] ;
        weightReductions[0] = new WeightReduction(100, 2000) ;          // 100 lbs, 2000 coins
        weightReductions[1] = new WeightReduction(200, 3000) ;          // 200 lbs, 3000 coins          
        weightReductions[2] = new WeightReduction(300, 4000) ;          // 300 lbs, 4000 coins
        weightReductions[3] = new WeightReduction(400, 5000) ;          // 400 lbs, 5000 coins
        weightReductions[4] = new WeightReduction(500, 6000) ;          // 500 lbs, 6000 coins
    }
    
    
    /**
     * Getter for elements inside the WeightReduction[] array
     * @parameter index the index of the element in the array that will be returned
     * @return WeightReduction - the WeightReduction at the given index 
     */
    public WeightReduction getWeight(int index) {
        return weightReductions[index] ;
    }
    
    /**
     * Displays the weightReduction options in the weightReductions array. Displays the weight and cost of each object
     */
     public void showWeightDatabase() {
        int number = 1 ;
        for(int i = 0; i < weightReductions.length; i++) {
            System.out.print(number + ". " + weightReductions[i]) ;
            System.out.println(" -------- " + weightReductions[i].getCost() + " coins") ;
            number++ ;
        }
    }
}