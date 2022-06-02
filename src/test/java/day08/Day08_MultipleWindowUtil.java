package day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Day08_MultipleWindowUtil extends TestBase {
    @Test
    public void multipleWindow(){
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

        switchToTargetWindow("New Window");

        Assert.assertEquals("Failed","New Window",driver.getTitle());
    }
}
