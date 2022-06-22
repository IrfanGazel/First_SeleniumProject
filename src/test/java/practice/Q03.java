package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        //fill the first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");
        //fill the last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Doe");
        //check the gender
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();


        //check the experience
        driver.findElement(By.xpath("//input[@id='exp-2']")).click();
        //fill the date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("15.05.2022");
        //choose your profession -> Automation Tester
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        //choose your tool -> Selenium Webdriver
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        //choose your continent -> Antarctica
        driver.findElement(By.xpath("//select[@id='continents']")).sendKeys("Antarctica");

        //choose your command  -> Browser Commands
        driver.findElement(By.xpath("(//option[@style='margin: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;'])[8]")).click();

        Thread.sleep(5000);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
