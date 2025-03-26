package LoggerLibrary.entities.sink;

public class DBSink implements Sink {
    private String dbHost;
    private int dbPort;

    public DBSink(String dbHost, int dbPort) {
        this.dbHost = dbHost;
        this.dbPort = dbPort;
    }

    @Override
    public void write(String log) {
        // Insert log into database
        System.out.println("Logging to DB: " + log);
    }
}