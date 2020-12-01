package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {

    private final static Logger LOG = LogManager.getLogger("Excel Files processor");

    public static List<String> readColumnFromExcelFile(String path, int columnIndex) {
        List<String> result = new ArrayList<>();
        try {
            Workbook file = new XSSFWorkbook(path);
            Sheet sheet = file.getSheet("Лист1");
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(columnIndex);
                result.add(cell.getStringCellValue());
            }
        } catch (IOException e) {
            LOG.error(e);
        }
        return result;
    }

    public static List<List<String>> readExcelFile(String path, String sheetName) {
        List<List<String>> result = new ArrayList<>();
        try {
            Workbook file = new XSSFWorkbook(path);
            Sheet sheet = file.getSheet("Лист1");
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                List<String> cells =  new ArrayList<>();
                for (int a = 0; a<row.getLastCellNum(); a++){
                    Cell cell = row.getCell(a);
                    cells.add(cell.getStringCellValue());
                }
                result.add(cells);
            }
        } catch (IOException e) {
            LOG.error(e);
        }
        return result;
    }

    public static void writeToExcelFile(String path, List<String> data, String sheetName, int columnIndex) {
        try {
            Workbook file = new XSSFWorkbook(path);
            Sheet sheet = file.createSheet(sheetName);

            for (int i = 0; i < data.size(); i++) {
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(columnIndex);
                cell.setCellValue(data.get(i));
            }
            file.write(new FileOutputStream(new File("C:\\Users\\khber\\IdeaProjects\\G46Automation" +
                    "\\src\\test\\resources\\data\\out1.txt")));
            file.close();
        } catch (IOException e) {
            LOG.error(e);
        }
    }

}
