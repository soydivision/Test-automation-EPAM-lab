package com.epam.core.utilities.service;

import com.epam.core.webdriver.factory.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger("binary_data_logger");
    private static final int TIMEOUT = 100;

    @Override
    public void onTestFailure(final ITestResult result) {
        saveScreenshot();
    }

    private void saveScreenshot() {
        String screenDir = ".//target/screenshots/";
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(TIMEOUT))
                .takeScreenshot(DriverManager.getDriver());
        try {
            new File(screenDir).mkdir();
            String time = getCurrentTimeAsString();
            File screenshotFile = new File(screenDir
                    + time + ".png");
            ImageIO.write(screenshot.getImage(), "PNG", screenshotFile);
            LOGGER.warn("RP_MESSAGE#FILE#{}#{}", screenshotFile.getAbsolutePath(), "Screenshot:");
        } catch (IOException e) {
            LOGGER.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
