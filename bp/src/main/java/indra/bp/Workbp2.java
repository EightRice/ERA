package indra.bp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.formula.functions.Column;import org.apache.poi.ss.formula.functions.NumericFunction;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import server.Engine;

public class Workbp2 {
	
	public void act() throws IOException, FileNotFoundException{
		
		ArrayList<String> catsnames=new ArrayList<String>();
		File excelFile = new File(getClass().getClassLoader().getResource("eradata.xlsx").getFile());
		//File file =new File("lomsa.txt");
	    FileInputStream fis = new FileInputStream(excelFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheetAt(2);
	    CellReference acct = new CellReference("D");
	    CellReference location = new CellReference("E");
	    CellReference stake=new CellReference("F");
	    CellReference votesnr=new CellReference("G");
	    CellReference eospevote=new CellReference("H");
	    CellReference procent=new CellReference("I");
	    Iterator<Row> rowIT=sheet.iterator();
	    int chiartotal=0;
	    while (rowIT.hasNext()) {
	    	Row row=rowIT.next();
	    	if(row.getRowNum()==0){continue;}
	    	if (row.getRowNum()>=170) {break;}	
//	    	System.out.println("Stringul de parcent" +row.getCell(percent.getCol()).getNumericCellValue());
	    	int eospervote=0;
	     String account=row.getCell(acct.getCol()).toString();System.out.println("acct "+account);
	     String loc=row.getCell(location.getCol()).toString();
	     String eos=row.getCell(stake.getCol()).toString();
	     int votes=(int)row.getCell(votesnr.getCol()).getNumericCellValue();
	     int coinpervote=(int)row.getCell(eospevote.getCol()).getNumericCellValue();
	     String percent=row.getCell(procent.getCol()).toString(); 
	     
	BP bp=new BP(account, loc, eos, votes, coinpervote, percent);
	bp.rank=row.getRowNum()+1;
System.out.println("twitteru la domn este "+bp.twitter);

Engine.producers.add(bp);
	    	
	    }
	    Engine.chiartotal=chiartotal;
	  
//	   Write write=new Write();
//	   write.write(tickets);
	   
	}
}