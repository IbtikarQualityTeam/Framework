package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderFromExcel 
{

	static FileInputStream fis = null;
// Can use the same code for multiple tabs in the same excel sheet just send each time the index nuber
	public Object[][] GetDataFromExcel(int colNum,int index) throws IOException {

		String filepath = System.getProperty("user.dir") + "//TestData//ExcelFileName.xlsx";
		File src = new File(filepath);
		fis = new FileInputStream(src);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(index);
		int rows = sheet.getLastRowNum()+1;
		int cols = colNum;
		String[][] Excelarr = new String[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				XSSFRow row_sheet = sheet.getRow(row);
				Excelarr[row][col] = row_sheet.getCell(col).toString();
			}
		}
		wb.close();
		return Excelarr;
	}
}
