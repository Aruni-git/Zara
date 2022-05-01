package com.Zhara.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Zhara.CreateReservation;
import com.Zhara.Log;

public class ManageReservationPageObject extends BasePageObject {

	WebElement messageLocation;
	String geustDetailsSuccessMsg = "ZHARA-5552: Guest Details Successfully updated.";
	String voucherNoInput;
	String regNo;
	String VourcherNumber;

	public ManageReservationPageObject(WebDriver driver1) {
		super(driver1);

	}

	public void enterHotelName(int hotelIndex) {

		try {

			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_0");
			Thread.sleep(2000);
			Select enterHotelNameInt = new Select(driver.findElement(By.id("selHotel")));
			enterHotelNameInt.selectByIndex(hotelIndex);
		} catch (Exception e) {

			Log.error("Error", e);
		}

	}

	// Enter arrival date
	public void inputArrivalDate(String inputArrivalDate) {
		try {
			Thread.sleep(2000);
			driver.findElement(By
					.xpath("//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/form/div[1]/table/tbody/tr[1]/td[4]/img"))
					.sendKeys(inputArrivalDate);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// Enter arrival dateto
	public void inputArrivalDateTo(String inputArrivalDateTo) {
		try {
			Thread.sleep(2000);
			driver.findElement(By
					.xpath("//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/form/div[1]/table/tbody/tr[1]/td[4]/img"))
					.sendKeys(inputArrivalDateTo);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// Enter departure date from
	public void inputDepartureDate(String inputDepartureDate) {
		try {
			Thread.sleep(2000);
			driver.findElement(By
					.xpath("//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/form/div[1]/table/tbody/tr[1]/td[8]/input"))
					.sendKeys(inputDepartureDate);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// add voucher
	public void inputVoucherNo(String voucherNo) {
		try {

			Thread.sleep(2000);
			driver.findElement(By.id("txtVoucherNo")).sendKeys(voucherNo);
			voucherNoInput = voucherNo;
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// click result ST
	public void clickSearchResult() {

		try {

			Thread.sleep(4000);
			// for ST
			driver.findElement(By.xpath("//table[@id='tblResults']/tr[1]")).click();
			// For DT
			// driver.findElement(By.xpath("//table[@id='tblResults']/tr/td[2]/a/font[text()='"
			// +voucherNoInput+ "']/../../..")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// click search button
	public void clickSearch() {

		try {
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/form/div[5]/button[2]"))
					.click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// Click R list button
	public void clickRList() {

		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//html/body/table/tbody/tr[4]/td/table/tbody/tr/td/button[8]")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Click popup
	public void clickPopUpOk() {

		try {

			Thread.sleep(3000);
			driver.findElement(By.id("popup_ok")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Click Qupdate button
	public void clickQUpdate() {

		try {

			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(2000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_1");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[1]/button[9]")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Selelct country dropdown

	public void selectCountry(String country) {

		try {
			Select dropDownCountry = new Select(driver.findElement(By.id("quickCountryId_All")));
			dropDownCountry.selectByVisibleText(country);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Select nationality drop down
	public void selectNationality(String nationality) {

		try {

			Select dropDownCountry = new Select(driver.findElement(By.id("quickNationalityId_All")));
			dropDownCountry.selectByVisibleText(nationality);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Select apply to all Country
	public void ClickApplyCountryChkBX() {

		try {

			driver.findElement(By.id("country_All")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Select apply to all Country
	public void ClickApplyNationalityChkBX() {

		try {

			driver.findElement(By.id("nationality_All")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Select apply to all Country
	public void ClickOk() {

		try {

			driver.findElement(By.xpath("html/body/div[15]/div[3]/button[1]")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// capture success message
	public boolean captureSuccessMsg() {
		boolean successMessage = false;

		try {

			messageLocation = driver.findElement(By.xpath("//div[@id='divMessageContainer']//p"));
			if (messageLocation.getText().equals(geustDetailsSuccessMsg)) {
				successMessage = true;
			} else {
				successMessage = false;
			}
		} catch (Exception e) {

			Log.error("Error", e);
		}
		return successMessage;

	}

	// id btnAllocateRoom
	// click button allocate
	public RoomAlloctionPage ClickRoomAllocation() {

		try {
			Thread.sleep(2000);
			driver.findElement(By.id("btnAllocateRoom")).click();
			RoomAlloctionPage roomAlloctionPage = new RoomAlloctionPage(driver);
			return roomAlloctionPage;
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
		return null;

	}

	// Cancel reservations
	public void clickCancelReservatiocsButton() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("btnCancel")).click();
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// Tick select all records in cancel reservations frmTabmenu_spnTabMenus_0
	public void tickChkBox() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("chkCancelSelectAll")).click();
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// Select the reason(drop down) for cancel reservation selCancelResId
	public void selectReason(int reason) {

		try {
			Thread.sleep(2000);
			Select dropDownReason = new Select(driver.findElement(By.id("selCancelResId")));
			dropDownReason.selectByIndex(reason);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Select cancel registration button id
	public void ClickCancelRegistrationButton() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("btnResCancelDoCancel")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// cancel pop up ok popup_ok
	public void ClickCancelPopUpOk() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.id("popup_ok")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// click add button to TC 158 Make Normal reservations in Bulk NRC_141
	public CreateReservationsObject clickAdd() {

		try {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_0");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//html/body/table/tbody/tr[4]/td/table/tbody/tr/td/button[2]")).click();
			CreateReservationsObject createReservationsObjectPg = new CreateReservationsObject(driver);
			return createReservationsObjectPg;
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
		return null;

	}

	//  Rooming Normal reservations in Bulk NRC _142
	// add voucher
	public void inputVoucherNoNRC_142(String voucherNo) {
		try {
			Thread.sleep(20000);
			driver.switchTo().defaultContent();
			driver.switchTo().parentFrame();
			driver.switchTo().frame("main");
			driver.switchTo().frame("frmTabmenu_spnTabMenus_0");
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.id("txtVoucherNo"));
			element.clear();
			Thread.sleep(2000);
			element.sendKeys(voucherNo);
			voucherNoInput = voucherNo;
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void clickSave() {

		try {
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			driver.switchTo().frame("frmTabmenu_spnTabMenus_1");
			Thread.sleep(2000);
			driver.findElement(By.id("btnSave")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// Click close button
	public void clickClose() {

		try {
			Thread.sleep(2000);
			driver.findElement(By.id("btnClose")).click();
		} catch (Exception e) {

			Log.error("Error", e);
		}

	}

	// get the reg no
	public String getRegNo() {
		try {
			Thread.sleep(2000);
			WebElement registrationNo = driver.findElement(By.xpath("//tr[@id='_gridRow_47146']/td[3]/font"));
			 regNo =registrationNo.getText();			
			return regNo;
		} catch (Exception e) {
			Log.error("Error", e);
		}
		return null;
	}

	
	//read reg no
	public Boolean verifyRegNo(){
	//	String successMessage ="Registration number has verified";
		boolean successMessage = false;
		try {
			if(regNo != null){
				
				successMessage = true;
			}else{
				successMessage =  false;
			}
		} catch (Exception e) {
			
		}
		return successMessage;
	}
	// TC_CheckInNormalReservationwithoneroomNRC91
	// select status check in
	public void selectStatusCheckIn(int selectStatusCheckIn) {

		try {
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_0");
			Thread.sleep(2000);
			Select dropDownStatus = new Select(driver.findElement(By.xpath(
					"//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/form/div[1]/table/tbody/tr[2]/td[8]/select")));
			dropDownStatus.selectByIndex(selectStatusCheckIn);
		} catch (Exception e) {

			Log.error("Error", e);
		}

	}

	public void clickSearchButton() {
		try {
			Thread.sleep(2000);
			driver.findElement(
					By.xpath("//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/form/div[5]/button[2]"))
					.click();
		} catch (Exception e) {

			Log.error("Error", e);
		}
	}

	//
	public void selectResult() {

		try {

			Thread.sleep(2000);

			WebElement ele = driver.findElement(
					By.xpath("//html/body/table/tbody/tr[3]/td/div[2]/div[2]/div/table/tr[22]/td[1]/font"));
			// "//div[@id='resultsScroller']/div/table[@id='tblResults']/tr[@id='_gridRow_47117']/td/font[Text()='11']"
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			actions.moveToElement(ele).click().perform();

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	public void clickCheckIn() {

		try {
			Thread.sleep(3000);
			driver.findElement(By.id("btnCheckIn")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	// Find expected result

	public void clickExResult() {

		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"//div[@id='resultsScroller']/div/table[@id='tblResults']/tbody/tr/td/font[Text()='EXPECTED']"));

		} catch (Exception e) {
		
			Log.error("Error", e);
		}

	}

	// click result
	public void clickExRes() {

		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath(
					"//div[@id='resultsScroller']/div/table[@id='tblResults']/tbody/tr/td/font[Text()='EXPECTED']"));

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	// clcik house keeping button
	public void clickRoomHouseKeepingStatus() {

		try {
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_1");

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

	// click check box
	public void clickCheckLAll() {

		try {
			
			Thread.sleep(20000);
			driver.switchTo().defaultContent();
			driver.switchTo().parentFrame();
			driver.switchTo().frame("main");
			driver.switchTo().frame("frmTabmenu_spnTabMenus_1");
			Thread.sleep(3000);
			driver.findElement(By.id("chkChangeSel")).click();

		} catch (Exception e) {

			Log.error("error", e);
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

	// Click ok Button

	public void clickOkCheckIn() {

		try {

			Thread.sleep(4000);
			driver.findElement(By.xpath("//html/body/div[5]/div[3]/button[3]")).click();
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
//TC_208RoomallocationNormalReservationwithoneroomNRC189
//Select the record and get the vourcher number
	
	public String getVourcherNumber( ){
		try {
			Thread.sleep(3000);
			WebElement Vno = driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/div[2]/div[2]/div/table/tbody/tr[19]/td[2]/a/font"));
			VourcherNumber = Vno.getText();
			return VourcherNumber;
		} catch (Exception e) {
			Log.error("Error", e);
		}
		
		return null;
		
	}
}
