import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;
import com.sun.rowset.internal.Row;

public class testSample {


	public static void main(String[] args) throws IOException
	{
		dataDriven d=new dataDriven();
		
		ArrayList<String> a= d.getData("AddProfile");
		System.out.println(a.get(0));
		System.out.println(a.get(1));System.out.println(a.get(2));System.out.println(a.get(3));
	}
	
	
	
		
}
