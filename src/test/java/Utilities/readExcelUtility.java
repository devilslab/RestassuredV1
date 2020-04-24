package Utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

public class readExcelUtility {





	@Test
	public static int getRowNum(String filePath ,String Sheet )
	{
		int rowCount = 0;
		try
		{
			FileInputStream	istream = new FileInputStream(filePath);
			HSSFWorkbook workBook = new  HSSFWorkbook(istream);
			HSSFSheet sheet = workBook.getSheet(Sheet);
			rowCount = sheet.getLastRowNum();;
			//Closing inputstream//
			istream.close();
			//Closing Workbook//
			workBook.close();
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		return(rowCount);


	}

	@Test
	public static int getColnum(String filePath ,String Sheet , int rowNum)
	{
		int colCount =0 ;
		try
		{
			FileInputStream	istream = new FileInputStream(filePath);
			HSSFWorkbook workBook = new  HSSFWorkbook(istream);
			HSSFSheet sheet = workBook.getSheet(Sheet);
			Row row = sheet.getRow(rowNum);
			colCount = row.getLastCellNum();

			//Closing inputstream//
			istream.close();
			//Closing Workbook//
			workBook.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();

		}
		return(colCount);
	}


	/* Function to read data from excel data sheet
	 * 
	 */
	@Test
	public static  String readData(String filePath ,String Sheet, int rowNum , int colnum )
	{
		String data = null;
		try
		{
			FileInputStream	istream = new FileInputStream(filePath);
			HSSFWorkbook workBook = new  HSSFWorkbook(istream);
			HSSFSheet sheet = workBook.getSheet(Sheet);

			data = sheet.getRow(rowNum).getCell(colnum).toString();
			//Closing inputstream//
			istream.close();
			//Closing Workbook//
			workBook.close();

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();

		}
		return(data);


	}







}
