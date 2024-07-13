package framework.tests;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URI;

public class BaseClass {

    AppiumDriver driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            //**Phone**
            desiredCapabilities.setCapability("platformName", "Android");

            //nazwa telefonu
            desiredCapabilities.setCapability("appium:deviceName", "Redmi Note 8 Pro");
            //z komendy adb devices w cmd
            desiredCapabilities.setCapability("appium:udid", "954ds4ofhazpn7i7");
            desiredCapabilities.setCapability("appium:platformVersion", "11 RP1A.200720.011");
            desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
            //**Otwieranie przeglądarki**
            desiredCapabilities.setCapability("appium:browserName", "Chrome");

            URI url = new URI("http://127.0.0.1:4723/");
            driver = new AppiumDriver(url.toURL(), desiredCapabilities);
//            driver = new AndroidDriver(url.toURL(), desiredCapabilities);
//            driver = new IOSDriver(url.toURL(), desiredCapabilities);

        } catch (Exception e) {
            e.getCause();
            e.printStackTrace();
            System.out.println("Error URI");
        }

    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}