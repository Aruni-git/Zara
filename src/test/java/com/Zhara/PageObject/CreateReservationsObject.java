package com.Zhara.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.Zhara.Log;

public class CreateReservationsObject extends BasePageObject {

	public CreateReservationsObject(WebDriver driver1) {
		super(driver1);

	}

	public void enterHotelNameInt(int hotelIndex) {

		try {

			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_0");
			Thread.sleep(2000);
			Select enterHotelNameInt = new Select(driver.findElement(By.id("selHotel")));
			enterHotelNameInt.selectByIndex(hotelIndex);
		} catch (Exception e) {
			Log.error("Error", e);
		}

	}

	public void selectTitle(String title) {
		try {
			Thread.sleep(2000);
			Select dropDownTitle = new Select(driver.findElement(By.name("partnerRates.title")));
			dropDownTitle.selectByValue(title);
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	public void inputFirstName(String inputFirstName) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[2]/input")), inputFirstName);
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	public void inputLastName(String inputLastName) {
		try {
			Thread.sleep(2000);

			uiSendKeys(driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[1]/td/table/tbody/tr/td[3]/table/tbody/tr/td[4]/input")), inputLastName);
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	public void inputArrivalDate(String inputArrivalDate) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//*[@id='searchArrivalDate']")), inputArrivalDate);
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	public void inputDepartureTime(String departureTime) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath(
					"//html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/input")), departureTime);
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	public void selectArrivalMeal(String selectArrivalMeal) {
		try {
			Thread.sleep(2000);
			Select dropArrivalMeal = new Select(driver.findElement(By.name("arrivalMeal")));
			dropArrivalMeal.selectByValue(selectArrivalMeal);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void inputDepartureDate(String inputDepartureDate) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//*[@id='searchDepartureDate']")), inputDepartureDate);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void selectDepartureMeal(String selectDepartureMeal) {
		try {
			Thread.sleep(2000);
			Select dropDepartureMeal = new Select(driver.findElement(By.name("departureMeal")));
			dropDepartureMeal.selectByValue(selectDepartureMeal);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void inputNoOfRooms(int inputNoOfRooms) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[4]/td/table/tbody/tr/td[2]/input")),String.valueOf(driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[4]/td/table/tbody/tr/td[2]/input"))));
		} catch (Exception e) {
			Log.error("Error", e);
			
		}
	}

	public void inputPartner(String inputPartner) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.id("searchGuestPartnerLookup")), inputPartner);
		} catch (Exception e) {
			String message = null;
			Log.error(message, e);
		}
	}

	public void inputPartnerByDropDown() {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("//div[@class='autocomplete-w1']/div/div/strong[text()='FIT Local']")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void clickCreateRoom() {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("btnShowRates")));

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	public void clickMealPlanCheckBox() {

		try {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath(
					"html/body/div[29]/div[2]/div[1]/span/div/div/div[2]/table/tbody/tr[3]/td[4]/table/tbody/tr[1]/td[2]/div/input[29]"));
			if (!ele.isSelected()) {
				uiClick(ele);
				System.out.println("true");

			}
		} catch (Exception e) {
			Log.error("Error", e);
			
		}

	}

	public void clickBook() {

		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("html/body/div[29]/div[2]/div[1]/span/div/div/div[3]/div[2]/button")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void clickSave() {

		try {
			Thread.sleep(3000);
			uiClick(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/button")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public HomeScreen clickClose() {

		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("btnClose")));
			HomeScreen HomePg = new HomeScreen(driver);
			return HomePg;
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
		return null;

	}

	// Methods for TC_158Make Normal reservations in Bulk NRC_141
	// Select room type in room details
	public void selectRoomTypeRoomDetails(String selectRTRdetails) {
		try {
			Thread.sleep(2000);
			Select dropDownRoomTypeRoomDetails = new Select(driver
					.findElement(By.xpath("//form[@id='frmResDetail']/table//tr/td/select[@name='hotelRoomTypeId']")));
			dropDownRoomTypeRoomDetails.selectByVisibleText(selectRTRdetails);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// select billing room type
	public void selectBillingRT(String billingRT) {
		try {
			Thread.sleep(2000);
			Select dropDownRoomTypeRoomDetails = new Select(driver.findElement(By.id("selBRoomType")));
			dropDownRoomTypeRoomDetails.selectByVisibleText(billingRT);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}
	// input DBL
	// html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div[2]/form[2]/table/tbody/tr[1]/td/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[3]/input

	public void inputDBL(int inputDBL) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div[2]/form[2]/table/tbody/tr[1]/td/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[3]/input")),String.valueOf(inputDBL));
					
				
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void inputSGL(String inputSGL) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div[2]/form[2]/table/tbody/tr[1]/td/div[1]/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[2]/input")), inputSGL);
		} catch (Exception e) {
		
			Log.error("Error", e);
		}
	}

	// partner email
	public void inputPartnerEmail(String inputPartnerEmail) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[2]/div[1]/div[2]/div/div[2]/form[1]/div/table/tbody/tr[1]/td[2]/input[2]")), inputPartnerEmail);
			
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}
	// market

	public void inputMarket(String inputMarket) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[2]/div[1]/div[2]/div/div[2]/form[1]/div/table/tbody/tr[4]/td[2]/input[3]")), inputMarket);
			
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// input meal plan drop down
	public void selectMealPlan(String mealPLan) {
		try {
			Thread.sleep(2000);
			Select dropDownRoomTypeRoomDetails = new Select(driver.findElement(By.id("selMealPlan")));
			dropDownRoomTypeRoomDetails.selectByVisibleText(mealPLan);
		} catch (Exception e) {
		
			Log.error("Error", e);
		}
	}
	// select day use

	public void TickDayUse() {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("chkDayUse")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	// input market by drop down
	public void inputMarketByDropDown() {
		try {
			Thread.sleep(2000);
		uiClick(driver.findElement(By.xpath("//div[@class='autocomplete-w1']/div/div[@title='All Market']")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}
}