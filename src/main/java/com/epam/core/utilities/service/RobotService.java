package com.epam.core.utilities.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public final class RobotService {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final int ROBOT_DELAY = 1500;

    private RobotService() {
    }

    public static void callRobotToPastePath(final String pathToPhotoFile) {
        LOGGER.info("Robot launched");
        try {
            Robot robot = new Robot();
            StringSelection path = new StringSelection(pathToPhotoFile);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
            robot.delay(ROBOT_DELAY);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(ROBOT_DELAY);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            LOGGER.error("Robot failed  " + e.getMessage());
        }
    }

    public static String getAbsolutePath(final String relativePath) {
        String systemPath = System.getProperty("user.dir");
        String absolutePath = systemPath.concat("\\").concat(relativePath);
        return absolutePath;
    }
}
