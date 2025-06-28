
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Debug message: Application started");
        logger.info("Info message: Running main method");
        logger.warn("Warning message: This is a warning");
        logger.error("Error message: Something went wrong");
    }
}
