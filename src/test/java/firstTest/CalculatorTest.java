package firstTest;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class CalculatorTest {

    public static AppiumDriver driver;

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //**Phone**
        desiredCapabilities.setCapability("platformName", "Android");

        //nazwa telefonu
        desiredCapabilities.setCapability("appium:deviceName", "Redmi Note 8 Pro");
        //z komendy adb devices w cmd
        desiredCapabilities.setCapability("appium:udid", "954ds4ofhazpn7i7");
        desiredCapabilities.setCapability("appium:platformVersion", "11 RP1A.200720.011");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        //**App Calculator**
        desiredCapabilities.setCapability("appium:appPackage", "com.miui.calculator");
        desiredCapabilities.setCapability("appium:appActivity", "com.miui.calculator.cal.DefaultCalculatorActivity");

        return desiredCapabilities;
    }

    public static void main(String[] args) {
        try {
            openCalculator();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.out.println("Error");
        }
    }

    public static void openCalculator() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities desiredCapabilities = getDesiredCapabilities();


        URI url = new URI("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url.toURL(), desiredCapabilities);

        System.out.println("Application Started...");
        WebElement nine = driver.findElement(By.id("com.miui.calculator:id/btn_9_s"));
        nine.click();
        WebElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
        plus.click();
        WebElement one = driver.findElement(By.id("com.miui.calculator:id/btn_1_s"));
        one.click();
        WebElement equals = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
        equals.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement ten = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.miui.calculator:id/result")));
        String tenText = ten.getText();

        System.out.println("tenText :  " + tenText);
        Assert.assertEquals("= 10", tenText);

    }



}
