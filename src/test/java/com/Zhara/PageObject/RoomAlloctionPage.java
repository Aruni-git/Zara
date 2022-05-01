package com.Zhara.PageObject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Zhara.Log;

public class RoomAlloctionPage extends BasePageObject {

	WebElement messageLocation;
	String roomAllocationSuccessMsg = "ZHARA-0005: Room Allocation successfully saved.";
	String checkInSuccessMsg = "ZHARA-8916: Guest(s) successfully checked-in";
	String roomStatusMessage = "ZHARA-8917: Room status successfully changed.";
	String roomTypeVar;

	public RoomAlloctionPage(WebDriver driver1) {
		super(driver1);

	}

	public void captureRoomType() {

		try {
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_2");
			Thread.sleep(2000);
			WebElement txt = driver.findElement(
					By.xpath("html/body/div[2]/table/tbody/tr[1]/td[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[10]"));
			roomTypeVar = txt.getText();

		} catch (Exception e) {
			Log.error("Error", e);
		}

	}

	// select room type in dropdown DT
	public void selectRoomType(String val) {

		try {
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_2");
			Thread.sleep(2000);
			System.out.println(roomTypeVar);
			Select dropDownRoomType = new Select(driver.findElement(By.id("filterRoomTypeId")));
			dropDownRoomType.selectByVisibleText(val);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Select Roomtype dropdown for single room
	public void selectRoomTypeSingle(String roomType) {

		try {
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_2");
			Thread.sleep(2000);
			Select dropDownRoomType = new Select(driver.findElement(By.id("filterRoomTypeId")));
			dropDownRoomType.selectByVisibleText(roomType);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// click radio button filterRoomOption.non_occupied

	public void clickRadioButton() {

		try {

			Thread.sleep(4000);
			driver.findElement(By.id("filterRoomOption.non_occupied")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// click filter button btnFilter
	public void clickButtonFilter() {

		try {

			Thread.sleep(4000);
			driver.findElement(By.id("btnFilter")).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// click the grid
	public void clickAvailableResult() {

		try {

			Thread.sleep(4000);
			driver.findElement(By
					.xpath("//html/body/div[2]/table/tbody/tr[1]/td[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[1]/font"))
					.click();

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// select the vacant room

	public void selectVacantRoom() {

		try {
			// Thread.sleep(4000);
			// int count = 0;
			// List<WebElement> availableRooms = driver
			// .findElements(By.xpath("//div[@id='availableRoomGrid']/table/tbody/tr/td[2]"));
			// for (WebElement availability : availableRooms) {
			// Actions act = new Actions(driver);
			// act.moveToElement(availability).perform();
			// Thread.sleep(2000);
			// availability.click(); Thread.sleep(1000);
			// }

			List<WebElement> rowCount = driver.findElements(
					By.xpath("html/body/div[2]/table/tbody/tr[1]/td[2]/form/div/div[2]/div[2]/table/tbody/tr"));
			Thread.sleep(1000);
			System.out.println(rowCount.size());
			for (int i = 1; i < rowCount.size() - 1; i++) {
				Thread.sleep(1000);
				driver.findElement(
						By.xpath("//div[@id='availableRoomGrid']/table/tbody//td[@style='background-color:#F62217;']"))
						.click();

				break;
			}

			// Thread.sleep(2000);

			// driver.findElement(By.xpath("//div[@id='availableRoomGrid']/table/tbody//td[@style='background-color:#F62217;']"));

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// select the grid again
	public void clickAvailableReultAgain() {

		try {

			Thread.sleep(3000);
			driver.findElement(
					By.xpath("//html/body/div[2]/table/tbody/tr[1]/td[1]/div[2]/div[2]/div/table/tr[1]/td[1]/font"))
					.click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	public void clickRoomAllocateSave() {

		try {

			Thread.sleep(4000);
			driver.findElement(By.id("btnSave")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// click check in button id=btnCheckIn
	public void clickCheckIn() {

		try {

			Thread.sleep(4000);
			driver.findElement(By.id("btnCheckIn")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// clcik house keeping button
	public void clickRoomHouseKeepingStatus() {

		try {
			// capture search result rows
			// List<WebElement> rowCount =
			// driver.findElements(By.xpath("//div[@id='resultsScroller']/div/table//tr"));
			// Thread.sleep(1000);
			// System.out.println(rowCount.size());
			// for (int i = 1; i < rowCount.size()+1; i++) {
			// break the loop when needed add house keeping code into this and
			// try
			// }
			//
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_3");

			WebElement element = driver.findElement(
					By.xpath("html/body/table/tbody/tr[4]/td/div/div[2]/div/table/tbody/tr[1]/td[5]/font"));

			if (element.getText().contains("DIRTY")) {
				Thread.sleep(4000);
				driver.findElement(By.id("btnChngRoomStatus")).click();
			}

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Select the record check box
	public void tickSelectChkBx() {

		try {

			Thread.sleep(2000);
			// driver.findElement(By.xpath("//table[@id='tblResults']//input[@id='row_1_chkBox")).click();
			driver.findElement(By.id("chkChangeSel")).click();

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// CLickbutton check in
	public void clickCheckInEnd() {

		try {

			Thread.sleep(4000);
			driver.findElement(By.id("btnCheckIn")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Click Yes Button

	public void clickOk() {

		try {

			Thread.sleep(4000);
			driver.findElement(By.xpath("//html/body/div[5]/div[3]/button[3]")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// capture checkin success in message
	public boolean CcaptureCheckInSuccesMsg() {
		boolean successMessage = false;

		try {
			Thread.sleep(3000);
			messageLocation = driver.findElement(By.xpath("//html/body/table/tbody/tr[6]/td/div/div/div/div"));
			if (messageLocation.getText().equals(checkInSuccessMsg)) {
				successMessage = true;
			} else {
				successMessage = false;
			}
		} catch (Exception e) {

			Log.error("Error", e);
		}
		return successMessage;

	}

	// TC_RoomallocationNormalReservationwithoneroomNRC189Ex208
	// Enter vourcher no to search
	public void inputVoucherNoToSearch(String voucherNo) {
		try {
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().parentFrame();
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.id("frmTabmenu_spnTabMenus_1")));
			Thread.sleep(2000);
			driver.findElement(By
					.id("voucherNumber"))
					.sendKeys(voucherNo);
			String voucherNoInput = voucherNo;
		} catch (Exception e) {

			Log.error("Error", e);
		}
	}

	public void searchVoucherNo() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("btnSearch")).click();
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}
	//clickSearchResult
	public void clickSearchResultByVNo() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//html/body/div[2]/table/tbody/tr[1]/td[1]/div[2]/div[2]/div/table/tr[1]/td[1]/font")).click();
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}
	
	public void getRoomType() {

		try {
			Thread.sleep(2000);
			WebElement txt = driver.findElement(
					By.xpath("html/body/div[2]/table/tbody/tr[1]/td[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[10]"));
			roomTypeVar = txt.getText();

		} catch (Exception e) {
			Log.error("Error", e);
		}

	}
	public String selectRoom( ) {

		try {
			Thread.sleep(2000);
			Select dropDownRoomType = new Select(driver.findElement(By.id("filterRoomTypeId")));
			dropDownRoomType.selectByVisibleText(roomTypeVar);
			return roomTypeVar;
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
		return null;

	}
	
}
