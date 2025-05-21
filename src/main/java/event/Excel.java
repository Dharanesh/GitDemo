package event;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		System.out.println("aaa");;
		
		File fls = new File("C:\\Users\\I_CRA\\Desktop\\AcceptanceTests_Automation.xlsx");
		FileInputStream fos = new FileInputStream(fls);
		Workbook wb = new  WorkbookFactory().create(fos);
		Sheet sh = wb.getSheetAt(0);
		Row rw = sh.getRow(0);
		Cell cl =rw.getCell(1);
		String c = cl.getStringCellValue();
		System.out.println(c);
	}

}
