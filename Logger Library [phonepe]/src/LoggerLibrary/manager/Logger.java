package LoggerLibrary.manager;

import LoggerLibrary.entities.Config;
import LoggerLibrary.entities.Message;
import LoggerLibrary.enums.LogLevel;
import LoggerLibrary.exceptions.SinkNotFoundException;
import LoggerLibrary.entities.sink.factory.SinkFactory;
import LoggerLibrary.entities.sink.Sink;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Logger {
    private List<Config> configs;
    private Map<LogLevel, Sink> sinks;
    private Map<LogLevel, String> timeFormatMap;

    private static volatile Logger logger = null;

    private Logger(List<Config> configs) {
        this.configs = configs;
        this.sinks = new ConcurrentHashMap<>();
        this.timeFormatMap = new ConcurrentHashMap<>();
        initializeSinks();
    }

    public static Logger getInstance(List<Config> configs){
        if(logger==null){
            synchronized (Logger.class){
                if(logger==null){
                    logger = new Logger(configs);
                }
            }
        }
        return logger;
    }

    private void initializeSinks() {
        for (Config config : configs) {
            sinks.put(config.getLogLevel(), SinkFactory.getSink(config));
            timeFormatMap.put(config.getLogLevel(), config.getTimeFormat());
        }
    }

    public void log(Message message) {
        String timestamp = new SimpleDateFormat(timeFormatMap.get(message.getLevel())).format(new Date());
        String logEntry = String.format("%s [%s] %s: %s", timestamp, message.getLevel(), message.getNamespace(), message.getContent());
        Sink sink = sinks.get(message.getLevel());
        if (sink != null) {
            sink.write(logEntry);
        }else{
            throw new SinkNotFoundException("Sink not found for log level: "+message.getLevel());
        }
    }
}
