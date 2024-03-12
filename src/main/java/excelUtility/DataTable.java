package excelUtility;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTable {

    String path;
    Workbook wb;
    Sheet sheet;
    FileInputStream fis;
    File file;
    public DataTable(String path){
        this.path = path;
    }

    public void createConnection() throws IOException {
       file = new File(path);
       fis= new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
    }

    public String getData(String rowName,String colName) throws Exception {
        int rowNum = -1,colNum=-1;
        int totalRows = sheet.getLastRowNum();//0-2
        System.out.println("Row size: "+totalRows);
        for(int i=0;i<=totalRows;i++){
            if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals(rowName)){
                rowNum = i;
                System.out.println("rowNum: " +rowNum);
                break;
            }
        }
        System.out.println("Cell size: " +sheet.getRow(0).getPhysicalNumberOfCells() );
        for(int j=0;j<sheet.getRow(0).getPhysicalNumberOfCells();j++){
            if(sheet.getRow(0).getCell(j).getStringCellValue().trim().equals(colName)){
                colNum = j;
                System.out.println("colNum: " + colNum);
                break;
            }
        }
        if(rowNum==-1 || colNum == -1){
            throw new Exception("Row Num or Col Num match is not found");
        }
        String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        fis.close();
return data;

    }

    public void updateStatus(String rowName, boolean status) throws IOException {
        int rowNum = -1,colNum=3;
        int totalRows = sheet.getLastRowNum();//0-2
        System.out.println("Row size: "+totalRows);
        for(int i=0;i<=totalRows;i++){
            if(sheet.getRow(i).getCell(0).getStringCellValue().trim().equals(rowName)){
                rowNum = i;
                break;
            }
        }

        FileOutputStream fos = new FileOutputStream(path);
        sheet.getRow(rowNum).createCell(colNum).setCellValue(status);
        wb.write(fos);
        fos.close();fis.close();
    }
}
