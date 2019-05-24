/**
 * 
 */
package com.first;

import java.io.FileInputStream;
import java.io.IOException;

import com.util.FolderPaths;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author lavanya Jan 18, 2019
 */
public class ReadFromExcel {

	public void readExcel() throws BiffException, IOException {
		String filePath = FolderPaths.excelPath;
		FileInputStream fs = new FileInputStream(filePath+"Credentials.xls");
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();

		for (int row = 0; row < totalNoOfRows; row++) {

			for (int col = 0; col < totalNoOfCols; col++) {
				System.out.print(sh.getCell(col, row).getContents() + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) throws BiffException, IOException {
		ReadFromExcel DT = new ReadFromExcel();
		DT.readExcel();
	}

}
