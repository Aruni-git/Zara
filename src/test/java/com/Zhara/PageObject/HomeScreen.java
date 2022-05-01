package com.Zhara.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.Zhara.Log;
import com.Zhara.PageObject.BasePageObject;

public class HomeScreen extends BasePageObject {

	public HomeScreen(WebDriver driver1) {
		super(driver1);
	}

	// Click Rate maintenance
	public void clickRateMaintenance() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			uiClick(driver.findElement(By.xpath("//html/body/div[6]/div[8]/nobr")));
			
		} catch (Exception e) {
			Log.error("Error", e);
		}

	}

	// click manage rate
	public CreateRatePageObject clickManageRate() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			driver.findElement(By.xpath("//html/body/div[8]/div[2]/nobr")).click();
			CreateRatePageObject createRateObjectPg = new CreateRatePageObject(driver);
			driver.switchTo().frame(driver.findElement(By.id("frmTabmenu_spnTabMenus_0")));
			uiClick(driver.findElement(By.xpath("//*[@id='btnCreate']")));
			return createRateObjectPg;
		} catch (Exception e) {

			Log.error("Error", e);
		}
		return null;

	}
	// clickReservation 
	public void clickReservation() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			uiClick(driver.findElement(By.xpath("html/body/div[6]/div[2]/nobr")));
		} catch (Exception e) {
			Log.error("Error", e);
		}

	}

	// click create reservations
	public CreateReservationsObject clickCreateReservation() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			CreateReservationsObject createReservationsObjectPg = new CreateReservationsObject(driver);
			uiClick(driver.findElement(By.xpath("//div[@class='menuBar']/../div/nobr[text()='Create Reservation']")));
			return createReservationsObjectPg;
		} catch (Exception e) {

			
			Log.error("Error", e);
		}
		return null;

	}

	// click create reservations2
	public CreateReservationsObject_2 clickCreateReservation_2() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			CreateReservationsObject_2 createReservationsObjectPg_2 = new CreateReservationsObject_2(driver);
			uiClick(driver.findElement(By.xpath("//div[@class='menuBar']/../div/nobr[text()='Create Reservation']")));
			return createReservationsObjectPg_2;
		} catch (Exception e) {

			
			Log.error("Error", e);
		}
		return null;

	}

	// click front office
	public void clickFrontOffice() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			uiClick(driver.findElement(By.xpath("//html/body/div[6]/div[3]/nobr")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// click manage reservations
	public ManageReservationPageObject clickManageReservation() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			ManageReservationPageObject manageReservationPageObject_Pg = new ManageReservationPageObject(driver);
			uiClick(driver.findElement(By.xpath("//div[@class='menuBar']/../div/nobr[text()='Manage Reservation']")));
			return manageReservationPageObject_Pg;
		} catch (Exception e) {

			Log.error("Error", e);
			
		}
		return null;

	}

	// click manage reservations 2 DRT
	public ManageReservationPageObject clickManageReservation2() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			ManageReservationPageObject manageReservationPageObject_Pg = new ManageReservationPageObject(driver);
			uiClick(driver.findElement(By.xpath("//div[@class='menuBar']/../div/nobr[text()='Manage Reservation']")));
			return manageReservationPageObject_Pg;
		} catch (Exception e) {

			
			Log.error("Error", e);
		}
		return null;

	}
	// click cashiring
	public void clickCashering() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			uiClick(driver.findElement(By.xpath("//html/body/div[6]/div[4]/nobr")));
		} catch (Exception e) {
			Log.error("Error", e);
			
		}

	}

	//CLick cashiering manager
	public CasheringManagerObject clickCashieringManager() {

		try {
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame("main");
			CasheringManagerObject casheringManagerObject_Pg = new CasheringManagerObject(driver);
			uiClick(driver.findElement(By.xpath("//div[@class='menuBar']/../div/nobr[text()='Cashiering Manager']")));
			return casheringManagerObject_Pg;
		} catch (Exception e) {

			Log.error("Error", e);
		}
		return null;

	}
	// click Front office --> Room allocation
	public RoomAlloctionPage clickRoomAllocation() {

		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			RoomAlloctionPage roomAlloctionPage = new RoomAlloctionPage(driver);
			uiClick(driver.findElement(By.xpath("//div[@class='menuBar']/../div/nobr[text()='Room Allocation']")));
			return roomAlloctionPage;
		} catch (Exception e) {

			Log.error("Error", e);
			
		}
		return null;

	}
}
