package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day12_JSExecutor2 extends TestBase {

    @Test
    public void jsExecuterTest() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);

        // scroll to our room
        scrollIntoViewByJS(driver.findElement(By.xpath("//*[.='Our Rooms']")));


    }








}
