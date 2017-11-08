package test.reservarvuelo;

import java.io.IOException;

import org.testng.annotations.Test;
import base.TestBase;
import pageObjects.FindFlightPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp002ValidarCamposSelectFlight extends TestBase {

	cp002LoginMercuryCorrecto login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	static ExcelUtils excelTitulosPaginas;
	static ExcelUtils excelCamposSelectFlight;
	private String nombreFlight360 = "";
	private String nombreFlight361 = "";
	private String nombreFlight362 = "";
	private String nombreFlight363 = "";
	private String nombreFlight630 = "";
	private String nombreFlight631 = "";
	private String nombreFlight632 = "";
	private String nombreFlight633 = "";
	private String nombreButtonContinue = "";
	//private String pageTitle = "Welcome: Mercury Tours";
	private String pageTitleFind = "";
	private String pageTitleSelect = "";

	@Test
	public void login() {

		login = new cp002LoginMercuryCorrecto();
		login.loginCorrecto();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposSelectFlight() throws Exception {
		
		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		pageTitleFind = excelTitulosPaginas.getCellData(2, 0);
		pageTitleSelect = excelTitulosPaginas.getCellData(3, 0);
		
		findFlight = new FindFlightPage(driver, pageTitleFind);
		findFlight.clickButtonLink(findFlight.getButtonContinue());
		selectFlight = new SelectFlightPage(driver, pageTitleSelect);

		try {
			excelCamposSelectFlight = new ExcelUtils("CamposSelectFlight.xlsx",
					ExcelType.XLSX);
			nombreFlight360 = excelCamposSelectFlight.getCellData(1, 0);
			nombreFlight361 = excelCamposSelectFlight.getCellData(2, 0);
			nombreFlight362 = excelCamposSelectFlight.getCellData(3, 0);
			nombreFlight363 = excelCamposSelectFlight.getCellData(4, 0);
			nombreFlight630 = excelCamposSelectFlight.getCellData(5, 0);
			nombreFlight631 = excelCamposSelectFlight.getCellData(6, 0);
			nombreFlight632 = excelCamposSelectFlight.getCellData(7, 0);
			nombreFlight633 = excelCamposSelectFlight.getCellData(8, 0);
			nombreButtonContinue = excelCamposSelectFlight.getCellData(9, 0);

		} catch (IOException e1) {

			System.out
					.println("*******************ATENCIÓN*******************************");
			System.out.println(e1.getMessage());
			System.out
					.println("**********************************************************");
		}

		// Validar que se encuentre en la página Select a Flight: Mercury Tours
		try {
			// verifico los elementos en la página
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight0D()))) {
				throw new ElementoNoEncontradoException(nombreFlight360);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight1D()))) {
				throw new ElementoNoEncontradoException(nombreFlight361);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight2D()))) {
				throw new ElementoNoEncontradoException(nombreFlight362);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight3D()))) {
				throw new ElementoNoEncontradoException(nombreFlight363);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight0R()))) {
				throw new ElementoNoEncontradoException(nombreFlight630);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight1R()))) {
				throw new ElementoNoEncontradoException(nombreFlight631);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight2R()))) {
				throw new ElementoNoEncontradoException(nombreFlight632);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getRadioFlight3R()))) {
				throw new ElementoNoEncontradoException(nombreFlight633);
			}
			if (!(selectFlight.isElementPresentAndDisplay(selectFlight
					.getButtonContinue()))) {
				throw new ElementoNoEncontradoException(nombreButtonContinue);
			}
		} catch (ElementoNoEncontradoException e1) {
			System.out.println(e1.getDescripcion() + e1.getMessage());
		}
	} // Fin método ValidarCamposSelectFlight
} // Fin clase cp002ValidarCamposSelectFlight

