package com.Zhara;

import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_160CancellationsOfRegistrationInBulk extends BaseTestScript {
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_160 Cancellations Of RegistrationIn Bulk");
		homePg = loginPg.clickSignIn();
		homePg.clickFrontOffice();

		manageReservationPageObject_Pg = homePg.clickManageReservation();
		manageReservationPageObject_Pg.enterHotelName(Excel.getCellDataInt(18, 5));
		manageReservationPageObject_Pg.inputVoucherNo(Excel.getCellData(18, 0));
		manageReservationPageObject_Pg.clickSearch();
		manageReservationPageObject_Pg.clickSearchResult();
		manageReservationPageObject_Pg.clickCancelReservatiocsButton();
		manageReservationPageObject_Pg.tickChkBox();
		manageReservationPageObject_Pg.selectReason(Excel.getCellDataInt(25, 0));
		manageReservationPageObject_Pg.ClickCancelRegistrationButton();
		manageReservationPageObject_Pg.ClickCancelPopUpOk();
	}
}