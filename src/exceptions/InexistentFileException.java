package exceptions;

public class InexistentFileException extends RuntimeException {
    public InexistentFileException() {
        super("File doesn't exist!");
    }
}
