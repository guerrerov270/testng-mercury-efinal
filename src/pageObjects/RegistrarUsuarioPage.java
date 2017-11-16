package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

/**
 * Clase que contiene los WebElements de
 * http://newtours.demoaut.com/mercuryregister.php
 * 
 * @author anamariaquinteroleal
 *
 */
public class RegistrarUsuarioPage extends PageBase {

	/**
	 * @param driver
	 * @param pageTitle
	 */
	public RegistrarUsuarioPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// WebElements

	/**
	 * Área Contact Information
	 */
	@FindBy(how = How.NAME, using = "firstName")
	private WebElement inputFirstName;
	@FindBy(how = How.NAME, using = "lastName")
	private WebElement inputLastName;
	@FindBy(how = How.NAME, using = "phone")
	private WebElement inputPhone;
	@FindBy(how = How.ID, using = "userName")
	private WebElement inputEmail;

	/**
	 * Área Mailing Information
	 */
	@FindBy(how = How.NAME, using = "address1")
	private WebElement inputAddress1;
	@FindBy(how = How.NAME, using = "address2")
	private WebElement inputAddres2;
	@FindBy(how = How.NAME, using = "city")
	private WebElement inputCity;
	@FindBy(how = How.NAME, using = "state")
	private WebElement inputState;
	@FindBy(how = How.NAME, using = "postalCode")
	private WebElement inputPostalCode;
	@FindBy(how = How.NAME, using = "country")
	private WebElement selectCountry;

	/**
	 * Área de User Information
	 */
	@FindBy(how = How.NAME, using = "email")
	private WebElement inputEmailUser;
	@FindBy(how = How.NAME, using = "password")
	private WebElement inputPassword;
	@FindBy(how = How.NAME, using = "confirmPassword")
	private WebElement inputConfirmPassword;

	// Submit button
	@FindBy(how = How.NAME, using = "register")
	private WebElement buttonRegister;

	public void registrarInformacionContacto(String firstName, String lastName,
			String phone, String email) {

		sendText(inputFirstName, firstName);
		sendText(inputLastName, lastName);
		sendText(inputPhone, phone);
		sendText(inputEmail, email);
	}

	public void registrarInformacionCorreo(String address1, String address2,
			String city, String state, String postalCode, String country) {

		sendText(inputAddress1, address1);
		sendText(inputAddres2, address2);
		sendText(inputCity, city);
		sendText(inputState, state);
		sendText(inputPostalCode, postalCode);
		// Select country
		selectDropdownVisibleText(selectCountry, country);
	}

	public void registrarInformacionUsuario(String userName, String password,
			String confirmPassword) {

		sendText(inputEmailUser, userName);
		sendText(inputPassword, password);
		sendText(inputConfirmPassword, confirmPassword);
		clickButtonLink(buttonRegister);
	}

	// Getters

	public WebElement getInputFirstName() {
		return inputFirstName;
	}

	public WebElement getInputLastName() {
		return inputLastName;
	}

	public WebElement getInputPhone() {
		return inputPhone;
	}

	public WebElement getInputImail() {
		return inputEmail;
	}

	public WebElement getInputAddress1() {
		return inputAddress1;
	}

	public WebElement getInputAddres2() {
		return inputAddres2;
	}

	public WebElement getInputCity() {
		return inputCity;
	}

	public WebElement getInputState() {
		return inputState;
	}

	public WebElement getInputPostalCode() {
		return inputPostalCode;
	}

	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public WebElement getInputEmailUser() {
		return inputEmailUser;
	}

	public WebElement getInputPassword() {
		return inputPassword;
	}

	public WebElement getInputConfirmPassword() {
		return inputConfirmPassword;
	}

	public WebElement getButtonRegister() {
		return buttonRegister;
	}

}
