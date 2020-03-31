package utilityFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {
	 public Map<String, String> getData(String workbookPath, String sheetName){
		Map<String, String> data = new HashMap<String, String>();
		List<String> headerList = new ArrayList<String>();
		List<String> dataList = new ArrayList<String>();
		
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(workbookPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		Row headerRow = sheet.getRow(0);
		Iterator<Cell> headerCells = headerRow.iterator();
		while(headerCells.hasNext()) {
			DataFormatter df = new DataFormatter();
			String cellvalue = df.formatCellValue(headerCells.next());
			headerList.add(cellvalue);
		}
		
		Row dataRow = sheet.getRow(1);
		Iterator<Cell> dataCells = dataRow.iterator();
		while(dataCells.hasNext()) {
			DataFormatter df = new DataFormatter();
			String cellvalue = df.formatCellValue(dataCells.next());
			dataList.add(cellvalue);
		}
		
		for(int i=0; i<headerList.size(); i++) {
			data.put(headerList.get(i), dataList.get(i));
		}
		
		return data;
		
	}
}
