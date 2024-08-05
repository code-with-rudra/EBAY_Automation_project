package CAPSTONE_PROJECT.Capstone_Project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EbayReadExcel {

    public List<String> readData(String filePath) throws FileNotFoundException {
        List<String> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(0);

            // Iterate over the cells in the row and add string values to the list
            for (Cell cell : row) {
                if (cell.getCellType() == CellType.STRING) {
                    data.add(cell.getStringCellValue());
                }
            }

           workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
