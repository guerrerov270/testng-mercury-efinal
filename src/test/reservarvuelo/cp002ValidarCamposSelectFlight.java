package test.reservarvuelo;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.FindFlightPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;

public class cp002ValidarCamposSelectFlight extends TestBase {

	cp002LoginMercuryCorrecto login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	String pageTitle = "Welcome: Mercury Tours";
	String pageTitleFind = "Find a Flight: Mercury Tours";
	String pageTitleSelect = "Select a Flight: Mercury Tours";

	@Test
	public void login() {

		login = new cp002LoginMercuryCorrecto();
		login.loginCorrecto();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposSelectFlight() throws Exception {
		findFlight = new FindFlightPage(driver, pageTitleFind);
		findFlight.clickButtonLink(findFlight.getButtonContinue());
		selectFlight = new SelectFlightPage(driver, pageTitleSelect);

		// Validar que se encuentre en la página Select a Flight: Mercury Tours
		if (selectFlight.getTitle().equals(pageTitleSelect)) {

			// verifico los elementos en la página
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioButtonoutFlight()))) {
				Assert.fail("No se encontró el radio button Blue Skies Airlines 360");
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioButtoninFlight()))) {
				Assert.fail("No se encontró el radio button Blue Skies Airlines 361");
			}

			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getBtnContinue()))) {
				Assert.fail("No se encontró el botón Continue");
			}

		} else {
			Assert.fail("No se encuentra en la página Select Flight");
		}
	}

}
