package LoggerLibrary;

import LoggerLibrary.entities.Config;
import LoggerLibrary.manager.Logger;
import LoggerLibrary.entities.Message;
import LoggerLibrary.enums.LogLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Config> configs = new ArrayList<>();

        // INFO Config
        Map<String, String> fileSinkDetails = new HashMap<>();
        fileSinkDetails.put("filePath", "src/logs/app.log");

        configs.add(new Config("dd-MM-yyyyHH:mm:ss", LogLevel.INFO, "FILE", fileSinkDetails));

        // ERROR Config
        Map<String, String> dbSinkDetails = new HashMap<>();
        dbSinkDetails.put("dbHost", "127.0.0.1");
        dbSinkDetails.put("dbPort", "3306");

        configs.add(new Config("dd-MM-yyyy HH:mm:ss", LogLevel.ERROR, "FILE", fileSinkDetails));

        // Initialize Logger
        Logger logger = Logger.getInstance(configs);

        // Create messages
        Message message1 = new Message("User login successful", LogLevel.INFO, "AuthService");
        Message message2 = new Message("Payment failed for orderId=12345", LogLevel.INFO, "PaymentService");

        // Log messages
        for(int i=0;i<10;i++) {
            message1.setContent("User login successful "+i);
            logger.log(message1);
            logger.log(message2);
        }

    }
}