package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class BookFlightPage extends PageBase {

	/**
	 * Clase que contiene los webElements de
	 * http://newtours.demoaut.com/mercurypurchase.php
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public BookFlightPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// Área Passenger
	@FindBy(how = How.NAME, using = "passFirst0")
	private WebElement inputFirstName;
	@FindBy(how = How.NAME, using = "passLast0")
	private WebElement inputLastName;
	@FindBy(how = How.NAME, using = "pass.0.meal")
	private WebElement comboMeal;

	// Área Credit Card
	@FindBy(how = How.NAME, using = "creditCard")
	private WebElement comboCardType;
	@FindBy(how = How.NAME, using = "creditnumber")
	private WebElement inputNumber;
	@FindBy(how = How.NAME, using = "cc_exp_dt_mn")
	private WebElement comboExpirationMonth;
	@FindBy(how = How.NAME, using = "cc_exp_dt_yr")
	private WebElement comboExpirationYear;
	@FindBy(how = How.NAME, using = "cc_frst_name")
	private WebElement inputFirstNameCard;
	@FindBy(how = How.NAME, using = "cc_mid_name")
	private WebElement inputMiddleNameCard;
	@FindBy(how = How.NAME, using = "cc_last_name")
	private WebElement inputLastNameCard;

	// Área Billing Address
	@FindBy(how = How.CSS, using = "[name='ticketLess'][value*='checkbox']")
	private WebElement checkTicketLess;
	@FindBy(how = How.NAME, using = "billAddress1")
	private WebElement inputBillAddress1;
	@FindBy(how = How.NAME, using = "billAddress2")
	private WebElement inputBillAddress2;
	@FindBy(how = How.NAME, using = "billCity")
	private WebElement inputBillCity;
	@FindBy(how = How.NAME, using = "billState")
	private WebElement inputBillState;
	@FindBy(how = How.NAME, using = "billZip")
	private WebElement inputBillPostal;
	@FindBy(how = How.NAME, using = "billCountry")
	private WebElement comboBillCountry;

	// Área Delivery Address
	@FindBy(how = How.CSS, using = "[name='ticketLess'][value*='checkbox']")
	private WebElement checkBillingAddress;

	@FindBy(how = How.NAME, using = "delAddress1")
	private WebElement inputDelAddress1;
	@FindBy(how = How.NAME, using = "delAddress2")
	private WebElement inputDelAddress2;
	@FindBy(how = How.NAME, using = "delCity")
	private WebElement inputDelCity;
	@FindBy(how = How.NAME, using = "delState")
	private WebElement inputDelState;
	@FindBy(how = How.NAME, using = "delZip")
	private WebElement inputDelPostal;
	@FindBy(how = How.NAME, using = "delCountry")
	private WebElement comboDelCountry;

	// Secure purchase
	@FindBy(how = How.NAME, using = "buyFlights")
	private WebElement buttonBuyFlights;

	public WebElement getButtonBuyFlights() {
		return buttonBuyFlights;
	}

	public WebElement getInputFirstName() {
		return inputFirstName;
	}

	public WebElement getInputLastName() {
		return inputLastName;
	}

	public WebElement getComboMeal() {
		return comboMeal;
	}

	public WebElement getComboCardType() {
		return comboCardType;
	}

	public WebElement getInputNumber() {
		return inputNumber;
	}

	public WebElement getComboExpirationMonth() {
		return comboExpirationMonth;
	}

	public WebElement getComboExpirationYear() {
		return comboExpirationYear;
	}

	public WebElement getInputFirstNameCard() {
		return inputFirstNameCard;
	}

	public WebElement getInputMiddleNameCard() {
		return inputMiddleNameCard;
	}

	public WebElement getInputLastNameCard() {
		return inputLastNameCard;
	}

	public WebElement getInputBillAddress1() {
		return inputBillAddress1;
	}

	public WebElement getInputBillAddress2() {
		return inputBillAddress2;
	}

	public WebElement getInputBillCity() {
		return inputBillCity;
	}

	public WebElement getInputBillState() {
		return inputBillState;
	}

	public WebElement getInputBillPostal() {
		return inputBillPostal;
	}

	public WebElement getComboBillCountry() {
		return comboBillCountry;
	}

	public WebElement getInputDelAddress1() {
		return inputDelAddress1;
	}

	public WebElement getInputDelAddress2() {
		return inputDelAddress2;
	}

	public WebElement getInputDelCity() {
		return inputDelCity;
	}

	public WebElement getInputDelState() {
		return inputDelState;
	}

	public WebElement getInputDelPostal() {
		return inputDelPostal;
	}

	public WebElement getComboDelCountry() {
		return comboDelCountry;
	}

	public WebElement getCheckBillingAddress() {
		return checkBillingAddress;
	}

	public WebElement getCheckTicketLess() {
		return checkTicketLess;
	}

	public void seleccionBookAFlight(String firstName, String lastName,
			String meal, String cardType, String cardNumber, String expCMonth,
			String expCYear, String cardFirstName, String cardMiddleNane,
			String cardLastName, boolean ticketless, String address1Bill,
			String address2Bill, String cityBill, String stateBill,
			String postalCodeBill, String countryBill,
			boolean sameAsBillingAddress, String address1Del,
			String address2Del, String cityDel, String stateDel,
			String postalCodeDel, String countryDel) {

		sendText(inputFirstName, firstName);
		sendText(inputLastName, lastName);
		selectDropdownVisibleText(comboMeal, meal);

		selectDropdownVisibleText(comboCardType, cardType);
		sendText(inputNumber, cardNumber);
		selectDropdownVisibleText(comboExpirationMonth, expCMonth);
		selectDropdownVisibleText(comboExpirationYear, expCYear);
		sendText(inputFirstNameCard, cardFirstName);
		sendText(inputMiddleNameCard, cardMiddleNane);
		sendText(inputLastNameCard, cardLastName);

		if (ticketless) {
			// Selecciono el check
			checkTicketLess.click();
		}

		inputBillAddress1.clear();
		sendText(inputBillAddress1, address1Bill);
		sendText(inputBillAddress2, address2Bill);
		inputBillCity.clear();
		sendText(inputBillCity, cityBill);
		inputBillState.clear();
		sendText(inputBillState, stateBill);
		inputBillPostal.clear();
		sendText(inputBillPostal, postalCodeBill);
		selectDropdownVisibleText(comboBillCountry, countryBill);

		if (sameAsBillingAddress) {
			// Selecciono el check
			checkBillingAddress.click();
		}

		inputDelAddress1.clear();
		sendText(inputDelAddress1, address1Del);
		sendText(inputDelAddress2, address2Del);
		inputDelCity.clear();
		sendText(inputDelCity, cityDel);
		inputDelState.clear();
		sendText(inputDelState, stateDel);
		inputDelPostal.clear();
		sendText(inputDelPostal, postalCodeDel);
		selectDropdownVisibleText(comboDelCountry, countryDel);

		clickButtonLink(buttonBuyFlights);

	}// Fin método seleccionBookAFlight

}
