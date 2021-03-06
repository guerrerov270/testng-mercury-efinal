package test.reservarvuelo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.PagesFacade;
import pageObjects.SelectFlightPage;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.PaginaNoEncontradaException;
import utils.ExcelUtils.ExcelType;

public class cp002ValidarCamposSelectFlight extends TestBase {

	PagesFacade facade;
	SelectFlightPage selectFlight;
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

	@Test
	public void login() throws FileNotFoundException, IOException, PaginaNoEncontradaException {

		facade = new PagesFacade();
		facade.hacerLogin();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void ValidarCamposSelectFlight() throws Exception {

		facade = new PagesFacade();
		facade.irASelectFlight();
		selectFlight = facade.getSelectFlight();

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
		if (driver.getTitle().contentEquals(selectFlight.getTitle())) {

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
					throw new ElementoNoEncontradoException(
							nombreButtonContinue);
				}
			} catch (ElementoNoEncontradoException e1) {
				System.out.println(e1.getDescripcion() + e1.getMessage());
			}
		} else {

			throw new PaginaNoEncontradaException(selectFlight.getTitle());
			//No controlamos la excepción porque el caso de prueba debe fallar

		}
	} // Fin método ValidarCamposSelectFlight
} // Fin clase cp002ValidarCamposSelectFlight

