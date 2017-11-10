package test.reservarvuelo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.FindFlightPage;
import pageObjects.PagesFacade;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp001ValidarCamposFindFlight extends TestBase {

	PagesFacade facade;
	FindFlightPage findFlight;
	static ExcelUtils excelTitulosPaginas;
	static ExcelUtils excelCamposFindFlight;
	// private String pageTitleFind = "";
	private String nombreRadioRoundTrip = "";
	private String nombreRadioOneWay = "";
	private String nombreSelectPassengers = "";
	private String nombreSelectDepartingFrom = "";
	private String nombreSelectMonthIni = "";
	private String nombreSelectDayIni = "";
	private String nombreSelectArrivingIn = "";
	private String nombreSelectReturning = "";
	private String nombreSelectDayEnd = "";
	private String nombreRadioEconomyClass = "";
	private String nombreRadioBussinessClass = "";
	private String nombreRadioFirstClass = "";
	private String nombreSelectAirline = "";
	private String nombreButtonContinue = "";

	@Test
	public void login() throws FileNotFoundException, IOException {

		facade = new PagesFacade();
		facade.hacerLogin();
	}// Fin método login

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposFindFlight() throws Exception {

		facade = new PagesFacade();
		findFlight = facade.getFindFlight();

		try {
			excelCamposFindFlight = new ExcelUtils("CamposFindFlight.xlsx",
					ExcelType.XLSX);
			nombreRadioRoundTrip = excelCamposFindFlight.getCellData(1, 0);
			nombreRadioOneWay = excelCamposFindFlight.getCellData(2, 0);
			nombreSelectPassengers = excelCamposFindFlight.getCellData(3, 0);
			nombreSelectDepartingFrom = excelCamposFindFlight.getCellData(4, 0);
			nombreSelectMonthIni = excelCamposFindFlight.getCellData(5, 0);
			nombreSelectDayIni = excelCamposFindFlight.getCellData(6, 0);
			nombreSelectArrivingIn = excelCamposFindFlight.getCellData(7, 0);
			nombreSelectReturning = excelCamposFindFlight.getCellData(8, 0);
			nombreSelectDayEnd = excelCamposFindFlight.getCellData(9, 0);
			nombreRadioEconomyClass = excelCamposFindFlight.getCellData(10, 0);
			nombreRadioBussinessClass = excelCamposFindFlight
					.getCellData(11, 0);
			nombreRadioFirstClass = excelCamposFindFlight.getCellData(12, 0);
			nombreSelectAirline = excelCamposFindFlight.getCellData(13, 0);
			nombreButtonContinue = excelCamposFindFlight.getCellData(14, 0);

		} catch (IOException e) {

			System.out
					.println("*******************ATENCIÓN*******************************");
			System.out.println(e.getMessage());
			System.out
					.println("**********************************************************");
		}

		// Validación de los campos del área Preferences
		try {

			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getRadioRoundTrip()))) {
				throw new ElementoNoEncontradoException(nombreRadioRoundTrip);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getRadioOneWay()))) {
				throw new ElementoNoEncontradoException(nombreRadioOneWay);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectPassengers()))) {
				throw new ElementoNoEncontradoException(nombreSelectPassengers);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectDepartingFrom()))) {
				throw new ElementoNoEncontradoException(
						nombreSelectDepartingFrom);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectMonthIni()))) {
				throw new ElementoNoEncontradoException(nombreSelectMonthIni);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectDayIni()))) {
				throw new ElementoNoEncontradoException(nombreSelectDayIni);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectArrivingIn()))) {
				throw new ElementoNoEncontradoException(nombreSelectArrivingIn);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectReturning()))) {
				throw new ElementoNoEncontradoException(nombreSelectReturning);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectDayEnd()))) {
				throw new ElementoNoEncontradoException(nombreSelectDayEnd);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getRadioEconomyClass()))) {
				throw new ElementoNoEncontradoException(nombreRadioEconomyClass);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getRadioBussinessClass()))) {
				throw new ElementoNoEncontradoException(
						nombreRadioBussinessClass);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getRadioFirstClass()))) {
				throw new ElementoNoEncontradoException(nombreRadioFirstClass);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getSelectAirline()))) {
				throw new ElementoNoEncontradoException(nombreSelectAirline);
			}
			if (!(findFlight.isElementPresentAndDisplay(findFlight
					.getButtonContinue()))) {
				throw new ElementoNoEncontradoException(nombreButtonContinue);
			}

		} catch (ElementoNoEncontradoException e) {
			System.out.println(e.getDescripcion() + e.getMessage());
		}

	}// Fin método ValidarCamposFindFlight

}// Fin clase cp001ValidarCamposFindFlight