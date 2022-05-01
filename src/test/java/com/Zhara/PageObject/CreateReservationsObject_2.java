package com.Zhara.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Zhara.Log;

public class CreateReservationsObject_2 extends BasePageObject {
	public CreateReservationsObject_2(WebDriver driver1) {
		
		super(driver1);

	}

	public void enterHotelName(String hotelName) {

		try {
			// driver.switchTo().defaultContent();
			driver.switchTo().frame("frmTabmenu_spnTabMenus_0");
			Thread.sleep(2000);
			Select dropDownHotelName = new Select(driver.findElement(By.id("selHotel")));
			Thread.sleep(2000);
			dropDownHotelName.selectByValue(hotelName);
		} catch (Exception e) {
			Log.error("Error", e);
		}

	}

	// select hotel by index
	/*
	 * public void enterHotelName(String hotelName) {
	 * 
	 * try { //driver.switchTo().defaultContent();
	 * driver.switchTo().frame("frmTabmenu_spnTabMenus_0"); Thread.sleep(2000);
	 * Select dropDownHotelName = new
	 * Select(driver.findElement(By.id("selHotel"))); Thread.sleep(2000);
	 * 
	 * dropDownHotelName.selectByIndex(Integer.parseInt(hotelName)); } catch
	 * (Exception e) { String message = null; Log.error(message, e); }
	 * 
	 * }
	 */

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
			uiClick(driver.findElement(By.xpath("//*[@id='searchDepartureDate']")));
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

	public void inputNoOfRooms(String inputNoOfRooms) {
		try {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath(
					"html/body/div[1]/div[1]/div[1]/div[1]/table/tbody/tr[2]/td/div/div[2]/table/tbody/tr/td[1]/div[1]/div[2]/form/table[1]/tbody/tr[4]/td/table/tbody/tr/td[2]/input"));
			Integer.parseInt(inputNoOfRooms);
			ele.sendKeys(inputNoOfRooms);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void inputPartner(String inputPartner) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.id("searchGuestPartnerLookup")), inputPartner);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void inputPartnerByDropDown() throws Exception {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("//div[@class='autocomplete-w1']/div/div/strong[text()='FIT Local']")));
		} catch (Exception e) {
		
			Log.error("Error", e);
		}
	}

	public void clickCreateRoom() throws Exception {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("btnShowRates")));

		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	public void clickMealPlanCheckBox() throws Exception {

		try {
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath(
					"html/body/div[29]/div[2]/div[1]/span/div/div/div[2]/table/tbody/tr[3]/td[4]/table/tbody/tr[1]/td[2]/div/input[29]"));
			if (!ele.isSelected()) {
				ele.click();
				System.out.println("true");

			}
			//select second room type
			Thread.sleep(2000);
			WebElement ele2 = driver.findElement(By.xpath(
					"html/body/div[29]/div[2]/div[1]/span/div/div/div[2]/table/tbody/tr[4]/td[4]/table/tbody/tr[1]/td[2]/div/input[29]"));
			if (!ele2.isSelected()) {
				ele2.click();
				System.out.println("true");

			}
			
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	public void clickBook() throws Exception {

		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("html/body/div[29]/div[2]/div[1]/span/div/div/div[3]/div[2]/button")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public void clickSave() throws Exception {
		Thread.sleep(3000);
		uiClick(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/button")));
		try {

		} catch (Exception e) {
			
			Log.error("Error", e);
		}
	}

	public HomeScreen clickClose() throws Exception {
		Thread.sleep(2000);
		uiClick(driver.findElement(By.id("btnClose")));
		HomeScreen HomePg = new HomeScreen(driver);
		return HomePg;
	}
}
