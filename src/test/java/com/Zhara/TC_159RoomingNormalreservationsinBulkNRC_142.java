package com.Zhara;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_159RoomingNormalreservationsinBulkNRC_142 extends BaseTestScript {
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_159 Rooming Normal reservations in Bulk NRC_142");
		homePg = loginPg.clickSignIn();
		homePg.clickFrontOffice();

		manageReservationPageObject_Pg = homePg.clickManageReservation();
		manageReservationPageObject_Pg.inputVoucherNoNRC_142(Excel.getCellData(32, 0));
		manageReservationPageObject_Pg.clickSearch();
		manageReservationPageObject_Pg.clickSearchResult();
		manageReservationPageObject_Pg.clickRList();
		manageReservationPageObject_Pg.clickPopUpOk();
		manageReservationPageObject_Pg.clickSave();
		manageReservationPageObject_Pg.clickClose();
		manageReservationPageObject_Pg.inputVoucherNoNRC_142(Excel.getCellData(32, 0));
		manageReservationPageObject_Pg.clickSearch();
		manageReservationPageObject_Pg.clickSearchResult();
		String registrationNoToSave = manageReservationPageObject_Pg.getRegNo();
		Excel.setCellData(registrationNoToSave, 28, 6);	
		Assert.assertTrue(manageReservationPageObject_Pg.verifyRegNo(),"RegNo");
	}
}