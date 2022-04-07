package myException;

/**
 * @author Komorebi
 * @since 2021.11.11.16:42
 */

public class NegativeException extends Exception{
    public NegativeException(){super();}
    public NegativeException(String message){super(message);}
}
