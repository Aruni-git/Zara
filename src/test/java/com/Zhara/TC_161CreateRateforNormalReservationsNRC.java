package com.Zhara;

import static org.testng.Assert.expectThrows;

import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_161CreateRateforNormalReservationsNRC extends BaseTestScript {
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_161 Create Rate for Normal Reservations NRC");
		homePg = loginPg.clickSignIn();
		homePg.clickRateMaintenance();

		createRatePageObjecjPg= homePg.clickManageRate();
		createRatePageObjecjPg.clickRateType();
		createRatePageObjecjPg.inputRtaeplan(Excel.getCellData(35, 0));
		System.out.println(Excel.getCellData(35, 0));
		createRatePageObjecjPg.inputDate(Excel.getCellData(35, 1));
		createRatePageObjecjPg.inputValidFrom(Excel.getCellData(35, 1));
		createRatePageObjecjPg.inputValidTo(Excel.getCellData(35, 2));
		createRatePageObjecjPg.selectRateCategory(Excel.getCellDataInt(35, 3));
		createRatePageObjecjPg.selectCurrency(Excel.getCellData(35, 4));
		createRatePageObjecjPg.clicksave();
		createRatePageObjecjPg.navigateMealParty();
		createRatePageObjecjPg.enterDayUseRoomRate(Excel.getCellDataInt(36, 5));
		createRatePageObjecjPg.saveMealParty();
		createRatePageObjecjPg.addButton();
		createRatePageObjecjPg.clicksave();
		createRatePageObjecjPg.sendApproval();
	}
}
