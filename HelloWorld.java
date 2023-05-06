import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class HelloWorld {

	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
				
		System.out.println("Hello World");
		String filename = "C:\\Brindha\\Excel reading Data.xlsx";
		System.out.println(filename);
		File file = new File(filename);
		FileInputStream fis = new FileInputStream(file);
		// Create a excel workbook from the file stream
				Workbook wb = WorkbookFactory.create(fis);
				
				// Get the sheet within the workbook we are interested in.
				org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("sheet1");
				
				// Read rows and columns from the sheet
				int rowsCount  =  sheet.getLastRowNum() + 1;
				Row row0 = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(0);
				int columnsCount = row0.getLastCellNum();
				System.out.println(rowsCount);
				System.out.println(columnsCount);
				
				DataFormatter formatter = new DataFormatter();
				
				String[][] testData = new String[rowsCount][columnsCount];
				
				for(int i = 0; i < rowsCount ; i++){
					for(int j = 0 ; j < columnsCount ; j++)	{
						
						testData[i][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
						
						System.out.println(testData[i][j]);
					}
				}
	}
}

	
