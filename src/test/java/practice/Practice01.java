package practice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Practice01 extends TestBase {
    @Test
    public void hoverOver() {
        driver.get("https://www.amazon.com/");
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        driver.findElement(By.linkText("Account")).click();
        Assert.assertTrue(driver.getTitle().contains("Your Account"));
    }
}


