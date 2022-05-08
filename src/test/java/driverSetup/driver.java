package driverSetup;

import com.microsoft.playwright.*;

public class driver {
    public static Page page;
    public static Browser browser;
    public static BrowserContext context;

    public static void closeDriver(){
        browser.close();
    }

    public static void startDriver() {
        try {
            Playwright playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false) // to follow the test in browser uncomment this line
                    //.setSlowMo(2000) // slow down the test by 2 seconds
                    .setTimeout(20000) // timeout in milliseconds
            );
            context = browser.newContext();
            page = context.newPage();
        } catch (Exception e) {
            System.out.println("Something went wrong with driverSetup.");
            System.out.println("\n" + e);
        }
    }
}
