package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import projectSpecifications.BaseClass;
 
public class ExcelReader extends BaseClass {

    @Test
    public static String[][] readexcelData(String excelfilename, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(excelfilename);
        XSSFWorkbook book = new XSSFWorkbook(file);
        XSSFSheet sheet = book.getSheet(sheetName);

        int rownum = sheet.getLastRowNum();
        int cellnum = sheet.getRow(0).getLastCellNum();

        String[][] data = new String[rownum][cellnum];
        DataFormatter formatter = new DataFormatter(); // ✅ Handles String & Numeric both

        for (int i = 1; i <= rownum; i++) {
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < cellnum; j++) {
                if (row != null && row.getCell(j) != null) {
                    data[i - 1][j] = formatter.formatCellValue(row.getCell(j)); // ✅ Safe for all cell types
                } else {
                    data[i - 1][j] = ""; // ✅ Empty if null
                }
            }
        }

        book.close();
        return data;
    }
}
