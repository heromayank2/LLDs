package LoggerLibrary.entities.sink;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.GZIPOutputStream;

public class FileSink implements Sink {
    private static final double MAX_FILE_SIZE = 1024; // 1 kB
    private String filePath;
    private File logFile;

    public FileSink(String filePath) {
        this.filePath = filePath;
        this.logFile = new File(filePath);
    }

    @Override
    public void write(String log) {
        rotateLogsIfNeeded();

        if((log.length() + logFile.length() )>MAX_FILE_SIZE){ // 10 KB CURRENT 8 KB
            String logStart = log.substring(0, (int) MAX_FILE_SIZE);  // 2 kB
            String logEnd = log.substring((int) MAX_FILE_SIZE);  // 3 kB
            write(logStart);
            log = logEnd;
            rotateLogsIfNeeded();
        }

        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(log + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rotateLogsIfNeeded() {
        if (logFile.exists() && logFile.length() >= MAX_FILE_SIZE) {
            try {
                for (int i = 5; i >= 1; i--) {
                    File oldFile = new File(filePath + "." + i + ".gz");
                    File newFile = new File(filePath + "." + (i + 1) + ".gz");
                    if (oldFile.exists()) {
                        Files.move(oldFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
                File firstFile = new File(filePath + ".1");
                Files.move(logFile.toPath(), firstFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                compressLog(firstFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void compressLog(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(file.getPath() + ".gz");
             GZIPOutputStream gos = new GZIPOutputStream(fos)) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                gos.write(buffer, 0, len);
            }
            fis.close();
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
