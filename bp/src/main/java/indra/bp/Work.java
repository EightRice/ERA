package indra.bp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vaadin.server.ClassResource;

import server.Engine;

public class Work {
	
	
	public void act() throws IOException, FileNotFoundException{
		System.out.println("ceva pe aici este null " +getClass().getClassLoader().getResource("eradata.xlsx").getFile()
				);

		File excelFile = new File(getClass().getClassLoader().getResource("eradata.xlsx").getFile());
		System.out.println("path is  "+excelFile.getCanonicalPath());
//		File excelFile = new File(getClass().getClassLoader().getResource("voters.xlsx").getFile());
		System.out.println("avem ceva de genu "
				+Vedere.class.getProtectionDomain().getCodeSource().getLocation().getPath());
<<<<<<< HEAD
	    FileInputStream fis = new FileInputStream(excelFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheetAt(1);
	    CellReference name = new CellReference("B");
	    CellReference stake=new CellReference("C");
	    CellReference proxi=new CellReference("D");
	    CellReference pick1=new CellReference("E");
	    CellReference pick2=new CellReference("F");
	    CellReference pick3=new CellReference("G");
	    CellReference pick4=new CellReference("H");
	    CellReference pick5=new CellReference("I");
	    CellReference pick6=new CellReference("J");
	    CellReference pick7=new CellReference("K");
	    CellReference pick8=new CellReference("L");
	    CellReference pick9=new CellReference("M");
	    CellReference pick10=new CellReference("N");
	    CellReference pick11=new CellReference("O");
	    CellReference pick12=new CellReference("P");
	    CellReference pick13=new CellReference("Q");
	    CellReference pick14=new CellReference("R");
	    CellReference pick15=new CellReference("S");
	    CellReference pick16=new CellReference("T");
	    CellReference pick17=new CellReference("U");
	    CellReference pick18=new CellReference("V");
	    CellReference pick19=new CellReference("W");
	    CellReference pick20=new CellReference("X");
	    CellReference pick21=new CellReference("Y");
	    CellReference pick22=new CellReference("Z");
	    CellReference pick23=new CellReference("AA");
	    CellReference pick24=new CellReference("AB");
	    CellReference pick25=new CellReference("AC");
	    CellReference pick26=new CellReference("AD");
	    CellReference pick27=new CellReference("AE");
	    CellReference pick28=new CellReference("AF");
	    CellReference pick29=new CellReference("AG");
	    CellReference pick30=new CellReference("AH");
	    Iterator<Row> rowIT=sheet.iterator();
	    int chiartotal=0;
	    while (rowIT.hasNext()) {
	    	Row row=rowIT.next();if(row.getRowNum()==0){continue;}
	    	String cont=row.getCell(name.getCol()).toString();
	    	String proxy="";
	    	proxy=row.getCell(proxi.getCol()).toString();
	    	int money=(int)row.getCell(stake.getCol()).getNumericCellValue();
	    	ArrayList<String> aprobati=new ArrayList<String>();
	    	for (int i=4;i<34;i++) {
	    		Cell cell=CellUtil.getCell(row, i);
	    		String cezice=cell.toString();
	    		if(!cezice.equals("0.0")) {aprobati.add(cezice);}}
	    	Stakeholder stk=new Stakeholder(cont, aprobati, proxy, money);
	    	Engine.stakeholders.add(stk);
	    	chiartotal=chiartotal+money;
=======

	    FileInputStream fis = new FileInputStream(excelFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheetAt(1);
	    CellReference name = new CellReference("B");
	    CellReference stake=new CellReference("C");
	    CellReference proxi=new CellReference("D");
	    CellReference pick1=new CellReference("E");
	    CellReference pick2=new CellReference("F");
	    CellReference pick3=new CellReference("G");
	    CellReference pick4=new CellReference("H");
	    CellReference pick5=new CellReference("I");
	    CellReference pick6=new CellReference("J");
	    CellReference pick7=new CellReference("K");
	    CellReference pick8=new CellReference("L");
	    CellReference pick9=new CellReference("M");
	    CellReference pick10=new CellReference("N");
	    CellReference pick11=new CellReference("O");
	    CellReference pick12=new CellReference("P");
	    CellReference pick13=new CellReference("Q");
	    CellReference pick14=new CellReference("R");
	    CellReference pick15=new CellReference("S");
	    CellReference pick16=new CellReference("T");
	    CellReference pick17=new CellReference("U");
	    CellReference pick18=new CellReference("V");
	    CellReference pick19=new CellReference("W");
	    CellReference pick20=new CellReference("X");
	    CellReference pick21=new CellReference("Y");
	    CellReference pick22=new CellReference("Z");
	    CellReference pick23=new CellReference("AA");
	    CellReference pick24=new CellReference("AB");
	    CellReference pick25=new CellReference("AC");
	    CellReference pick26=new CellReference("AD");
	    CellReference pick27=new CellReference("AE");
	    CellReference pick28=new CellReference("AF");
	    CellReference pick29=new CellReference("AG");
	    CellReference pick30=new CellReference("AH");
	    Iterator<Row> rowIT=sheet.iterator();
	    int chiartotal=0;
	    while (rowIT.hasNext()) {
	    	Row row=rowIT.next();if(row.getRowNum()==0){continue;}
	    	String cont=row.getCell(name.getCol()).toString();
	    	String proxy="";
	    	proxy=row.getCell(proxi.getCol()).toString();
	    	int money=(int)row.getCell(stake.getCol()).getNumericCellValue();
	    	ArrayList<String> aprobati=new ArrayList<String>();
	    	for (int i=4;i<34;i++) {
	    		Cell cell=CellUtil.getCell(row, i);
	    		String cezice=cell.toString();
	    		if(!cezice.equals("0.0")) {aprobati.add(cezice);}}
	    	Stakeholder stk=new Stakeholder(cont, aprobati, proxy, money);
	    	Engine.stakeholders.add(stk);
	    	chiartotal=chiartotal+money;
	    		
>>>>>>> branch 'master' of https://github.com/gsampathkumar/EOS-Electorate-Research-Model.git
	    }
	    Engine.chiartotal=chiartotal;
//	   Write write=new Write();
//	   write.write(tickets);
	   
	}
	
	
}