package com.Zhara.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Zhara.Log;

public class CreateRatePageObject extends BasePageObject {

	public CreateRatePageObject(WebDriver driver1) {
		super(driver1);
	}

	// Select rate type radio button
	public void clickRateType() {
		try {
			driver.switchTo().parentFrame();
			Thread.sleep(5000);
			driver.switchTo().frame(driver.findElement(By.id("frmTabmenu_spnTabMenus_1")));
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='mealPartyType']")).click();
		} catch (Exception e) {
			Log.error("Error in selecting meal type" + e);
		}
	}

	// RatePlanPrefix
	public void inputRtaeplan(String ratePrefix) {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='ratePlanPrefix']")).sendKeys(ratePrefix);
		} catch (Exception e) {
			Log.error("Error in Rate plan prefix" + e);
		}
	}

	public void inputValidFrom(String validFrom) {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='contractValidFrom']")).sendKeys(validFrom);
		} catch (Exception e) {
			Log.error("Error valid from date" + e);
		}
	}
	// input date

	public void inputDate(String inputDate) {
		try {
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//*[@id='contractedDate']"));
			element.clear();
			element.sendKeys(inputDate);
		} catch (Exception e) {
			Log.error("Error date" + e);
		}
	}

	// valid to
	public void inputValidTo(String validTo) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//*[@id='contractValidTo']")), validTo);

		} catch (Exception e) {
			Log.error("Error valid to date" + e);
		}
	}

	// select rate category
	public void selectRateCategory(int rateCategory) {
		try {
			Thread.sleep(2000);
			Select dropDownRateCategory = new Select(driver.findElement(By.name("rateCatId")));
			dropDownRateCategory.selectByIndex(rateCategory);
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// select currency from drop down
	public void selectCurrency(String currency) {
		try {
			Thread.sleep(2000);
			Select dropDownRateCategory = new Select(driver.findElement(By.name("exchangeRateId")));
			dropDownRateCategory.selectByVisibleText(currency);
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// click save
	public void clicksave() {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("//*[@id='btnSave']")));
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// navigate ro meal party tab
	public void navigateMealParty() {
		try {
			Thread.sleep(2000);
		uiClick(driver.findElement(By.xpath("//*[@id='tabs']/ul/li[9]/a/font")));

		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// enter day use room rate
	public void enterDayUseRoomRate(int rate) {
		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.xpath("//form[@id='frmMPartyData']/table//tr[3]/td/input[@id='mealPartyRate']")), String.valueOf(rate));
			

		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// click sve button in meal party

	public void saveMealParty() {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/button")));

		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// add button
	public void addButton() {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("//*[@id='btnDetGridAdd']")));
	
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}

	// send for approval
	public void sendApproval() {
		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.xpath("//*[@id='btnApprove']")));
			
		} catch (Exception e) {
			Log.error("Error", e);
		}
	}
}
