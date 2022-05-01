package com.Zhara;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_208RoomallocationNormalReservationwithoneroomNRC189 extends BaseTestScript {
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_Roomallocation Normal Reservation with one room NRC189 Ex208");
		homePg = loginPg.clickSignIn();
		homePg.clickFrontOffice();

		manageReservationPageObject_Pg = homePg.clickManageReservation();
		manageReservationPageObject_Pg.enterHotelName(Excel.getCellDataInt(18, 5));
		//manageReservationPageObject_Pg.inputArrivalDate(Excel.getCellData(18, 1));
		//manageReservationPageObject_Pg.inputVoucherNo(Excel.getCellData(18, 0));
		//manageReservationPageObject_Pg.clickSearch();
		//manageReservationPageObject_Pg.clickSearchResult();
		
		
	//	String voucherNoToSave =manageReservationPageObject_Pg.getVourcherNumber();
		//Excel.setCellData(voucherNoToSave, 50, 1);
		
		homePg.clickFrontOffice();
		roomAlloctionPage = homePg.clickRoomAllocation();
		//search by voucher no
		roomAlloctionPage.inputVoucherNoToSearch(Excel.getCellData(18, 0));
		roomAlloctionPage.searchVoucherNo();
		roomAlloctionPage.clickSearchResultByVNo();
		roomAlloctionPage.getRoomType();//debug
		String roomTypeVar =roomAlloctionPage.selectRoom();
		roomAlloctionPage.clickRadioButton();
		roomAlloctionPage.clickButtonFilter();
		roomAlloctionPage.clickAvailableResult();
		roomAlloctionPage.selectVacantRoom(); //by tooltip Select a Room where room status = Vacant and H.K. Status = Inspected.  
		roomAlloctionPage.clickAvailableReultAgain(); 
		roomAlloctionPage.clickRoomAllocateSave();//debug

	}
}
