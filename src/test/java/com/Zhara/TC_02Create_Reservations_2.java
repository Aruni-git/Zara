package com.Zhara;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;
import com.Zhara.PageObject.CreateReservationsObject_2;
import com.Zhara.Util.Excel;

public class TC_02Create_Reservations_2 extends BaseTestScript{
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info(" TC_02Create_Reservations_2 ");
		homePg = loginPg.clickSignIn();
		homePg.clickReservation();

		createReservationsObjectPg_2 = homePg.clickCreateReservation_2();
		// createReservationsObjectPg.enterHotelName(Excel.getCellData(1, 1));
		// //.toString());
		// String s = Excel.getCellData(1, 1);
		// System.out.println(s);
		createReservationsObjectPg_2.enterHotelName("298");
		createReservationsObjectPg_2.selectTitle(Excel.getCellData(2, 1));
		createReservationsObjectPg_2.inputFirstName(Excel.getCellData(3, 1));
		createReservationsObjectPg_2.inputLastName(Excel.getCellData(4, 1));
		createReservationsObjectPg_2.inputArrivalDate(Excel.getCellData(5, 1));
		createReservationsObjectPg_2.selectArrivalMeal(Excel.getCellData(6, 1));
		createReservationsObjectPg_2.inputDepartureDate(Excel.getCellData(7, 1));
		createReservationsObjectPg_2.selectDepartureMeal(Excel.getCellData(8, 1));
		createReservationsObjectPg_2.inputNoOfRooms(Excel.getCellData(9, 1));
		createReservationsObjectPg_2.inputNoOfRooms("1");
		createReservationsObjectPg_2.inputPartner(Excel.getCellData(11, 1));
		createReservationsObjectPg_2.inputPartnerByDropDown();
		createReservationsObjectPg_2.clickCreateRoom();
		createReservationsObjectPg_2.clickMealPlanCheckBox();
		createReservationsObjectPg_2.clickBook();
		createReservationsObjectPg_2.clickSave();
		homePg = createReservationsObjectPg_2.clickClose();

	}

}
