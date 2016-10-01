package be.odisee.verhuursysteem_sharingbox.utilities;

public class RolNotFoundException extends Exception{

	

    /**
     * Creates a new instance of <code>RolNotFoundException</code> without detail message.
     */
    public RolNotFoundException() {
    }


    /**
     * Constructs an instance of <code>RolNotFoundException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public RolNotFoundException(String msg) {
        super(msg);
    }
}
