/**
 * <p><h1>The InsufficientFundsException class extends exception, and is thrown when the user attempts to buy an upgrade that costs more
 *                 than their current coin balance. </h1>
 *    <p> Constructors: </p>
 *    <pre> 
 *          InsufficientFundsException()
 *          InsufficientFundsException(String message)
 *    </pre>
 *    <ul>
 *  <p> The no argument constructor will print "Not enough coins. Upgrade not purchased." when the exception is thrown </p>
 *  <p> The no single constructor will print <code> message </code> when the exception is thrown </p>
 *  </ul>
 * </p> 
 */
public class InsufficientFundsException extends Exception {
    /**
     * No argument constructor that will print: <bold>"Not enough coins, Upgrade not purchased."</bold> when exception is thrown
     */
    public InsufficientFundsException() {
        super("Not enough coins. Upgrade not purchased.") ;
    }
    
    /**
     * Single argument constructor that will print: <code>message</code> when exception is thrown
     */
    public InsufficientFundsException(String message) {
        super(message) ;
    }
}
