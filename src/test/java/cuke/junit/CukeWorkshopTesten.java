package cuke.junit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cuke.common.browser.BrowserHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 23-1-2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        format = {"pretty", "html:target/cuke", "json:target/cuke/cuke.json"},
        features = "classpath:features/",
        tags={"@CukeWorkshop", "~@Ignore"},
        glue = {"cuke.common.steps"})
public class CukeWorkshopTesten {

    private static final Logger logger = LoggerFactory.getLogger(CukeWorkshopTesten.class);

    @BeforeClass
    public static void setUp() {
        logger.info("setUp");
    }

    @AfterClass
    public static void tearDown() {
        logger.info("tearDown");
        BrowserHelper.stopDriver();
    }
}
