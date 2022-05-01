package com.Zhara;

import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_225PrintInvoicesExtrasBillNorReservatioNwithRoom extends BaseTestScript{
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_PrintInvoicesExtrasBillNorReservatioNwithRoom test case started");
		homePg = loginPg.clickSignIn();
		homePg.clickReservation();
}
}