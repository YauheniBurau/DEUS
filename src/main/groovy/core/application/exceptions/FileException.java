package core.application.exceptions;

/**
 * Created by anonymous on 27.04.2017.
 */
public class FileException extends RuntimeException {

    public FileException(String message, Throwable e) {
        super(message, e);
    }

    public FileException(String message) {
        super(message);
    }
}
