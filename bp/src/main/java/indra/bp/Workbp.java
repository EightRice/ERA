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

public class Workbp {
	
	public void act() throws IOException, FileNotFoundException{
<<<<<<< HEAD
		ArrayList<String> catsnames=new ArrayList<String>();
		File excelFile = new File(getClass().getClassLoader().getResource("eradata.xlsx").getFile());
		//File file =new File("lomsa.txt");
	    FileInputStream fis = new FileInputStream(excelFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheetAt(0);
	    CellReference acct = new CellReference("A");
	    CellReference name = new CellReference("B");
	    CellReference stake=new CellReference("C");
	    CellReference location=new CellReference("D");
	    CellReference voters=new CellReference("E");
	    CellReference percent=new CellReference("F");
	    CellReference website=new CellReference("G");
	    CellReference cpu=new CellReference("K");
	    CellReference ram=new CellReference("L");
	    CellReference hdd=new CellReference("M");
	    CellReference apps=new CellReference("S");
	    CellReference articles=new CellReference("V");
	    CellReference conteng=new CellReference("X");
	    CellReference combuild=new CellReference("Z");
	    CellReference twitter=new CellReference("AD");
	    CellReference followers=new CellReference("AC");
	    CellReference telegram=new CellReference("AE");
	    CellReference steemit=new CellReference("AF");
	    CellReference jurisdiction=new CellReference("AG");
	    CellReference backlinks=new CellReference("AI");
	    CellReference team=new CellReference("Q");
	    CellReference activism=new CellReference("AJ");
	    Iterator<Row> rowIT=sheet.iterator();
	    int chiartotal=0;
	    while (rowIT.hasNext()) {
	    	Row row=rowIT.next();
	    	if(row.getRowNum()==0){continue;}
	    	if (row.getRowNum()>=170) {break;}	
//	    	System.out.println("Stringul de parcent" +row.getCell(percent.getCol()).getNumericCellValue());
	    	int eospervote=0;
	    String titlu=row.getCell(name.getCol()).toString();System.out.println("titlu "+titlu);
	    String account=	row.getCell(acct.getCol()).toString();System.out.println("acct "+account);
	    int cash=(int)row.getCell(stake.getCol()).getNumericCellValue();System.out.println("cash "+cash);	
	    Double perc=row.getCell(percent.getCol()).getNumericCellValue();System.out.println("perc "+perc);
	    int votanti=(int)row.getCell(voters.getCol()).getNumericCellValue();System.out.println("votanti "+votanti);
	    if (votanti!=0) {eospervote=cash/votanti;} System.out.println("pervote "+eospervote);
	    String loc=row.getCell(location.getCol()).toString();
	    for (BP bp:Engine.producers) {
	    if (bp.acct.equals(account)) {
	bp.website=row.getCell(website.getCol()).toString();
	bp.infra=(int)(row.getCell(cpu.getCol()).getNumericCellValue());
	bp.dappsTotal=(int)row.getCell(apps.getCol()).getNumericCellValue();
	bp.contentVolume=(int)row.getCell(articles.getCol()).getNumericCellValue();
	bp.contentEng=(int)row.getCell(conteng.getCol()).getNumericCellValue();
	bp.communityBuilding=(int)row.getCell(combuild.getCol()).getNumericCellValue();
	bp.twitter=row.getCell(twitter.getCol()).toString();
	bp.followers=(int)row.getCell(followers.getCol()).getNumericCellValue();
	bp.telegram=row.getCell(telegram.getCol()).toString();
	bp.jurisdiction=(int)row.getCell(jurisdiction.getCol()).getNumericCellValue();
	bp.backlinks=(int)row.getCell(backlinks.getCol()).getNumericCellValue();
	bp.team=(int)row.getCell(team.getCol()).getNumericCellValue();
	bp.name=titlu;
=======
		
		ArrayList<String> catsnames=new ArrayList<String>();
		File excelFile = new File(getClass().getClassLoader().getResource("eradata.xlsx").getFile());
		//File file =new File("lomsa.txt");
	    FileInputStream fis = new FileInputStream(excelFile);
	    XSSFWorkbook workbook = new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheetAt(0);
	    CellReference acct = new CellReference("A");
	    CellReference name = new CellReference("B");
	    CellReference stake=new CellReference("C");
	    CellReference location=new CellReference("D");
	    CellReference voters=new CellReference("E");
	    CellReference percent=new CellReference("F");
	    CellReference website=new CellReference("G");
	    CellReference cpu=new CellReference("K");
	    CellReference ram=new CellReference("L");
	    CellReference hdd=new CellReference("M");
	    CellReference apps=new CellReference("S");
	    CellReference articles=new CellReference("V");
	    CellReference conteng=new CellReference("X");
	    CellReference combuild=new CellReference("Z");
	    CellReference twitter=new CellReference("AD");
	    CellReference followers=new CellReference("AC");
	    CellReference telegram=new CellReference("AE");
	    CellReference steemit=new CellReference("AF");
	    CellReference jurisdiction=new CellReference("AG");
	    CellReference backlinks=new CellReference("AI");
	    CellReference team=new CellReference("Q");
	    CellReference activism=new CellReference("AJ");
	    Iterator<Row> rowIT=sheet.iterator();
	    int chiartotal=0;
	    while (rowIT.hasNext()) {
	    	Row row=rowIT.next();
	    	if(row.getRowNum()==0){continue;}
	    	if (row.getRowNum()>=170) {break;}	
//	    	System.out.println("Stringul de parcent" +row.getCell(percent.getCol()).getNumericCellValue());
	    	int eospervote=0;
	    String titlu=row.getCell(name.getCol()).toString();System.out.println("titlu "+titlu);
	    String account=	row.getCell(acct.getCol()).toString();System.out.println("acct "+account);
	    int cash=(int)row.getCell(stake.getCol()).getNumericCellValue();System.out.println("cash "+cash);	
	    Double perc=row.getCell(percent.getCol()).getNumericCellValue();System.out.println("perc "+perc);
	    int votanti=(int)row.getCell(voters.getCol()).getNumericCellValue();System.out.println("votanti "+votanti);
	    if (votanti!=0) {eospervote=cash/votanti;} System.out.println("pervote "+eospervote);
	    String loc=row.getCell(location.getCol()).toString();
	    for (BP bp:Engine.producers) {
	    if (bp.acct.equals(account)) {
	
	bp.website=row.getCell(website.getCol()).toString();
	bp.infra=(int)(row.getCell(cpu.getCol()).getNumericCellValue());
	bp.dappsTotal=(int)row.getCell(apps.getCol()).getNumericCellValue();
	bp.contentVolume=(int)row.getCell(articles.getCol()).getNumericCellValue();
	bp.contentEng=(int)row.getCell(conteng.getCol()).getNumericCellValue();
	bp.communityBuilding=(int)row.getCell(combuild.getCol()).getNumericCellValue();
	bp.twitter=row.getCell(twitter.getCol()).toString();
	bp.followers=(int)row.getCell(followers.getCol()).getNumericCellValue();
	bp.telegram=row.getCell(telegram.getCol()).toString();
	bp.jurisdiction=(int)row.getCell(jurisdiction.getCol()).getNumericCellValue();
	bp.backlinks=(int)row.getCell(backlinks.getCol()).getNumericCellValue();
	bp.team=(int)row.getCell(team.getCol()).getNumericCellValue();
	bp.name=titlu;
	
>>>>>>> branch 'master' of https://github.com/gsampathkumar/EOS-Electorate-Research-Model.git
System.out.println("twitteru la domn este "+bp.twitter);

	    }
	}
}
	    Engine.chiartotal=chiartotal;
	  
//	   Write write=new Write();
//	   write.write(tickets);
	   
	}
}