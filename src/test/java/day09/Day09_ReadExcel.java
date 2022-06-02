package day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day09_ReadExcel {
    //workbook > worksheet > row > cell
    @Test
    public void readExcel() throws IOException {
        String path = "./src/test/java/resources/Capitals.xlsx";

        //open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //open the first worksheet
        /*getSheetAt(0); accepts an integer and is used to get the specific sheet
        to go to 1st sheet use index of 0.
         */
        Sheet sheet1 =workbook.getSheetAt(0);

        //GO to first row
         /*getrow(0); accepts an integer and is used to get the specific sheet
        to go to 1st row use index of 0.
         */
        Row row1 = sheet1.getRow(0);

        //Go to first cell
         /*getSheetAt(0); accepts an integer and is used to get the specific sheet
        to go to 1st cell use index of 0.
         */
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);//COUNRTY

        /* Cell objects can be converted to a string object easility
            We may need to convert to a string if we need to manipulate the data
            such as lowercase, chatAt, length,..*/
        System.out.println(cell1.toString().toLowerCase());

        //Go to the 2nd cell on the first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2);

        //Go to the 2nd row 1st cell and assert if the data eqaul to USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();
        Assert.assertEquals("FAILED","USA",r2c1);

        //Find the number of the row
        /*getLastRowNum() index starts at 0
        Checks the last row that is used
         */
        int numberOfRow = sheet1.getLastRowNum()+1;
        System.out.println(numberOfRow);

        //Find the nmber of used row
        /*getPhysicalNumberOfRows() index starts at 1
        checks the total rows that is used*/
        int numberOfRowUsed = sheet1.getPhysicalNumberOfRows();
        System.out.println(numberOfRowUsed);


        Map<String,String> countryCapitals = new HashMap<>();
        for (int rowNumber = 1; rowNumber < numberOfRow; rowNumber++) {
            String countries = sheet1.getRow(rowNumber).getCell(0).toString();
            //System.out.println(countries);
            String capitals = sheet1.getRow(rowNumber).getCell(1).toString();
            //System.out.println(capitals);
            countryCapitals.put(countries,capitals);
        }
        System.out.println(countryCapitals);


    }



}
