package cucumberHooks;

import com.microsoft.playwright.Page;
import driverSetup.driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.nio.file.Paths;

public class Hooks {
    @Before
    public void doSomethingBefore() {
        //System.out.println(" -- Starting before -- ");
        driver.startDriver();
    }

    @After
    public void doSomethingAfter(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            final byte[] screenshot = driver.page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get(screenshotName + ".png"))
                    .setFullPage(true));
            scenario.attach(screenshot, "image/png", screenshotName+"_error.png");
        }
        driver.closeDriver();
    }
}
