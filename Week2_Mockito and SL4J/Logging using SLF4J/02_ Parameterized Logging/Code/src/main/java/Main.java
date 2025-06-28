import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    public class Main {

        private static final Logger logger = LoggerFactory.getLogger(Main.class);

        public static void main(String[] args) {
            String username = "tharun123";
            int loginAttempts = 3;

            logger.info("User '{}' has attempted to login {} times.", username, loginAttempts);

            logger.debug("Debug log: user={}, attempts={}", username, loginAttempts);
            logger.warn("Warning: user '{}' failed to login {} times", username, loginAttempts);
            logger.error("Error log with user '{}'", username);
        }
    }

