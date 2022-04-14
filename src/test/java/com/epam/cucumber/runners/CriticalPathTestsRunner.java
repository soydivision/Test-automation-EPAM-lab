package com.epam.cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@critical-path",
        glue = "com.epam.cucumber",
        features = "classpath:features")
public class CriticalPathTestsRunner extends AbstractTestNGCucumberTests {
}
