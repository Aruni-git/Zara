package com.Zhara;

import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_206MakeDayUseReservationNRC188 extends BaseTestScript{
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC Make Day Use Reservation NRC 188");
		homePg = loginPg.clickSignIn();
		homePg.clickReservation();

		createReservationsObjectPg = homePg.clickCreateReservation();
		createReservationsObjectPg.enterHotelNameInt(Excel.getCellDataInt(1, 1));
		createReservationsObjectPg.selectTitle(Excel.getCellData(2, 1));
		createReservationsObjectPg.inputFirstName(Excel.getCellData(3, 1));
		createReservationsObjectPg.inputLastName(Excel.getCellData(4, 1));
		createReservationsObjectPg.inputArrivalDate(Excel.getCellData(5, 1));
		createReservationsObjectPg.selectArrivalMeal(Excel.getCellData(6, 1));
		createReservationsObjectPg.inputDepartureDate(Excel.getCellData(5, 1));
		createReservationsObjectPg.selectDepartureMeal(Excel.getCellData(8, 1));
		createReservationsObjectPg.inputDepartureTime(Excel.getCellData(39, 0));
		createReservationsObjectPg.inputNoOfRooms(Excel.getCellDataInt(9, 1));
		createReservationsObjectPg.inputPartner(Excel.getCellData(11, 1));
		createReservationsObjectPg.inputPartnerByDropDown();
		createReservationsObjectPg.TickDayUse();
		createReservationsObjectPg.selectRoomTypeRoomDetails(Excel.getCellData(28, 0));
		createReservationsObjectPg.selectBillingRT(Excel.getCellData(28, 1));
		createReservationsObjectPg.inputDBL(Excel.getCellDataInt(28, 2));
		createReservationsObjectPg.selectMealPlan(Excel.getCellData(28, 4));
		createReservationsObjectPg.inputPartnerEmail(Excel.getCellData(28, 3));
		createReservationsObjectPg.inputMarket(Excel.getCellData(28, 5));
		createReservationsObjectPg.inputMarketByDropDown();
		createReservationsObjectPg.clickSave();
		
	}
}
