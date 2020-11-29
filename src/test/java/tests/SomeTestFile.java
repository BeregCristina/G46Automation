package tests;

import org.junit.Test;

import static helpers.FileHelper.writeTextToFile;

public class SomeTestFile {

    @Test
    public void checkFile(){
        writeTextToFile("C:\\Users\\khber\\IdeaProjects\\G46Automation\\src\\test\\resources\\data\\out.txt",
                "First line\nSecond line\nThird line\nFirst!");
    }
}
