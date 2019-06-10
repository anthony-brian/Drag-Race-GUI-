/**
 * <p><h1>The MinimumWeightException class extends exception, and is thrown when the user attempts to buy a weight reduction that will
 *                 bring their car's weight under 2000 lbs. </h1>
 *    <p> Constructors: </p>
 *    <pre> 
 *          MinimumWeightException()
 *          MinimumWeightException(String message)
 *    </pre>
 *    <ul>
 *  <p> The no argument constructor will print "There is not enough items to remove on the vehicle to reduce the weight by that amount.
 *  Minimum weight is 2000 lbs." when the exception is thrown </p>
 *  <p> The no single constructor will print <code> message </code> when the exception is thrown </p>
 *  </ul>
 * </p> 
 */
public class MinimumWeightException extends Exception {
    /**
     * No argument constructor that will print: <b>"There is not enough items to remove on the vehicle to reduce the weight by that 
     * amount. Minimum weight is 2000 lbs."</b> when exception is thrown
     */
    public MinimumWeightException() {
        super("\nThere is not enough items to remove on the vehicle to reduce the weight by that amount. Minimum weight is 2000 lbs.") ;
    }
    
    /**
     * Single argument constructor that will print: <code>message</code> when exception is thrown
     */
    public MinimumWeightException(String message) {
        super(message) ;
    }
}