package com.Zhara;

import org.testng.annotations.Test;

import com.Zhara.PageObject.CasheringManagerObject;
import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_211AddNormalextraPostingstoNormalReservationwithaRoomNRC192 extends BaseTestScript{
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_Add Normal extra Postings to Normal Reservation with a Room NRC192 Ex211");
		homePg = loginPg.clickSignIn();
		homePg.clickCashering();

		casheringManagerObject_Pg = homePg.clickCashieringManager();
		casheringManagerObject_Pg.selectRecord();
		casheringManagerObject_Pg.addPosting();
		casheringManagerObject_Pg.selectNormalRadioBtn();
		casheringManagerObject_Pg.selectEntryTypeRadioBtn();
		casheringManagerObject_Pg.RevenueCodeDropDown(Excel.getCellDataInt(46, 1));
		casheringManagerObject_Pg.RevenueTypeDropDown(Excel.getCellDataInt(46, 0));
		casheringManagerObject_Pg.amountTest(Excel.getCellDataInt(46, 2));
		casheringManagerObject_Pg.includeTax();
		casheringManagerObject_Pg.clickPluseBtn();
		casheringManagerObject_Pg.popUpOk();
		casheringManagerObject_Pg.btnSave();
		casheringManagerObject_Pg.closeBtn();

	}
}
