package com.Zhara.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.Zhara.Log;

public class CasheringManagerObject extends BasePageObject {

	public CasheringManagerObject(WebDriver driver1) {
		super(driver1);
		
	}
	
	public void selectRecord( ) {

		try {
			
			Thread.sleep(20000);
			driver.switchTo().defaultContent();
			driver.switchTo().parentFrame();
			driver.switchTo().frame("main");
		
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='frmTabmenu_spnTabMenus_0']")));
			uiClick(driver.findElement(By.xpath("//html/body/table/tbody/tr[3]/td/div[2]/div[2]/div/table/tbody/tr[3]/td[2]")));
			
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//click add posting  id = btnPostings
	public void addPosting( ) {

		try {
			Thread.sleep(2000);
			
			uiClick(driver.findElement(By.id("btnPostings")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//select normal
	public void selectNormalRadioBtn( ) {

		try {
			Thread.sleep(3000);
			driver.switchTo().parentFrame();
			Thread.sleep(3000);
			driver.switchTo().frame("frmTabmenu_spnTabMenus_1");
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("normalPostings")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//select entry type extra
	public void selectEntryTypeRadioBtn( ) {

		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("entryTypeExtr")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//selectrevenue type drop down
	public void RevenueCodeDropDown( int revenueCode) {

		try {
			Thread.sleep(2000);
			Select revenueCodeDropDown = new Select(driver.findElement(By.id("revenueCodeId")));
			revenueCodeDropDown.selectByIndex(revenueCode);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	public void RevenueTypeDropDown( int revenueType) {

		try {
			Thread.sleep(2000);
			Select revenueTypeDropDown = new Select(driver.findElement(By.id("revenueCodeType")));
			revenueTypeDropDown.selectByIndex(revenueType);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//Add an amount  
	public void amount( String amount) {

		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.id("amount")), amount);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	
	//AmountTest
	public void amountTest( int amount) {

		try {
			Thread.sleep(2000);
			uiSendKeys(driver.findElement(By.id("amount")),String.valueOf(amount));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//Tick amount include withTax
	public void includeTax(){

		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("withTax")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//click + button
	public void clickPluseBtn(){

		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("btnAdd")));
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//click pop up ok button
	public void popUpOk(){

		try {
			Thread.sleep(2000);
			uiClick(driver.findElement(By.id("popup_ok")));
			
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}
	//click save button
		public void btnSave(){

			try {
				Thread.sleep(2000);
				uiClick(driver.findElement(By.id("btnSave")));

			} catch (Exception e) {
				
				Log.error("Error", e);
			}

		}
	//nvigate to chashiring manager
		public void closeBtn() {

			try {
				Thread.sleep(2000);
				uiClick(driver.findElement(By.id("btnClose")));
				
			} catch (Exception e) {
				
				Log.error("Error", e);
			}

		}
		
		//click search to refresh 
		public void search() {

			try {
				Thread.sleep(2000);
				uiClick(driver.findElement(By.xpath("//html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/form/div/div/button[2]")));
				
			} catch (Exception e) {
				
				Log.error("Error", e);
			}

		}
}
