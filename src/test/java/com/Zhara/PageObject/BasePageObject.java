package com.Zhara.PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	static WebDriver driver;

	public BasePageObject(WebDriver driver1) {
		driver = driver1;
	}

	public void uiClick(WebElement uiElement) {
		uiElement.click();
	}

	public void uiSendKeys(WebElement uiElement, String value) {
		uiElement.clear();
		uiElement.sendKeys(value);
	}

	public Boolean uiIsDisplayed(WebElement uiElement) {
		if (uiElement.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void uiAlertOkBtnClick() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uiSelectByVisibleText(Select uiElement, String value) {
		uiElement.selectByVisibleText(value);
	}

	public void uiDeselectAll(Select uiElement) {
		uiElement.deselectAll();
	}

	public String uiGetText(WebElement uiElement) {
		return uiElement.getText();
	}

	public Boolean uiIsEnabled(WebElement uiElement) {

		boolean status;
		if (uiElement.isEnabled()) {
			status = true;
		} else {
			status = false;
		}

		return status;

	}

	public void uiClear(WebElement uiElement) {
		uiElement.clear();
	}

	public boolean uiWaitForElementPresent(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 240);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

		boolean status;
		if (element.isEnabled()) {
			status = true;
		} else {
			status = false;
		}

		return status;
	}

}
