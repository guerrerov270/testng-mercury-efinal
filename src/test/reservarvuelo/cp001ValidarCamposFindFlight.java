package test.reservarvuelo;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.FindFlightPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;

public class cp001ValidarCamposFindFlight extends TestBase {

	cp002LoginMercuryCorrecto login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	String pageTitle = "Welcome: Mercury Tours";
	String pageTitleFind = "Find a Flight: Mercury Tours";

	@Test
	public void login() {

		login = new cp002LoginMercuryCorrecto();
		login.loginCorrecto();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposFindFlight() throws Exception {
		findFlight = new FindFlightPage(driver, pageTitleFind);
		// Validación de los campos del área Preferences
		// verifico los elementos en la página
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getRadioRoundTrip()))) {
			Assert.fail("No se encontró el radio button Round trip");
		}
		if (!(findFlight
				.isElementPresentAndDisplay(findFlight.getRadioOneWay()))) {
			Assert.fail("No se encontró el radio button One way");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectPassengers()))) {
			Assert.fail("No se encontró el select Passengers");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectDepartingFrom()))) {
			Assert.fail("No se encontró el select Departing from");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectMonthIni()))) {
			Assert.fail("No se encontró el select On");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectDayIni()))) {
			Assert.fail("No se encontró el select para el día de inicio");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectArrivingIn()))) {
			Assert.fail("No se encontró el select Arriving in");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectReturning()))) {
			Assert.fail("No se encontró el select Returning");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getRadioRoundTrip()))) {
			Assert.fail("No se encontró el radio button Round trip");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectDayEnd()))) {
			Assert.fail("No se encontró el select para el día de llegada");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getRadioEconomyClass()))) {
			Assert.fail("No se encontró el radio button Economy class");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getRadioBussinessClass()))) {
			Assert.fail("No se encontró el radio button Business class");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getRadioFirstClass()))) {
			Assert.fail("No se encontró el radio button First class");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getSelectAirline()))) {
			Assert.fail("No se encontró el select Airline");
		}
		if (!(findFlight.isElementPresentAndDisplay(findFlight
				.getButtonContinue()))) {
			Assert.fail("No se encontró el botón Continue");
		}

	}

}