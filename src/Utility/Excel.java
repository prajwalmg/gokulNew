package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static File src;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook work;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	// reading excel
	public String readExcel(String xlPath, String sheetName, int RowNum, int column) {

		try {
			fis = new FileInputStream(xlPath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			work = new XSSFWorkbook(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sheet = work.getSheet(sheetName);
		row = sheet.getRow(RowNum);
		cell = row.getCell(column);

		String s1 = null;
		if (cell.getCellType() == CellType.STRING) {
			s1 = cell.getStringCellValue();
			try {
				work.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		else if (cell.getCellType() == CellType.NUMERIC) {
			int v = (int) cell.getNumericCellValue();
			s1 = String.valueOf(v);
			try {
				work.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return s1;
	}

}
