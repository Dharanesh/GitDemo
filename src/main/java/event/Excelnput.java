package event;

import java.io.File;
import java.io.FileInputStream;

import action.TestUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import action.BaseTest;

public class Excelnput extends TestUtils
{
/*	private static XSSFSheet ExcelWSheet;
	 
	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;

*/
//  public  ConfigReader config = new ConfigReader();
	
	


	public static FileInputStream fls ;
	 public static Workbook wb ;
	 public static Sheet sh;
	 public static Row rw;
	 public static Cell cel ;



public  String getData(String sheetName, int row, int cell)  
{ 
	

	try  
	{
		fls = new FileInputStream(getData("path1"));
//		fls = new FileInputStream(getData(Data))
		

			wb = WorkbookFactory.create(fls);
			sh = wb.getSheet(sheetName);
			rw = sh.getRow(row);
			cel = rw.getCell(cell);
			String data = cel.getStringCellValue();
			
			
//			DataFormatter formatter = new DataFormatter();			
//			String data = formatter.formatCellValue(sh.getRow(row).getCell(cell));
//		    String data = sh.getRow(row).getCell(cell).getStringCellValue();
		    return data;
  	} 
	 catch (Exception e)
	
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
	public  String getData(String path ,int sheetNumber, int row, int cell)  
	{ 
		

		try  
		{
			fls = new FileInputStream((path));
			

				wb = WorkbookFactory.create(fls);
				sh = wb.getSheetAt(sheetNumber);
			    String data = sh.getRow(row).getCell(cell).getStringCellValue();
			    return data;
	                       	} 
		 catch (Exception e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
}
	



	
//	public static String Retrivedwonloaddata(int row, int cell, String expectResult ) throws Exception
//	{
//		
//	
//		 fls = new FileInputStream(config.getData("downloadPath"));
//		 wb = WorkbookFactory.create(fls);
//		 sh = wb.getSheetAt(0);
//		 rw = sh.getRow(row);
//		 cel = rw.getCell(cell);
//		String cl1= cel.getStringCellValue();
//
//		
//		
//		if(cl1.equals(expectResult))
//		{
//			System.out.println("Report is Matching");
//			System.out.println("Actul Report name = "+Excelnput.getData(0, 1, 3));
//			System.out.println("Download Report Name "+cl1);
//		}
//		else 
//		{
//			System.out.println("Not Matching");
//			System.out.println();
//			
//		}
//		return cl1;
//	}
//	
//
//		
	public  Sheet data (String SheetName) 
	{
//		 
		 try {
			fls = new FileInputStream(getData("setexcelPath"));                                 
			wb = WorkbookFactory.create(fls);
			sh = wb.getSheet("SheetName");
			return sh ;
		} 
		 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			
			return null;
		}
		
		
	}

	
	public  String getdata1(int row ,int cell ) 
	{
		rw = sh.getRow(row);
		Cell cel1l = rw.getCell(cell);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sh.getRow(row).getCell(cell));
		return data;
		
		
	}
	
	public Sheet sheetdata(int sheetnumber)
	{
		
		try {
			fls = new FileInputStream(getData("setexcelPath"));
			                           
			                       
			wb = WorkbookFactory.create(fls);
			sh = wb.getSheetAt(sheetnumber);
			return sh ;
		} 
		 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			System.out.println("aaa");
			
			return null;
		
		
		
	}}

	
	
	

//static String Filepath="E:\\SeleniumFiles\\AutomationCode\\com.cockpit\\src\\com\\cockpit\\data\\TestData.xlsx";
 public  String ExcelDatainput(String sheetname,int RowNum,int ColumnNum) throws Exception
 {
     //String Filepath=config.getData("TExcelFilepath");
     //System.out.println(Filepath);
	 //Adding
	 File FileLoc=new File(getData("path1"));
	 FileInputStream fis=new FileInputStream(FileLoc);
	 Workbook wb=WorkbookFactory.create(fis);
	 Sheet sh=wb.getSheet(sheetname);
	 Row row=sh.getRow(RowNum);
	 Cell cel=row.getCell(ColumnNum);
	 DataFormatter formatter = new DataFormatter();
	 String DataCell = formatter.formatCellValue(cel);
	 //String DataCell=cel.getStringCellValue();
	 return DataCell;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
 }
}
		
		
		
	
	






	
	

