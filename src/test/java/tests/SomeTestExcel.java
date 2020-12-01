package tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static helpers.ExcelHelper.*;

public class SomeTestExcel {

    @Test
    public void checkFile2() {
        System.out.println(readColumnFromExcelFile("C:\\Users\\khber\\IdeaProjects\\G46Automation" +
                "\\src\\test\\resources\\data\\TestExcelFile.xlsx", 0));
    }

    @Test
    public void checkFile3() {
        readExcelFile("C:\\Users\\khber\\IdeaProjects\\G46Automation\\src" +
                "\\test\\resources\\data\\TestExcelFile4.xlsx", "Лист1").forEach(System.out::println);
    }

    //@Test
    public void writeToExcelTest() {
        List<String> testData = new ArrayList<>();
        testData.add("One");
        testData.add("Two");
        testData.add("Three");
        testData.add("Four");
        testData.add("Five");

        writeToExcelFile("C:\\Users\\khber\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\EmptyExcelFile.xlsx",
                testData, "New sheet", 1);
    }
}
