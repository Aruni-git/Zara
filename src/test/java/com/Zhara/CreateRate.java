package com.Zhara;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Zhara.Util.Data;

public class CreateRate {
	
	public static class setUp {

		String baseUrl = "http://10.2.240.170/";
		static WebDriver driver;

		@BeforeClass
		public void setBaseURL() {
			// Configure Log file
			DOMConfigurator.configure("log4j.xml");

			// Create an instance of firefox driver
			driver = new FirefoxDriver();
			driver.get(baseUrl);
		}

		@Test
		public void login() throws Throwable {

			Data dataSheet = new Data();
			dataSheet.setMasterProp();
			// Handle the window
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
			Thread.sleep(2000);
			driver.findElement(By.id("j_username")).sendKeys(dataSheet.getProp("username"));
			Thread.sleep(2000);
			driver.findElement(By.id("j_password")).sendKeys(Data.getProp("password"));
			Thread.sleep(2000);
			driver.findElement(By.id("btnLogin")).click();

			Thread.sleep(2000);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//html/body/div[6]/div[8]/nobr")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);

			// select manage rate
			driver.findElement(By.xpath("//html/body/div[8]/div[2]/nobr")).click();

			// create rate button
			driver.switchTo().frame(driver.findElement(By.id("frmTabmenu_spnTabMenus_0")));
			driver.findElement(By.xpath("//*[@id='btnCreate']")).click();

			// Rate type
			driver.switchTo().parentFrame();
			Thread.sleep(5000);
			driver.switchTo().frame(driver.findElement(By.id("frmTabmenu_spnTabMenus_1")));
			Thread.sleep(5000);
			// Select rate type radio button
			driver.findElement(By.xpath("//*[@id='normalType']")).click();

			// RatePlanPrefix
			driver.findElement(By.xpath("//*[@id='ratePlanPrefix']")).sendKeys(dataSheet.getProp("RatePlanPrefix"));

			// Contract valid from
			driver.findElement(By.xpath("//*[@id='contractValidFrom']")).sendKeys(dataSheet.getProp("ValidFrom"));
			// Contract valid to
			driver.findElement(By.xpath("//*[@id='contractValidTo']")).sendKeys(dataSheet.getProp("ValidTo"));
			// select rate category from dropdown
			Select dropDownRateCategory = new Select(driver.findElement(By.name("rateCatId")));
			dropDownRateCategory.selectByValue(dataSheet.getProp("RateCategory"));
			// select currency
			Select dropDownCurrency = new Select(driver.findElement(By.name("exchangeRateId")));
			dropDownCurrency.selectByVisibleText(dataSheet.getProp("Currency"));


			// select ChannelVisibility
			Thread.sleep(2000);
			Select dropDownChannelVisibility = new Select(driver.findElement(By.name("visibleChannelId")));
			dropDownChannelVisibility.selectByValue(dataSheet.getProp("ChannelVisibility"));
			// child level
			Thread.sleep(2000);
			Select dropDownchildLevel = new Select(driver.findElement(By.name("childLevelId")));
			dropDownchildLevel.selectByValue(dataSheet.getProp("ChildLevel"));
			// Save button
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();

			// navigate to rate tab
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='tabs']/ul/li[2]/a/font")).click();

			// create first rate with room type 1

			// Charge method
			Thread.sleep(2000);
			WebElement radioButton = driver.findElement(By.xpath("//*[@id='chargeMethodPax']"));
			radioButton.click();
			// Rate entry mode
			Thread.sleep(2000);
			WebElement radioButton1 = driver.findElement(By.xpath("//*[@id='keyInMode']"));
			radioButton1.click();

			String[] roomType = Data.getProp("RoomType").split(",");
			String[] mealPlan = Data.getProp("MealPlan").split(",");
			String[] sGL = Data.getProp("SGL").split(",");
			String[] dBL = Data.getProp("DBL").split(",");
			String[] tPL = Data.getProp("TPL").split(",");
			String[] qUD = Data.getProp("QUD").split(",");
			String[] child = Data.getProp("Child").split(",");
			int num = 0;
			//int count = 0;
			for (String r : roomType) {

				for (String m : mealPlan) {

					// Room type
					Thread.sleep(2000);
					Select dropDownRoomType = new Select(driver.findElement(By.id("roomTypeId")));
					dropDownRoomType.selectByValue(r);

					// Meal plan
					Thread.sleep(2000);
					Select dropDownMealType = new Select(driver.findElement(By.id("mealPlanId")));
					dropDownMealType.selectByValue(m);

					// Occupancy rate
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='htlRoomOcc_0']")).sendKeys(sGL[num]);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='htlRoomOcc_1']")).sendKeys(dBL[num]);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='htlRoomOcc_2']")).sendKeys(tPL[num]);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='htlRoomOcc_3']")).sendKeys(qUD[num]);
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='childCat_0']")).sendKeys(child[num]);

					// add button
					driver.findElement(By.xpath("//*[@id='btnDetGridAdd']")).click();

					num++;
				}
			
			}

			// save button after the rate
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();

			Thread.sleep(2000);
			// navigate to payment tab
			driver.findElement(By.xpath("//*[@id='tabs']/ul/li[6]/a/font")).click();
			// payment by
			Thread.sleep(2000);
			WebElement radioButton3 = driver.findElement(By.xpath("//*[@id='localAgent']"));
			radioButton3.click();
			// payment method
			Thread.sleep(2000);
			WebElement radioButton4 = driver.findElement(By.xpath("//*[@id='cashMode']"));
			radioButton4.click();
			// Save button
			driver.findElement(By.xpath("//*[@id='btnSave']")).click();
			// Approve button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='btnApprove']")).click();
			Thread.sleep(2000);
			String rateCode = driver.findElement(By.xpath("//*[@id='spnPayContractCode']/font/b")).getText();
			System.out.println(rateCode);

			// Close button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='btnClose']")).click();
			Thread.sleep(2000);
			// rate code for seacrh
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.id("frmTabmenu_spnTabMenus_0")));
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='txtContractNumber']")).sendKeys(rateCode);
			// search button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='frmSearch']/div[2]/button[2]")).click();

			// select the search result
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/table/tbody/tr[4]/td/div/div[2]/div/table/tr/td[2]/font")).click();
			// click authorized button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='btnAuthorize']")).click();

			// select the record to confirm
			Thread.sleep(2000);
			driver.findElement(By.xpath("html/body/table/tbody/tr[4]/td/div/div[2]/div/table/tr/td[2]/font")).click();
			// confirm
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='btnConfirmAuthorization']")).click();

		}

		@AfterTest
		public static void tearDown() {
			driver.quit();
		}

	}

}