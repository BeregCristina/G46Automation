package helpers;

import org.apache.logging.log4j.Logger;

import static helpers.ConsoleColors.*;

public class ColorPrinter {

    public static void printMessageInYellow(String message) {
        System.out.println(YELLOW_BRIGHT + BLUE_BACKGROUND + message + RESET);
    }

    public static void printMessageInYellow(String message, Logger logger) {
        logger.info(YELLOW_BRIGHT + BLUE_BACKGROUND + message + RESET);
    }

    public static void printColorMessage(String message, Logger logger, Level level) {
        switch (level) {
            case DEBUG:
                logger.debug(CYAN_BOLD + message + RESET);
                break;
            case INFO:
                logger.info(GREEN_BOLD + message + RESET);
                break;
            case ERROR:
                logger.error(BLUE_BOLD + message + RESET);
                break;
        }
    }

    public static void printInPurple(String message, Logger logger) {
        logger.info(PURPLE_BOLD + WHITE_BACKGROUND + message + RESET);
    }
}
