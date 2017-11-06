package test.reservarvuelo;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;

public class cp003ValidarCamposBookFlight extends TestBase {

	cp002LoginMercuryCorrecto login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	String pageTitle = "Welcome: Mercury Tours";
	String pageTitleFind = "Find a Flight: Mercury Tours";
	String pageTitleSelect = "Select a Flight: Mercury Tours";
	String pageTitleBook = "Book a Flight: Mercury Tours";

	@Test
	public void login() {

		login = new cp002LoginMercuryCorrecto();
		login.loginCorrecto();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposBookFlight() throws Exception {
		findFlight = new FindFlightPage(driver, pageTitleFind);
		findFlight.clickButtonLink(findFlight.getButtonContinue());
		selectFlight = new SelectFlightPage(driver, pageTitleSelect);
		selectFlight.clickButtonLink(selectFlight.getBtnContinue());
		bookFlight = new BookFlightPage(driver, pageTitleBook);

		// Validar que esté en la página Book a flight
		if (bookFlight.getTitle().equals(pageTitleBook)) {
			// Validar los campos del área Passengers
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputFirstName()))) {
				Assert.fail("No se encontró el input first name 0");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputLastName()))) {
				Assert.fail("No se encontró el input last name 0");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboMeal()))) {
				Assert.fail("No se encontró el select meal 0");
			}
			// Validar los campos del área área Credit Card
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboCardType()))) {
				Assert.fail("No se encontró el select credit card");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputNumber()))) {
				Assert.fail("No se encontró el input credit number");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboExpirationMonth()))) {
				Assert.fail("No se encontró el select expirate month cc");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboExpirationYear()))) {
				Assert.fail("No se encontró el select expirate year cc");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputFirstNameCard()))) {
				Assert.fail("No se encontró el input first name cc");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputMiddleNameCard()))) {
				Assert.fail("No se encontró el input middle name cc");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputLastNameCard()))) {
				Assert.fail("No se encontró el input last name cc");
			}
			// Validar los campos del área área Billing address
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getCheckTicketLess()))) {
				Assert.fail("No se encontró el check ticket less");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillAddress1()))) {
				Assert.fail("No se encontró el input bill address 1");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillAddress2()))) {
				Assert.fail("No se encontró el input bill address 2");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillCity()))) {
				Assert.fail("No se encontró el input bill city");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillState()))) {
				Assert.fail("No se encontró el input bill state");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputBillPostal()))) {
				Assert.fail("No se encontró el input bill postal code");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboBillCountry()))) {
				Assert.fail("No se encontró el select bill country");
			}
			// Validar los campos del área área Delivery address
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getCheckBillingAddress()))) {
				Assert.fail("No se encontró el check billing address");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelAddress1()))) {
				Assert.fail("No se encontró el input del address 1");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelAddress2()))) {
				Assert.fail("No se encontró el input del address 2");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelCity()))) {
				Assert.fail("No se encontró el input del city");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelState()))) {
				Assert.fail("No se encontró el input del state");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getInputDelPostal()))) {
				Assert.fail("No se encontró el input del postal code");
			}
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getComboDelCountry()))) {
				Assert.fail("No se encontró el select del country");
			}
			// Validar el botón secure purchase
			if (!(bookFlight.isElementPresentAndDisplay(bookFlight
					.getButtonBuyFlights()))) {
				Assert.fail("No se encontró el button buy flights");
			}

		} else {
			Assert.fail("No se encuentra en la página Book a Flight");
		}

	}

}
