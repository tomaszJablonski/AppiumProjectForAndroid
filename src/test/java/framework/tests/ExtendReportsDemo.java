package framework.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtendReportsDemo {

    ExtentSparkReporter sparkReporter;
    ExtentReports extentReports;

    @BeforeSuite
    public void reportSetup() {
        sparkReporter = new ExtentSparkReporter("report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void reportTearDown() {
        extentReports.flush();
    }
}
