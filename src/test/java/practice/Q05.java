package practice;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q05 extends TestBase {


    //go to https://the-internet.herokuapp.com/add_remove_elements/
    @Test
    public void addDeletebutoon() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        createButton(100);
        deleteButton(50);
        int actual = driver.findElements(By.xpath("//button[@onclick='deleteElement()']")).size();
        int expected = 50;
        Assert.assertEquals(expected, actual);
    }

    //write a method that takes a number and click on the "Delete" button that many times
    void deleteButton(int deletenumber) {
        for (int i = 0; i < deletenumber; i++) {
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        }

    }
    //click on the "Add Element" button 100 times
    void createButton(int number) {
        for (int i = 0; i < number; i++) {
            driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        }
    }

}


//verify the given number of elements are deleted

