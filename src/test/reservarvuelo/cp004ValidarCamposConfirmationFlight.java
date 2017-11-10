package test.reservarvuelo;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.PagesFacade;
import pageObjects.SelectFlightPage;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.LoginUtil;
import utils.ExcelUtils.ExcelType;

public class cp004ValidarCamposConfirmationFlight extends TestBase {

	PagesFacade facade;
	LoginUtil login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	static ExcelUtils excelCamposConfirmationFlight;
	private String nombreButtonBackToFlights = "";
	private String nombreButtonBackToHome = "";
	private String nombreButtonLogOut = "";

	@Test
	public void login() {

		login = new LoginUtil();
		login.hacerLogin();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposConfirmationFlight() throws Exception {
		
		facade= new PagesFacade();
		findFlight = facade.getFindFlight();
		findFlight.clickButtonLink(findFlight.getButtonContinue());
		selectFlight = facade.getSelectFlight();
		selectFlight.clickButtonLink(selectFlight.getButtonContinue());
		bookFlight = facade.getBookFlight();
		// Clic en botón Secure purchase
		bookFlight.clickButtonLink(bookFlight.getButtonBuyFlights());
		confirmationFlight = facade.getConfirmationFlight();

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
