/**
 * 
 */
package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author lavanya Jan 11, 2019
 */
public class RegistrationPO {

	WebDriver driver;

	@FindBy(linkText = "Register a patient")
	private WebElement registerAPatient;

	@FindBy(name = "givenName")
	private WebElement nameOfPatient;

	@FindBy(name = "familyName")
	private WebElement familyName;

	@FindBy(id = "genderLabel")
	private WebElement genderLabel;

	@FindBy(id = "gender-field")
	private WebElement genderField;

	// DOB Tab
	@FindBy(id = "birthdateLabel")
	private WebElement birthDateLabel;

	// DOB
	@FindBy(name = "birthdateDay")
	private WebElement birthDay;
	@FindBy(id = "birthdateMonth-field")
	private WebElement birthMonth;
	@FindBy(id = "birthdateYear-field")
	private WebElement birthYear;

	// Address
	@FindBy(xpath = "//span[contains(text(), 'Address')]")
	private WebElement AddressTab;

	@FindBy(id = "address1")
	private WebElement address1;

	@FindBy(id = "address2")
	private WebElement address2;

	// City
	@FindBy(id = "cityVillage")
	private WebElement cityVillage;
	// State
	@FindBy(id = "stateProvince")
	private WebElement state;
	// Country
	@FindBy(id = "country")
	private WebElement country;
	// ZIP
	@FindBy(id = "postalCode")
	private WebElement postalCode;

	@FindBy(xpath = "//span[contains(text(), 'Phone Number')]")
	private WebElement phoneNumberTab;

	@FindBy(name = "phoneNumber")
	private WebElement phoneNumber;

	@FindBy(xpath = "//span[contains(text(), 'Relatives')]")
	private WebElement relationshipTab;

	@FindBy(id = "relationship_type")
	private WebElement relationshipType;

	@FindBy(xpath = "//span[contains(text(), 'Confirm')]")
	private WebElement confirmBtn;

	@FindBy(id = "submit")
	private WebElement submitBtn;

	@FindBy(linkText = "Logout")
	private WebElement logOut;

	public RegistrationPO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * For Selecting Registration link
	 */
	public void tapToRegister() {
		registerAPatient.click();
	}

	/**
	 * Patient First and LastName
	 * 
	 * @param fName
	 * @param lName
	 */
	public void patientName(String fName, String lName) {
		nameOfPatient.sendKeys(fName);
		familyName.sendKeys(lName);
	}

	/**
	 * Method to select and set gender value from dropdown with visible text
	 * Male/Female
	 * 
	 * @param gender
	 */
	public void genderSelectionFromDropDown(String gender) {
		genderLabel.click();
		Select select = new Select(genderField);
		select.selectByVisibleText(gender);
	}

	/**
	 * Method to provide Date, Month and Year for DOB
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public void dateOfBirth(String day, String month, String year) {
		birthDateLabel.click();

		birthDay.sendKeys(day);
		Select select = new Select(birthMonth);
		select.selectByVisibleText(month);
		birthYear.sendKeys(year);
	}

	public void addressDetails() {
		AddressTab.click();

		address1.sendKeys("Hyderabad");
		address2.sendKeys("Hyderabad");
		cityVillage.sendKeys("Hyderabad");
		state.sendKeys("Telangana");
		country.sendKeys("India");
		postalCode.sendKeys("500002");

	}

	public void phoneNumber() {
		phoneNumberTab.click();
		phoneNumber.sendKeys("9898989898");
	}

	/**
	 * 
	 * @param relation
	 */
	public void relationShipTypeByDropDown(String relation) {
		relationshipTab.click();
		Select relations = new Select(relationshipType);
		relations.selectByVisibleText(relation);

	}

	public void confirmButton() {
		confirmBtn.click();
	}

	public void submitButton() {
		submitBtn.click();
	}

	public void logOutBtn() {
		logOut.click();
	}

}