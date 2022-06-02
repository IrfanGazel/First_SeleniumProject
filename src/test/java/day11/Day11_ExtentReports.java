package day11;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myfirstproject.utilities.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day11_ExtentReports extends TestBase {

    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;

    @Test
    public void extentReportTest() {
        //Report PATH= creates the html report right under test-output
        String currentDate = new SimpleDateFormat(("yyyyMMddhhmmss")).format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/report/" + currentDate + "test_report.html";

        //Create html reporter using the path
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //Create extent report
        extentReports = new ExtentReports();

        //Add custom information
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Application", "TechProEd");
        extentReports.setSystemInfo("SQA", "John");
        extentHtmlReporter.config().setDocumentTitle("TechProEd BlueCar");
        extentHtmlReporter.config().setReportName("TechProEd Extent Report");

        //Attach html and extent reports
        extentReports.attachReporter(extentHtmlReporter);

        //Report is complete. Now we just need to create test using extentTest object
        extentTest = extentReports.createTest("My Project Extent Report", "This is for smoke test report");

        //Done with configuration......

       //logging in and
        extentTest.info("User goes to google home page");
        driver.get("https://www.google.com");

        extentTest.info("User searches for Cybertruck release date");
        driver.findElement(By.name("q")).sendKeys("Tesla Cybertruck release date");


        //Generate report and Ending report
        extentReports.flush();


    }


}
