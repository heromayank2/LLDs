package LoggerLibrary.entities;

import LoggerLibrary.enums.LogLevel;

public class Message {
    private String content;
    private LogLevel level;
    private String namespace;

    public Message(String content, LogLevel level, String namespace) {
        this.content = content;
        this.level = level;
        this.namespace = namespace;
    }

    public String getContent() { return content; }
    public LogLevel getLevel() { return level; }
    public String getNamespace() { return namespace; }

    public void setContent(String content){
        this.content = content;
    }
}
