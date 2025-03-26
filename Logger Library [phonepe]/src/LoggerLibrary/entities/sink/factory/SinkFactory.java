package LoggerLibrary.entities.sink.factory;

import LoggerLibrary.entities.Config;
import LoggerLibrary.entities.sink.ConsoleSink;
import LoggerLibrary.entities.sink.DBSink;
import LoggerLibrary.entities.sink.FileSink;
import LoggerLibrary.entities.sink.Sink;

public class SinkFactory {
    public static Sink getSink(Config config) {
        switch (config.getSinkType()) {
            case "FILE": return new FileSink(config.getSinkDetails().get("filePath"));
            case "DB": return new DBSink(config.getSinkDetails().get("dbHost"), Integer.parseInt(config.getSinkDetails().get("dbPort")));
            case "CONSOLE": return new ConsoleSink();
            default: throw new IllegalArgumentException("Unknown sink type: " + config.getSinkType());
        }
    }
}