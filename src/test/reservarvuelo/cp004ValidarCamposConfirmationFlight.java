package test.reservarvuelo;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;

public class cp004ValidarCamposConfirmationFlight extends TestBase {

	cp002LoginMercuryCorrecto login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	String pageTitle = "Welcome: Mercury Tours";
	String pageTitleFind = "Find a Flight: Mercury Tours";
	String pageTitleSelect = "Select a Flight: Mercury Tours";
	// Completar
	String pageTitleBook = "Book a Flight: Mercury Tours";
	String pageTitleConfirmation = "Flight Confirmation: Mercury Tours";

	@Test
	public void login() {

		login = new cp002LoginMercuryCorrecto();
		login.loginCorrecto();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposConfirmationFlight() throws Exception {
		findFlight = new FindFlightPage(driver, pageTitleFind);
		findFlight.clickButtonLink(findFlight.getButtonContinue());
		selectFlight = new SelectFlightPage(driver, pageTitleSelect);
		selectFlight.clickButtonLink(selectFlight.getBtnContinue());
		bookFlight = new BookFlightPage(driver, pageTitleBook);
		// Clic en botón Secure purchase
		bookFlight.clickButtonLink(bookFlight.getButtonBuyFlights());
		confirmationFlight = new FlightConfirmationPage(driver,
				pageTitleConfirmation);

		// Validar que esté en la página Book a flight
		if (confirmationFlight.getTitle().equals(pageTitleConfirmation)) {

			// Validar estén presentes los tres botones
			if (!(confirmationFlight
					.isElementPresentAndDisplay(confirmationFlight
							.getButtonBackToFlights()))) {
				Assert.fail("No se encontró el botón back to flights");
			}
			if (!(confirmationFlight
					.isElementPresentAndDisplay(confirmationFlight
							.getButtonBackToHome()))) {
				Assert.fail("No se encontró el botón back to home");
			}
			if (!(confirmationFlight
					.isElementPresentAndDisplay(confirmationFlight
							.getButtonLogOut()))) {
				Assert.fail("No se encontró el botón log out");
			}
		} else {
			Assert.fail("No se encuentra en la página Confirmation Flight");
		}

	}
}
