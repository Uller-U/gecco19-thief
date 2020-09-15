package NLL;

import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;


//Clase para leer distintos formatos de archivos excel
//por ahora solo soporta .xlsx y numeros

public class ReadExcel {
	public double[][] read(String ruta) {
		double[][] map= new double[4][4];
		try {
			File file = new File(ruta);
			FileInputStream fis = new FileInputStream(file);
				
			XSSFWorkbook excelBook = new XSSFWorkbook(fis);
			XSSFSheet hoja = excelBook.getSheetAt(0); //Consiguiendo la 1° hoja
			Iterator<Row> rowItr = hoja.iterator();
			
			
			int i,j=0;
			
			while(rowItr.hasNext() && j < 4) {
				Row row = rowItr.next();
				
				Iterator<Cell> cellItr = row.cellIterator();
				i=0;
				while(cellItr.hasNext() && i < 4) {
					Cell celda = cellItr.next();
					//tu codigo especifico aca
						map[j][i] = (int)celda.getNumericCellValue();
					//y termina aqui
					i+=1;
				}
				j+=1;
			}
			excelBook.close();
		
		}catch(IOException ex){
		    System.err.print(ex.getMessage());
		    ex.printStackTrace();
		    System.exit(1);
		}
		
		return map;
	}
	
	public item[] readItems(String ruta) {
		ArrayList <item> listOfItems = new ArrayList <item>();
		item [] returnList = new item[5];
		
		try {
			item aux = new item();
			File file = new File(ruta);
			FileInputStream fis = new FileInputStream(file);
				
			XSSFWorkbook excelBook = new XSSFWorkbook(fis);
			XSSFSheet hoja = excelBook.getSheetAt(1); //Consiguiendo la 1° hoja
			Iterator<Row> rowItr = hoja.iterator();
			
			while(rowItr.hasNext()) {
				Row row = rowItr.next();
				
				Iterator<Cell> cellItr = row.cellIterator();
				if(cellItr.hasNext()) {
					Cell celda = cellItr.next(); //consige la ciudad donde se encuentra el item i
					aux.setCityId((int)celda.getNumericCellValue()); //guardamos en aux
						
					celda = cellItr.next();//conseguimos peso de el item
					aux.setWeight(celda.getNumericCellValue());//guardamos en aux
						
						
					celda = cellItr.next();//conseguimos valor de el item
					aux.setProfit(celda.getNumericCellValue());//guardamos en aux
							
					listOfItems.add(aux);
					aux = new item();
				}
				
			}
			
			excelBook.close();
			
			for(int i=0;i<5;i++) {
				returnList[i] = listOfItems.get(i);
			}
		
		}catch(IOException ex){
		    System.err.print(ex.getMessage());
		    ex.printStackTrace();
		    System.exit(1);
		}
		
		return returnList;
	}
}
