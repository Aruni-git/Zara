package com.Zhara;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Zhara.PageObject.Login_Page_Object;
import com.Zhara.Util.Excel;

public class TC_04ManageReservationDT extends BaseTestScript {
	@Test
	public void loginMethod() throws Exception {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Login_Page_Object loginPg = new Login_Page_Object(driver);
		loginPg.enterUserName(Excel.getCellData(0, 0));
		loginPg.enterPwd(Excel.getCellData(0, 1));
		Log.info("TC_04 ManageReservationDT");
		homePg = loginPg.clickSignIn();
		homePg.clickFrontOffice();

		manageReservationPageObject_Pg = homePg.clickManageReservation();
		manageReservationPageObject_Pg.enterHotelName(Excel.getCellDataInt(18, 5));
		manageReservationPageObject_Pg.inputArrivalDate(Excel.getCellData(18, 1));
		manageReservationPageObject_Pg.inputVoucherNo(Excel.getCellData(18, 9));
		System.out.println(Excel.getCellData(18, 9));
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
		roomAlloctionPage = manageReservationPageObject_Pg.ClickRoomAllocation();
		
		try {
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_2");
			Thread.sleep(2000);
			
			List<WebElement> arrRowCount;
			
			Thread.sleep(2000);
			
			arrRowCount = driver.findElements(By.xpath("//table[@id='tblResults']/tbody/tr"));
			Thread.sleep(1000);
			
			for (int i = 1; i < arrRowCount.size(); i++) {
				Thread.sleep(3000);
				//table[@id='tblResults']/tr[" +index+ "]/td[14]/input"
				System.out.println("i"+i);
				driver.findElement(By.xpath("//table[@id='tblResults']//tr["+i+"]/td[1]")).click();
				Thread.sleep(3000);
				String Value = driver.findElement(By.xpath("//table[@id='tblResults']//tr["+i+"]/td[10]")).getText();
//				roomAlloctionPage.captureRoomType();
				roomAlloctionPage.selectRoomType(Value);
				roomAlloctionPage.clickRadioButton();
				roomAlloctionPage.clickButtonFilter();
			//	roomAlloctionPage.clickAvailableResult();
				roomAlloctionPage.selectVacantRoom();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//table[@id='tblResults']//tr["+i+"]")).click();
				roomAlloctionPage.clickRoomAllocateSave();
			}
		} catch (Exception e) {
			
		}
		roomAlloctionPage.clickAvailableReultAgain();
		roomAlloctionPage.clickCheckIn();
		roomAlloctionPage.clickRoomHouseKeepingStatus();
		roomAlloctionPage.tickSelectChkBx();
		roomAlloctionPage.clickCheckInEnd();
		roomAlloctionPage.clickOk();

	}

}
