package com.Zhara;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Zhara.Util.Constant;
import com.Zhara.Util.Excel;
import com.Zhara.PageObject.BasePageObject;

public class CreateReservation {
	public static class setUp {

		static WebDriver driver;

		@BeforeClass
		public void setBaseURL() {
			// Configure Log file
			DOMConfigurator.configure("log4j.xml");

			try {
				Excel.setExcelFile(Constant.Path_TestData, "Sheet1");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get((Excel.getCellData(13, 1)));
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}
		}

		@Test
		public static void setLogin() throws InterruptedException {

			String mainWindow = driver.getWindowHandle();
			Set<String> childWindows = driver.getWindowHandles();
			Iterator<String> nextWindow = childWindows.iterator();

			while (nextWindow.hasNext()) {
				String next = nextWindow.next();
				if (!mainWindow.equalsIgnoreCase(next)) {
					driver.switchTo().window(next);
					System.out.println(driver.getTitle());

				}
			}
			// Login
			try {

				String userName = Excel.getCellData(0, 0);

				String password = Excel.getCellData(0, 1);

				Thread.sleep(2000);
				driver.findElement(By.id("j_username")).sendKeys(userName);
				Thread.sleep(2000);
				driver.findElement(By.id("j_password")).sendKeys(password);
				Thread.sleep(2000);
				driver.findElement(By.id("btnLogin")).click();
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// naviagte to Reservations tab
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//div[@class='menuTopBar']/../div/nobr[text()='Reservations']")).click();
			driver.switchTo().defaultContent();// clear using default frame
			driver.switchTo().frame(1);

			// select create reservations html/body/div[8]/div[7]/nobr
			driver.findElement(By.xpath("//div[@class='menuBar']/../div/nobr[text()='Create Reservation']")).click();

			// Select hotel name from dropdown
			try {
				driver.switchTo().frame("frmTabmenu_spnTabMenus_0");
				Thread.sleep(2000);
				Select dropDownHotelName = new Select(driver.findElement(By.id("selHotel")));
				// dropDownHotelName.selectByVisibleText(Excel.getCellData(1,
				// 1));
				dropDownHotelName.selectByValue("298");
				Thread.sleep(2000);
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// **********************Reservation details
			// -Search***********************************************************
			// select title from the drop down
			try {

				Select dropDownTitle = new Select(driver.findElement(By.name("partnerRates.title")));
				dropDownTitle.selectByValue(Excel.getCellData(2, 1));
			} catch (Exception e) {
				
				String message = null;
				Log.error( message, e);
			}

			// FirstName
			try {

				driver.findElement(By
						.xpath("html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[2]/input"))
						.sendKeys(Excel.getCellData(3, 1));
			} catch (Exception e) {
				System.out.println("Error occured!");
				System.out.println(e);
			}

			// LastName
			try {

				driver.findElement(By
						.xpath("html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[4]/input"))
						.sendKeys(Excel.getCellData(4, 1));
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// Arrival date
			try {

				driver.findElement(By.xpath("//*[@id='searchArrivalDate']")).sendKeys(Excel.getCellData(5, 1));
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// select arrival meal from the drop down
			try {

				Select dropArrivalMeal = new Select(driver.findElement(By.name("arrivalMeal")));
				dropArrivalMeal.selectByValue(Excel.getCellData(6, 1));
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// night depature
			try {

				driver.findElement(By.xpath("//*[@id='searchDepartureDate']")).sendKeys(Excel.getCellData(7, 1));
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// select departure meal from the drop down
			try {

				Select dropDownDepartureMeal = new Select(driver.findElement(By.name("departureMeal")));
				dropDownDepartureMeal.selectByValue(Excel.getCellData(8, 1));
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// no of rooms
			try {
				driver.findElement(By.xpath("//*[@id='searchGuestNoOfRooms']")).sendKeys("1");
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			
			try {

				WebElement element = driver.findElement(By.id("searchGuestPartnerLookup"));
				element.sendKeys(Excel.getCellData(11, 1));
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//div[@class='autocomplete-w1']/div/div/strong[text()='FIT Local']"))
						.click();

			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			// click seacrh room rates button
			Thread.sleep(2000);
			driver.findElement(By.id("btnShowRates")).click();

			// **************************Reservation
			// details**********************************
			// select meal plan check box
			try {
				Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/div[29]/div[2]/div[1]/span/div/div/div[2]/table/tbody/tr[3]/td[4]/table/tbody/tr/td[2]/div/input[29]")).click();
			
			
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}

			
			//click book button
			
			try {
				Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[29]/div[2]/div[1]/span/div/div/div[3]/div[2]/button")).click();
			
			
			} catch (Exception e) {
				String message = null;
				Log.error( message, e);
			}
			
			
//save button  html/body/div[1]/table/tbody/tr/td[2]/button
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/button")).click();
//close button			
			Thread.sleep(3000);
			driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[1]/button[1]")).click();
		}
	}
}
