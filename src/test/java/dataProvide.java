import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {
	
	
	DataFormatter dataFormat=new DataFormatter();
	@Test(dataProvider = "getData")
	public void testCaseData(String name,String surname,String rollNo)
	{
		System.out.println(name+surname+rollNo);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		//Object[][] data={{"Ajay","Vaishnav",1},{"Pankaj","Shukla",2}};
		//return data;
		
		FileInputStream fis=new FileInputStream("C:\\Users\\dell\\Pankaj Shukla\\excelDriven.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheetAt(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row= sheet.getRow(0);
		int columnCount =row.getLastCellNum();
		Object data[][]=new Object[rowCount-1][columnCount];
		for(int i=0;i<rowCount-1;i++)
		{
			row=sheet.getRow(i+1);
			for(int j=0;j<columnCount;j++)
			{
				XSSFCell cell=row.getCell(j);
		
				data[i][j]=dataFormat.formatCellValue(cell);
			}
		}
		return data;
		
		
		
		
	}

}
