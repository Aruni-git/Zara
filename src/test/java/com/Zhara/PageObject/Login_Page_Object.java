package com.Zhara.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Zhara.Log;


public class Login_Page_Object extends BasePageObject {
	public Login_Page_Object(WebDriver driver1) {
		super(driver1);
		
	}

	private WebElement signInBtn;

	public void enterUserName(String userName) {

		try {
			driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys(userName);
			Thread.sleep(2000);
		} catch (Exception e) {
			
			Log.error("Error", e);
		}

	}

	public void enterPwd(String password) {
		
		try {
		driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(password);;
			Thread.sleep(2000);
		} catch (Exception e) {
			Log.error("Error", e);
			
		}

	}

	public HomeScreen clickSignIn() throws Exception {
		signInBtn = driver.findElement(By.id("btnLogin"));
		HomeScreen HomePg = new HomeScreen(driver);
		signInBtn.click();
		Thread.sleep(5000);
		return HomePg;
	}
}
