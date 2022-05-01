package com.Zhara;

import static org.testng.Assert.expectThrows;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.PageObject.ManageReservationPageObject;
import com.Zhara.Util.Excel;

public class TC_03_ManageReservation extends BaseTestScript {
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_03_ManageReservation");
		homePg = loginPg.clickSignIn();
		homePg.clickFrontOffice();

		manageReservationPageObject_Pg = homePg.clickManageReservation();
		manageReservationPageObject_Pg.enterHotelName(Excel.getCellDataInt(18, 5));
		System.out.println(Excel.getCellDataInt(18, 5));
		manageReservationPageObject_Pg.inputArrivalDate(Excel.getCellData(18, 1));
		manageReservationPageObject_Pg.inputVoucherNo(Excel.getCellData(18, 0));
		manageReservationPageObject_Pg.clickSearch();
		manageReservationPageObject_Pg.clickSearchResult();
		manageReservationPageObject_Pg.clickRList();
		manageReservationPageObject_Pg.clickPopUpOk();
		manageReservationPageObject_Pg.clickQUpdate();
		manageReservationPageObject_Pg.selectCountry(Excel.getCellData(18, 6));
		manageReservationPageObject_Pg.selectNationality(Excel.getCellData(18, 7));
		manageReservationPageObject_Pg.ClickApplyCountryChkBX();
		manageReservationPageObject_Pg.ClickApplyNationalityChkBX();
		manageReservationPageObject_Pg.ClickOk();
		Assert.assertTrue(manageReservationPageObject_Pg.captureSuccessMsg(), "Guest details");
		roomAlloctionPage = manageReservationPageObject_Pg.ClickRoomAllocation();
		System.out.println(Excel.getCellData(18, 8));
		roomAlloctionPage.selectRoomTypeSingle(Excel.getCellData(18, 8));
		roomAlloctionPage.clickRadioButton();
		roomAlloctionPage.clickButtonFilter();
		roomAlloctionPage.clickAvailableResult();
		roomAlloctionPage.selectVacantRoom();
		roomAlloctionPage.clickRoomAllocateSave();
		roomAlloctionPage.clickAvailableReultAgain();
		roomAlloctionPage.clickCheckIn();
		roomAlloctionPage.clickRoomHouseKeepingStatus();
		roomAlloctionPage.tickSelectChkBx();
		roomAlloctionPage.clickCheckInEnd();
		roomAlloctionPage.clickOk();
		Assert.assertTrue(roomAlloctionPage.CcaptureCheckInSuccesMsg(), "Guest CHECKED_IN");

	}

}