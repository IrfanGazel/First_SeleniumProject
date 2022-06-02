package practice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Practice02 extends TestBase {
    @Test
    public void keysUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions.doubleClick(searchBox).sendKeys("iPhone 13 ").perform();
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        Thread.sleep(3000);
    }


}
