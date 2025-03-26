package LoggerLibrary.entities.sink;

public class ConsoleSink implements Sink{

    @Override
    public void write(String log) {
        // log into console
        System.out.println("Logging in console: " + log);
    }
}
