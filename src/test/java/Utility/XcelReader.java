package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


  public class XcelReader {

	
	public Object[][] getArrayObject() throws BiffException, IOException {
		String FilePath = System.getProperty("user.dir");
		FileInputStream fs = new FileInputStream(FilePath+"\\src\\test\\resources\\Credentials.xls");
		Workbook wb = Workbook.getWorkbook(fs);

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("Sheet1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
       String obj[][] = new String[totalNoOfRows][totalNoOfCols];
		for (int row = 0; row < totalNoOfRows; row++) {

			for (int col = 0; col < totalNoOfCols; col++) {
				obj[row][col] = sh.getCell(col, row).getContents();
				System.out.print(sh.getCell(col, row).getContents() + "\t");
			}
			System.out.println();
		}
		return obj;
	}


	
	/*public Object[][] getArrayObject() throws IOException
	{
		
		String path = System.getProperty("user.dir");	
		File file = new File(path+"\\src\\test\\resources\\Credentials.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(inputStream);
		Sheet excelsheet = wb.getSheet("Sheet1");
		int rowcount = excelsheet.getLastRowNum() - excelsheet.getFirstRowNum() + 1;
		String[][] arr=new String[rowcount][excelsheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < rowcount; i++) {
			Row row = excelsheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				arr[i][j]=row.getCell(j).getStringCellValue();
				System.out.println(arr[i][j]);
			}

			
		}

		
		return arr;

	}*/

	public static void main(String...s) throws IOException, BiffException
	{
		XcelReader reader = new XcelReader();
		reader.getArrayObject();
	}
	}