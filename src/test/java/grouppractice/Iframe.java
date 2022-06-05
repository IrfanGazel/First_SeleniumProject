package grouppractice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Iframe extends TestBase {

    //○ Check whether the “Elemental Selenium” link text is visible then print on the console.

    @Test
    //● Create a method: iframeTest
    public void iframeTest(){
        //● Go to the webpage: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
        //○ “An IFrame containing....” Check the text in enable or not... and print on the console
        WebElement textElement =  driver.findElement(By.tagName("h3"));
        Assert.assertTrue(textElement.isDisplayed());
        //○ Write “Hello World!” inside of the Text Box instead of " Your content goes here."
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//p")).clear();
        driver.findElement(By.xpath("//p")).sendKeys("Hello world!");
        driver.switchTo().defaultContent();

        WebElement textElement2 =  driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        String actual = textElement2.getText();
        String expected = "Elemental Selenium";
        Assert.assertEquals(expected,actual);





    }

}
