package practice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Practice03 extends TestBase {
    /*Create a class:Synchronization2.
Create a method: synchronization2
Go to https://the-internet.herokuapp.com/dynamic_loading/2
When user clicks on the Start button
Then verify the ‘Hello World!’ Shows up on the screen*/

    @Test
    public void synchronization2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.cssSelector("#start > button")).click();
        String message = driver.findElement(By.cssSelector("#finish > h4")).getText();
        Assert.assertTrue(message.contains("Hello World!"));
    }

}
