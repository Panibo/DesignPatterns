import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance;

    private String fileName;

    private BufferedWriter writer;

    private Logger() {
        // Prevent writer initialization without a file name
        this.fileName = "log.txt";
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        close();
        this.fileName = fileName;
        initializeWriter();
    }

    public synchronized void write(String message) {
        initializeWriter();
        try {
            if (writer != null) {
                writer.write(java.time.LocalDateTime.now() + ": " + message);
                writer.newLine();
                writer.flush();
            } else {
                System.err.println("Logger is not initialized with a file.");
            }
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }

    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                writer = null;
            }
        } catch (IOException e) {
            System.err.println("Failed to close the log file: " + e.getMessage());
        }
    }

    private void initializeWriter() {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Failed to initialize log file: " + e.getMessage());
        }
    }

}