package acd;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class InputDataProvider {
	//public static Object[][] getSheet(String dataSheetName, String sheetName) {
		public static Object[][] getSheet(String dataSheetName, String sheetName) {
			Object[][] data = null ;
	       // Workbook workbook = null;
			try {
				String userDir = System.getProperty("user.dir");
				XSSFWorkbook workbook = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
				Sheet sheet = workbook.getSheet(sheetName);
				//XSSFSheet sheet = workbook.getSheetAt(0);	

				// get the number of rows
				int rowCount = sheet.getLastRowNum();
					

				// get the number of columns
				int columnCount = sheet.getRow(0).getLastCellNum();
				System.out.println("Row count : "+rowCount+" Column count : "+columnCount); 
				data = new String[rowCount][columnCount];

				// loop through the rows
				for(int i=1; i <rowCount+1; i++){
					try {
						Row row = sheet.getRow(i);
						for(int j=0; j <columnCount; j++){ // loop through the columns
							try {
								String cellValue = "";
								long numValue ;
								try{
									CellType cellType =row.getCell(j).getCellType();
									if(cellType == CellType.STRING) {
									cellValue = row.getCell(j).getStringCellValue();
									data[i-1][j]  = cellValue; // add to the data array
									System.out.println(cellValue);
									} else if(cellType == CellType.NUMERIC) {
									numValue = (long) row.getCell(j).getNumericCellValue();
									data[i-1][j]  = numValue; // add to the data array
									//System.out.println(numValue); 
									}else if(cellType == CellType.FORMULA) {
										cellValue =  row.getCell(j).getCellFormula(); 
										data[i-1][j]  = cellValue; // add to the data array
										//System.out.println(cellValue);  
										}
								}catch(NullPointerException e){

								}

							} catch (Exception e) {
	 							e.printStackTrace();
							}				
						}

					} catch (Exception e) {
	 					e.printStackTrace();
					}
				}
				//fis.close();
				workbook.close();
			} catch (Exception e) {
	 			e.printStackTrace();
			}
			
			return data;		

		}
}
