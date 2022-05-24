package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
Create A Class: AmazonDropdown
Create A Method dropdownTest
Go to https://www.amazon.com/
Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
Print the the total number of options in the dropdown
Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
BONUS: Assert if the dropdown is in Alphabetical Order
 */
public class Day05_Homework {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

    }

    @Test
    public void AmazonDropDown() throws InterruptedException {
        //
        WebElement dontChangeButton = driver.findElement(By.xpath("(//span[@class='a-button-inner'])[1]"));
        dontChangeButton.click();

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDown);
        Thread.sleep(3000);

        WebElement firstSelected = select.getFirstSelectedOption();
        System.out.println(firstSelected.getText());
        Assert.assertEquals("Test Failed", "All Departments", firstSelected.getText());

        /*
        Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        (after you select you need to use get first selected option method).
        If it fails, then comment that code out and continue rest of the test case.
         */
        WebElement webElement = select.getOptions().get(3);
        System.out.println(webElement.getText());
        //Assert.assertEquals("FAILED","Amazon Devices",webElementList.getText());

        //Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> webElementList = select.getOptions();
        for (WebElement each : webElementList) {
            System.out.println(each.getText());
        }
        //Print the the total number of options in the dropdown
        int allOptions = webElementList.size();
        System.out.println(allOptions);

        //Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        boolean flag = false;
        for (WebElement appliances : webElementList) {
            if (appliances.getText().equals("Baby")) {
                flag = true;
                System.out.println("Baby");
            }
        }
        Assert.assertTrue(flag);

        //Assert if the dropdown is in Alphabetical Order
        List dropDownOptions = new ArrayList();
        for (WebElement each : webElementList) {
            dropDownOptions.add(each.getText());
        }
        List tempList = new ArrayList(dropDownOptions);
        Collections.sort(tempList);

        Assert.assertEquals(dropDownOptions,tempList);
//        if (dropDownOptions.equals(tempList)) {
//            System.out.println("Alphabetical ordered");
//        } else {
//            System.out.println("Not ordered");
//        }
        driver.quit();
    }
}
