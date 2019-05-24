package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author lavanya Jan 11, 2019
 */
public class LoginPO {

	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "username")
	private WebElement username;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "Inpatient Ward")
	private WebElement inPatientWard;

	@FindBy(id = "loginButton")
	private WebElement loginBtn;

	/**
	 * Method to login
	 * 
	 * @param uname
	 * @param pwd
	 */
	public void loginDetails(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);

		inPatientWard.click();
		loginBtn.click();
	}
}
