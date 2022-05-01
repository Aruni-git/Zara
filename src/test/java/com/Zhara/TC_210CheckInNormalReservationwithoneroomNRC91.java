package com.Zhara;

import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_210CheckInNormalReservationwithoneroomNRC91 extends BaseTestScript {
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_210 CheckIn Normal Reservation with one room NRC91");
		homePg = loginPg.clickSignIn();
		homePg.clickFrontOffice();

		manageReservationPageObject_Pg = homePg.clickManageReservation();
		manageReservationPageObject_Pg.selectStatusCheckIn(Excel.getCellDataInt(43, 0));
		manageReservationPageObject_Pg.clickSearchButton();
		manageReservationPageObject_Pg.selectResult();
		manageReservationPageObject_Pg.clickCheckIn();
		manageReservationPageObject_Pg.clickCheckLAll();
		manageReservationPageObject_Pg.clickCheckInEnd();
		manageReservationPageObject_Pg.clickOkCheckIn();
		manageReservationPageObject_Pg.clickClose();
	}
}
