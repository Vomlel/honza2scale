package net.toscalecz.test.unused;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringLoggingHelper {

    private static final Logger logger = LoggerFactory.getLogger(SpringLoggingHelper.class);

    public void helpMethod() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
    }
}
