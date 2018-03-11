package ch.hslu.ad.sw02_D1.stack;

public class StackFullException extends RuntimeException {

    public StackFullException() {
    }

    public StackFullException(String message) {
        super(message);
    }
}
