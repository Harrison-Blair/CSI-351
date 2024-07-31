package main;

public class IFeelException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // default constructor
    IFeelException() {
    }

    // Parameterized constructor
    IFeelException(String str) {
        super(str);
    }
}