package page.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	private Workbook testdata = null;
	private Sheet sheet;

	public ExcelUtil() {

		try {
			File file = new File("C:\\Users\\admin\\eclipse-workspace\\DemoWebShop\\Testdata.xlsx");
			FileInputStream inputStream = new FileInputStream(file);
			testdata = new XSSFWorkbook(inputStream);
			sheet = testdata.getSheet("testdata");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ExcelUtil(String sheetName) {
		
		this();
		sheet = testdata.getSheet(sheetName);
		
	}
	
	public int getNumOfRowsWitoutHeader() {
		
		return sheet.getLastRowNum();
	}

	public String getCellValue(String colHeader, int rowNumber) {

		XSSFRow row = (XSSFRow) sheet.getRow(0);
		XSSFRow row1 = (XSSFRow) sheet.getRow(rowNumber - 1);

		for (int j = 0; j < row.getLastCellNum(); j++) {

			if (row.getCell(j).getStringCellValue().equals(colHeader))
				if (row1.getCell(j).getCellType() == CellType.NUMERIC)
					return String.valueOf((long)(row1.getCell(j).getNumericCellValue()));
				else
					return row1.getCell(j).getStringCellValue();
		}
		
		System.out.println("Some problem with excel");
		
		return null;
	}

}
