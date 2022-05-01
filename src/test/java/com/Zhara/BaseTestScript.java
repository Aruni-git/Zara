package com.Zhara;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.Zhara.PageObject.CasheringManagerObject;
import com.Zhara.PageObject.CreateRatePageObject;
import com.Zhara.PageObject.CreateReservationsObject;
import com.Zhara.PageObject.CreateReservationsObject_2;
import com.Zhara.PageObject.HomeScreen;
import com.Zhara.PageObject.ManageReservationPageObject;
import com.Zhara.PageObject.RoomAlloctionPage;

import com.Zhara.Util.Constant;
import com.Zhara.Util.Excel;

public class BaseTestScript {
	public static WebDriver driver;
	String Environment = "QA";
	public static HomeScreen homePg;
	public static CreateRatePageObject createRatePageObjecjPg;
	public static CreateReservationsObject createReservationsObjectPg;
	public static CreateReservationsObject_2 createReservationsObjectPg_2;
	public static ManageReservationPageObject manageReservationPageObject_Pg;
	public static RoomAlloctionPage roomAlloctionPage;
	public static CasheringManagerObject casheringManagerObject_Pg;
	

	@BeforeClass
	public void testSetUp() {

		try {
			DOMConfigurator.configure("log4j.xml");
			Excel.setExcelFile(Constant.Path_TestData, Constant.sheetName);
			driver = new FirefoxDriver();
			driver.get(Excel.getCellData(13, 1));
			driver.manage().window().maximize();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
