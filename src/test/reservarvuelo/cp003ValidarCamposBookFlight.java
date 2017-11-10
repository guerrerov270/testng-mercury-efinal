package test.reservarvuelo;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.PagesFacade;
import pageObjects.SelectFlightPage;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.LoginUtil;
import utils.ExcelUtils.ExcelType;

public class cp003ValidarCamposBookFlight extends TestBase {

	PagesFacade facade;
	LoginUtil login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	static ExcelUtils excelCamposBookFlight;
	private String nombreInputFirstName = "";
	private String nombreInputLastName = "";
	private String nombreComboMeal = "";
	private String nombreComboCardType = "";
	private String nombreInputNumber = "";
	private String nombreComboExpirationMonth = "";
	private String nombreComboExpirationYear = "";
	private String nombreInputFirstNameCard = "";
	private String nombreInputMiddleNameCard = "";
	private String nombreInputLastNameCard = "";
	private String nombreCheckTicketLess = "";
	private String nombreInputBillAddress1 = "";
	private String nombreInputBillAddress2 = "";
	private String nombreInputBillCity = "";
	private String nombreInputBillState = "";
	private String nombreInputBillPostal = "";
	private String nombreComboBillCountry = "";
	private String nombreCheckBillingAddress = "";
	private String nombreInputDelAddress1 = "";
	private String nombreInputDelAddress2 = "";
	private String nombreInputDelCity = "";
	private String nombreInputDelState = "";
	private String nombreInputDelPostal = "";
	private String nombreComboDelCountry = "";
	private String nombreButtonBuyFlights = "";
	

	@Test
	public void login() {

		login = new LoginUtil();
		login.hacerLogin();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposBookFlight() throws Exception {
		
		facade= new PagesFacade();
		findFlight = facade.getFindFlight();
		findFlight.clickButtonLink(findFlight.getButtonContinue());
		selectFlight = facade.getSelectFlight();
		selectFlight.clickButtonLink(selectFlight.getButtonContinue());
		bookFlight = facade.getBookFlight();
		
		try {
			excelCamposBookFlight = new ExcelUtils("CamposBookAFlight.xlsx",
					ExcelType.XLSX);
			nombreInputFirstName = excelCamposBookFlight.getCellData(1, 0);
			nombreInputLastName = excelCamposBookFlight.getCellData(2, 0);
			nombreComboMeal = excelCamposBookFlight.getCellData(3, 0);
			nombreComboCardType = excelCamposBookFlight.getCellData(4, 0);
			nombreInputNumber = excelCamposBookFlight.getCellData(5, 0);
			nombreComboExpirationMonth = excelCamposBookFlight.getCellData(6, 0);
			nombreComboExpirationYear = excelCamposBookFlight.getCellData(7, 0);
			nombreInputFirstNameCard = excelCamposBookFlight.getCellData(8, 0);
			nombreInputMiddleNameCard = excelCamposBookFlight.getCellData(9, 0);
			nombreInputLastNameCard = excelCamposBookFlight.getCellData(10, 0);
			nombreCheckTicketLess = excelCamposBookFlight.getCellData(11, 0);
			nombreInputBillAddress1 = excelCamposBookFlight.getCellData(12, 0);
			nombreInputBillAddress2 = excelCamposBookFlight.getCellData(13, 0);
			nombreInputBillCity = excelCamposBookFlight.getCellData(14, 0);
			nombreInputBillState = excelCamposBookFlight.getCellData(15, 0);
			nombreInputBillPostal = excelCamposBookFlight.getCellData(16, 0);
			nombreComboBillCountry = excelCamposBookFlight.getCellData(17, 0);
			nombreCheckBillingAddress = excelCamposBookFlight.getCellData(18, 0);
			nombreInputDelAddress1 = excelCamposBookFlight.getCellData(19, 0);
			nombreInputDelAddress2 = excelCamposBookFlight.getCellData(20, 0);
			nombreInputDelCity = excelCamposBookFlight.getCellData(21, 0);
			nombreInputDelState = excelCamposBookFlight.getCellData(22, 0);
			nombreInputDelPostal = excelCamposBookFlight.getCellData(23, 0);
			nombreComboDelCountry = excelCamposBookFlight.getCellData(24, 0);
			nombreButtonBuyFlights = excelCamposBookFlight.getCellData(25, 0);

		} catch (IOException e2) {

			System.out
					.println("*******************ATENCIÓN*******************************");
			System.out.println(e2.getMessage());
			System.out
					.println("**********************************************************");
		}

		// Validar que esté en la página Book a flight
		try {
			// Validar los campos del área Passengers
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputFirstName()))) {
				throw new ElementoNoEncontradoException(nombreInputFirstName);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputLastName()))) {
				throw new ElementoNoEncontradoException(nombreInputLastName);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboMeal()))) {
				throw new ElementoNoEncontradoException(nombreComboMeal);
			}
			// Validar los campos del área área Credit Card
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboCardType()))) {
				throw new ElementoNoEncontradoException(nombreComboCardType);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputNumber()))) {
				throw new ElementoNoEncontradoException(nombreInputNumber);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboExpirationMonth()))) {
				throw new ElementoNoEncontradoException(nombreComboExpirationMonth);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboExpirationYear()))) {
				throw new ElementoNoEncontradoException(nombreComboExpirationYear);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputFirstNameCard()))) {
				throw new ElementoNoEncontradoException(nombreInputFirstNameCard);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputMiddleNameCard()))) {
				throw new ElementoNoEncontradoException(nombreInputMiddleNameCard);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputLastNameCard()))) {
				throw new ElementoNoEncontradoException(nombreInputLastNameCard);
			}
			// Validar los campos del área área Billing address
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getCheckTicketLess()))) {
				throw new ElementoNoEncontradoException(nombreCheckTicketLess);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillAddress1()))) {
				throw new ElementoNoEncontradoException(nombreInputBillAddress1);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillAddress2()))) {
				throw new ElementoNoEncontradoException(nombreInputBillAddress2);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillCity()))) {
				throw new ElementoNoEncontradoException(nombreInputBillCity);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillState()))) {
				throw new ElementoNoEncontradoException(nombreInputBillState);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillPostal()))) {
				throw new ElementoNoEncontradoException(nombreInputBillPostal);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboBillCountry()))) {
				throw new ElementoNoEncontradoException(nombreComboBillCountry);
			}
			// Validar los campos del área área Delivery address
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getCheckBillingAddress()))) {
				throw new ElementoNoEncontradoException(nombreCheckBillingAddress);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelAddress1()))) {
				throw new ElementoNoEncontradoException(nombreInputDelAddress1);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelAddress2()))) {
				throw new ElementoNoEncontradoException(nombreInputDelAddress2);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelCity()))) {
				throw new ElementoNoEncontradoException(nombreInputDelCity);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelState()))) {
				throw new ElementoNoEncontradoException(nombreInputDelState);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelPostal()))) {
				throw new ElementoNoEncontradoException(nombreInputDelPostal);
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboDelCountry()))) {
				throw new ElementoNoEncontradoException(nombreComboDelCountry);
			}
			// Validar el botón secure purchase
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getButtonBuyFlights()))) {
				throw new ElementoNoEncontradoException(nombreButtonBuyFlights);
			}
		} catch (ElementoNoEncontradoException e3) {
			System.out.println(e3.getDescripcion() + e3.getMessage());
		}		

	}// Fin método ValidarCamposBookFlight

}// Fin clase cp003ValidarCamposBookFlight
