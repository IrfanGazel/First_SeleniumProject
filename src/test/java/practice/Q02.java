package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {
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
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.navigate().to("https://www.amazon.com/");
        //get title of the page
        String pageTitle = driver.getTitle();
        String amazonURL = driver.getCurrentUrl();
        // Check if the title contains the word "oto" print console "Title contains oto" or "Title does not contain oto"
        if (pageTitle.contains("oto")) {
            System.out.println("Title contains oto");
        } else {
            System.out.println("Title does not contain oto");
        }
        // Check if the URL contains the word "auto" print console "URL contains auto" or "URL does not contain auto"
        if (amazonURL.contains("auto")) {
            System.out.println("URL contains auto");
        } else {
            System.out.println("URL does not contain auto");
        }
        // Then go to "https://www.gittigidiyor.com"
        driver.get("https://www.gittigidiyor.com");
// Get the title and check if it contains the word "site" and print "Title contains site" or "Title does not contain site"
        String gittiGidiyorTitle = driver.getTitle();
        if (gittiGidiyorTitle.contains("site")) {
            System.out.println("Title contains site");
        } else {
            System.out.println("Title does not contain site");
        }
        // Back to the previous webpage, https://www.amazon.com"
        driver.navigate().back(); // amazon

        // Refresh the page
        driver.navigate().refresh();//refresh

        // Navigate to gittigidiyor.com
        driver.navigate().forward();

        // Wait for 3 seconds
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit();

    }
}
