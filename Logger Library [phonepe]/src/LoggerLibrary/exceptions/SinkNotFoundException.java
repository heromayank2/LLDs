package LoggerLibrary.exceptions;

public class SinkNotFoundException extends RuntimeException{
    public SinkNotFoundException(String message){
        super(message);
    }
}
