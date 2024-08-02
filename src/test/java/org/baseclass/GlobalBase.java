package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalBase {

	public static WebDriver driver;
	public File file;
	public Workbook book;
	public Sheet sheet;
	public Cell cell;
	public Row row;

	
	public void getDriver(String Browser) {
		
		switch (Browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "FireFox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
	

		default:
			System.out.println("Invalid Driver");
		}	
	}
	
	public String readExcel(int rownum,int cellnum) {
		String value=null;
		try {
			 file=new File("H:\\Eclipse Workspace\\SwagLabProject\\Database\\SwagValidation.xlsx");
			
			FileInputStream input =new FileInputStream(file);
			
			  book=new XSSFWorkbook(input);
			
			 sheet = book.getSheet("Validation");
			
			  cell = sheet.getRow(rownum).getCell(cellnum);
			 
			 CellType cellType = cell.getCellType();
			 
			 switch (cellType) {
			case STRING:
				 value = cell.getStringCellValue();
				break;
				
			case NUMERIC:
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf=BigDecimal.valueOf(numericCellValue);
				 value = valueOf.toString();
				break;

			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return value;
		
	}
	
	public void writeExcel(int rownum,int columnnum,String write) {
		try {
			cell = sheet.getRow(rownum).createCell(columnnum);
			
			cell.setCellValue(write);
			
			FileOutputStream out=new FileOutputStream(file);
			
			book.write(out);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void writeExcelNewRow(int rownum,int columnnum,String write) {
		try {
			cell = sheet.createRow(rownum).createCell(columnnum);
			
			cell.setCellValue(write);
			
			FileOutputStream out=new FileOutputStream(file);
			
			book.write(out);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void windowMx() {
		driver.manage().window().maximize();
	}

	public void url(String website) {
		driver.get(website);
	}
	
	public String currentURL() {
		String currentUrl = driver.getCurrentUrl();
		
		return currentUrl;
	}
	
	public void closeWindow() {
		driver.close();
	}

	public void screenshot(String filename) {
		try {
			TakesScreenshot shot=(TakesScreenshot)driver;
			File source=shot.getScreenshotAs(OutputType.FILE);
			File destination=new File("H:\\Eclipse Workspace\\SwagLabProject\\ScreenShot\\"+filename+".png");
			
			FileUtils.copyFile(source, destination);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void load(){
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sendkeys(WebElement element,String user) {
		element.sendKeys(user);
	}
	
	public void clickbutton(WebElement element) {
		element.click();
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
	
	
	
	}
