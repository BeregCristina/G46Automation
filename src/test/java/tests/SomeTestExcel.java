package tests;

import org.junit.Test;

import static helpers.ExcelHelper.readColumnFromExcelFile;
import static helpers.ExcelHelper.readExcelFile;

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
}
