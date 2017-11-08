package test.reservarvuelo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp004ValidarCamposConfirmationFlight extends TestBase {

	cp002LoginMercuryCorrecto login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	static ExcelUtils excelCamposConfirmationFlight;
	private String nombreButtonBackToFlights = "";
	private String nombreButtonBackToHome = "";
	private String nombreButtonLogOut = "";
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
		selectFlight.clickButtonLink(selectFlight.getButtonContinue());
		bookFlight = new BookFlightPage(driver, pageTitleBook);
		// Clic en botón Secure purchase
		bookFlight.clickButtonLink(bookFlight.getButtonBuyFlights());
		confirmationFlight = new FlightConfirmationPage(driver,
				pageTitleConfirmation);

		try {
			excelCamposConfirmationFlight = new ExcelUtils(
					"CamposConfirmationFlight.xlsx", ExcelType.XLSX);
			nombreButtonBackToFlights = excelCamposConfirmationFlight.getCellData(1, 0);
			nombreButtonBackToHome = excelCamposConfirmationFlight.getCellData(2, 0);
			nombreButtonLogOut = excelCamposConfirmationFlight.getCellData(3, 0);

		} catch (IOException e4) {

			System.out
					.println("*******************ATENCIÓN*******************************");
			System.out.println(e4.getMessage());
			System.out
					.println("**********************************************************");
		}

		// Validar que esté en la página Book a flight
		try {

			// Validar estén presentes los tres botones
			if (!(confirmationFlight
					.isElementPresentAndDisplay(confirmationFlight
							.getButtonBackToFlights()))) {
				throw new ElementoNoEncontradoException(
						nombreButtonBackToFlights);
			}
			if (!(confirmationFlight
					.isElementPresentAndDisplay(confirmationFlight
							.getButtonBackToHome()))) {
				throw new ElementoNoEncontradoException(nombreButtonBackToHome);
			}
			if (!(confirmationFlight
					.isElementPresentAndDisplay(confirmationFlight
							.getButtonLogOut()))) {
				throw new ElementoNoEncontradoException(nombreButtonLogOut);
			}
		} catch (ElementoNoEncontradoException e3) {
			System.out.println(e3.getDescripcion() + e3.getMessage());
		}

	}
}
