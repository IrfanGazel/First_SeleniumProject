package day01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Homework1 {
    public static void main(String[] args) {
        //    Create a new class : Homework1
//    Using ChromeDriver, Go to facebook and verify if page title is "facebook", If not, print the correct title.
//    Verify if the page URL contains facebook  if not, print the right url.
//    Then Navigate to https://www.walmart.com/
//    Verify if the walmart page title includes "Walmart.com"
//    Navigate back to facebook
//    Refresh the page
//    Maximize the window
//    Close the browser

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        String pageTitle = driver.getTitle();
        if (pageTitle.contains("facebook")) {
            System.out.println("Page title is correct");


        } else {
            System.out.println("Your query failed,you should look for 'Facebook'");
        }
        driver.close();

        driver = new ChromeDriver();
        driver.get("https://www.walmart.com/");
        String pageTitle2 = driver.getTitle();
        if (pageTitle2.contains("Walmart.com")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
        driver.close();

        //opening a new tab and navigate between tabs
        driver = new ChromeDriver();
        driver.get("http://yahoo.com");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://google.com");
        driver.switchTo().window(tabs.get(0));


    }
}
