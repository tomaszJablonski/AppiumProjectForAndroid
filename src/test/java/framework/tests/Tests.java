package framework.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests extends BaseClass {



//    @Test
    public void sampleTest() {

        driver.get("https://automationstepbystep.com/");
//        driver.findElement(By.xpath("//a[text()='Appium']")).click();
    }

    @Test
    public void loginToOrangeHrm() {
        ExtentTest test = extentReports.createTest("one", "des");
        test.log(Status.INFO,"Loading page");

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        test.log(Status.INFO,"Enter username");

        driver.findElement(By.name("username")).sendKeys("Admin");

        test.log(Status.PASS,"Enter is done");

        test.log(Status.INFO,"Enter Password");

        driver.findElement(By.name("password")).sendKeys("admin123");

        test.log(Status.PASS,"Enter is done");

        driver.findElement(By.name("username")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        test.log(Status.INFO,"Click Login");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='app']/div/div/header/div/div[2]/ul/li/span/i")));
        driver.findElement(By.xpath("//div[@id='app']/div/div/header/div/div[2]/ul/li/span/i")).click();

        test.log(Status.INFO,"Click logout");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        driver.findElement(By.linkText("Logout")).click();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}