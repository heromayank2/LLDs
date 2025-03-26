package LoggerLibrary.test;
import LoggerLibrary.entities.sink.FileSink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoggerTest {
    private static final String TEST_FILE_PATH = "test_log.log";

    public static void main(String[] args) {
        testFileSinkWrite();
        testFileSinkRotation();
    }

    private static void testFileSinkWrite() {
        System.out.println("Running testFileSinkWrite...");
        FileSink fileSink = new FileSink(TEST_FILE_PATH);
        fileSink.write("Test log entry");

        File logFile = new File(TEST_FILE_PATH);
        if (logFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
                String line = reader.readLine();
                if ("Test log entry".equals(line)) {
                    System.out.println("testFileSinkWrite PASSED");
                } else {
                    System.out.println("testFileSinkWrite FAILED - Unexpected log content");
                }
            } catch (IOException e) {
                System.out.println("testFileSinkWrite FAILED - Error reading file");
                e.printStackTrace();
            }
        } else {
            System.out.println("testFileSinkWrite FAILED - Log file does not exist");
        }

        logFile.delete();
    }

    private static void testFileSinkRotation() {
        System.out.println("Running testFileSinkRotation...");
        FileSink fileSink = new FileSink(TEST_FILE_PATH);
        for (int i = 0; i < 1000; i++) {
            fileSink.write("Log entry " + i);
        }

        File rotatedFile = new File(TEST_FILE_PATH + ".1.gz");
        if (rotatedFile.exists()) {
            System.out.println("testFileSinkRotation PASSED");
        } else {
            System.out.println("testFileSinkRotation FAILED - Log rotation did not occur");
        }
        new File(TEST_FILE_PATH).delete();
        rotatedFile.delete();
    }
}
