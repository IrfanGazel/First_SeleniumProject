package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_ImplicitWait {

    @Test
    public void implicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // implicit wait for 30 seconds
        /*
         implicit wait puts dynamic meaning wait will be depends n the page speed
         */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @Test
    public void threadSleep() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        // implicit wait for 30 seconds
        /*
         implicit wait puts dynamic meaning wait will be depends n the page speed
         */
        Thread.sleep(30000);
    }

}
