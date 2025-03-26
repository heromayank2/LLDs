package LoggerLibrary.entities;

import LoggerLibrary.enums.LogLevel;

import java.util.Map;

public class Config {
    private String timeFormat;
    private LogLevel logLevel;
    private String sinkType;
    private Map<String, String> sinkDetails;

    public Config(String timeFormat, LogLevel logLevel, String sinkType, Map<String, String> sinkDetails) {
        this.timeFormat = timeFormat;
        this.logLevel = logLevel;
        this.sinkType = sinkType;
        this.sinkDetails = sinkDetails;
    }

    public String getTimeFormat() { return timeFormat; }
    public LogLevel getLogLevel() { return logLevel; }
    public String getSinkType() { return sinkType; }
    public Map<String, String> getSinkDetails() { return sinkDetails; }
}