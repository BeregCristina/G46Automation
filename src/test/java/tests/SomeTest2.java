package tests;

import org.junit.Test;

import java.util.List;

import static helpers.FileHelper.readLinesFromFile;

public class SomeTest2 {

    @Test
    public void checkFile() {
        List<String> data = readLinesFromFile("C:\\Users\\khber\\IdeaProjects\\G46Automation" +
                "\\src\\main\\resources\\log4j2.properties");
        for (String line : data) {
            System.out.println(line);
        }
    }
}
