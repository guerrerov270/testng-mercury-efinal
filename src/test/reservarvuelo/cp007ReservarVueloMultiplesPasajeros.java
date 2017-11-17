package test.reservarvuelo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.PagesFacade;
import pageObjects.SelectFlightPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;
import utils.PaginaNoEncontradaException;

public class cp007ReservarVueloMultiplesPasajeros extends TestBase {

	PagesFacade facade;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	static ExcelUtils excelDatosPaginas;
	// Valores para seleccionar las opciones en la página Find Flight
	private String tripType = "";
	private String passengers = "";
	private String departing = "";
	private String monthIni = "";
	private String dayIni = "";
	private String arrivingIn = "";
	private String monthEnd = "";
	private String dayEnd = "";
	private String serviceClass = "";
	private String airline = "";

	// Valores para seleccionar las opciones en la página Select Flight
	private String departingSelect = "";
	private String returningSelect = "";

	// Valores para seleccionar las opciones en la página Book a flight
	private String firstName0 = "";
	private String lastName0 = "";
	private String meal0 = "";

	private String firstName1 = "";
	private String lastName1 = "";
	private String meal1 = "";

	private String firstName2 = "";
	private String lastName2 = "";
	private String meal2 = "";

	private String firstName3 = "";
	private String lastName3 = "";
	private String meal3 = "";

	private String cardType = "";
	private String cardNumber = "";
	private String expCMonth = "";
	private String expCYear = "";
	private String cardFirstName = "";
	private String cardMiddleNane = "";
	private String cardLastName = "";
	private String auxticketless = "";
	private boolean ticketless = false;
	private String address1Bill = "";
	private String address2Bill = "";
	private String cityBill = "";
	private String stateBill = "";
	private String postalCodeBill = "";
	private String countryBill = "";
	private String auxsameAsBillingAddress = "";
	boolean sameAsBillingAddress = false;
	private String address1Del = "";
	private String address2Del = "";
	private String cityDel = "";
	private String stateDel = "";
	private String postalCodeDel = "";
	private String countryDelNoAlert = "";
	private String countryDelAlert = "";

	// Valores para seleccion en la página Confirmation Flight
	private String eleccion = "";

	@Test
	public void login() throws FileNotFoundException, IOException,
			PaginaNoEncontradaException {

		facade = new PagesFacade();
		facade.hacerLogin();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void diligenciarPaginasRestantes() throws Exception {

		facade = new PagesFacade();
		findFlight = facade.getFindFlight();
		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosFindFlight.xlsx",
				ExcelType.XLSX);
		tripType = excelDatosPaginas.getCellData(1, 1);
		passengers = excelDatosPaginas.getCellData(2, 4);
		departing = excelDatosPaginas.getCellData(3, 1);
		monthIni = excelDatosPaginas.getCellData(4, 1);
		dayIni = excelDatosPaginas.getCellData(5, 1);
		arrivingIn = excelDatosPaginas.getCellData(6, 1);
		monthEnd = excelDatosPaginas.getCellData(7, 1);
		dayEnd = excelDatosPaginas.getCellData(8, 1);
		serviceClass = excelDatosPaginas.getCellData(9, 1);
		airline = excelDatosPaginas.getCellData(10, 1);
		findFlight.seleccionFindFlight(tripType, passengers, departing,
				monthIni, dayIni, arrivingIn, monthEnd, dayEnd, serviceClass,
				airline);

		// Dependiendo del número de pasajeros se ejecutarán las pruebas
		diligenciarSelectFlight();
		diligenciarBookFlight(Integer.parseInt(passengers));
		verificarConfirmationFlight();
	}

	public void diligenciarSelectFlight() throws Exception {

		facade = new PagesFacade();
		selectFlight = facade.getSelectFlight();
		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosSelectFlight.xlsx",
				ExcelType.XLSX);
		departingSelect = excelDatosPaginas.getCellData(1, 1);
		returningSelect = excelDatosPaginas.getCellData(2, 1);
		selectFlight.seleccionSelectFlight(departingSelect, returningSelect);

	}

	public void diligenciarBookFlight(int pasajeros) throws Exception {

		facade = new PagesFacade();
		bookFlight = facade.getBookFlight();

		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosBookAFlight.xlsx",
				ExcelType.XLSX);
		firstName0 = excelDatosPaginas.getCellData(1, 1);
		lastName0 = excelDatosPaginas.getCellData(2, 1);
		meal0 = excelDatosPaginas.getCellData(3, 1);

		firstName1 = excelDatosPaginas.getCellData(1, 2);
		lastName1 = excelDatosPaginas.getCellData(2, 2);
		meal1 = excelDatosPaginas.getCellData(3, 2);

		firstName2 = excelDatosPaginas.getCellData(1, 3);
		lastName2 = excelDatosPaginas.getCellData(2, 3);
		meal2 = excelDatosPaginas.getCellData(3, 3);

		firstName3 = excelDatosPaginas.getCellData(1, 4);
		lastName3 = excelDatosPaginas.getCellData(2, 4);
		meal3 = excelDatosPaginas.getCellData(3, 4);

		cardType = excelDatosPaginas.getCellData(4, 1);
		cardNumber = excelDatosPaginas.getCellData(5, 1);
		expCMonth = excelDatosPaginas.getCellData(6, 1);
		expCYear = excelDatosPaginas.getCellData(7, 1);
		cardFirstName = excelDatosPaginas.getCellData(8, 1);
		cardMiddleNane = excelDatosPaginas.getCellData(9, 1);
		cardLastName = excelDatosPaginas.getCellData(10, 1);
		auxticketless = excelDatosPaginas.getCellData(11, 1);
		if (auxticketless.equals("true")) {
			ticketless = true;
		} else if (auxticketless.equals("false")) {
			ticketless = false;
		}
		address1Bill = excelDatosPaginas.getCellData(12, 1);
		address2Bill = excelDatosPaginas.getCellData(13, 1);
		cityBill = excelDatosPaginas.getCellData(14, 1);
		stateBill = excelDatosPaginas.getCellData(15, 1);
		postalCodeBill = excelDatosPaginas.getCellData(16, 1);
		countryBill = excelDatosPaginas.getCellData(17, 1);
		auxsameAsBillingAddress = excelDatosPaginas.getCellData(18, 1);
		if (auxsameAsBillingAddress.equals("true")) {
			sameAsBillingAddress = true;
		} else if (auxsameAsBillingAddress.equals("false")) {
			sameAsBillingAddress = false;
		}
		address1Del = excelDatosPaginas.getCellData(19, 1);
		address2Del = excelDatosPaginas.getCellData(20, 1);
		cityDel = excelDatosPaginas.getCellData(21, 1);
		stateDel = excelDatosPaginas.getCellData(22, 1);
		postalCodeDel = excelDatosPaginas.getCellData(23, 1);

		// Con este valor no se abre ninguna alerta "UNITED STATES"
		countryDelNoAlert = excelDatosPaginas.getCellData(24, 1);

		// Con este valor se abre una alerta que hay que aceptar
		countryDelAlert = excelDatosPaginas.getCellData(24, 2);

		bookFlight.seleccionBookAFlightMultiplesPasajeros(pasajeros,
				firstName0, lastName0, meal0, firstName1, lastName1, meal1,
				firstName2, lastName2, meal2, firstName3, lastName3, meal3,
				cardType, cardNumber, expCMonth, expCYear, cardFirstName,
				cardMiddleNane, cardLastName, ticketless, address1Bill,
				address2Bill, cityBill, stateBill, postalCodeBill, countryBill,
				sameAsBillingAddress, address1Del, address2Del, cityDel,
				stateDel, postalCodeDel, countryDelNoAlert, countryDelAlert);
	}

	public void verificarConfirmationFlight() throws Exception {

		facade = new PagesFacade();
		confirmationFlight = facade.getConfirmationFlight();
		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosConfirmationFlight.xlsx",
				ExcelType.XLSX);
		eleccion = excelDatosPaginas.getCellData(1, 1);
		confirmationFlight.seleccionarBotonFlightConfirmation(eleccion);

	}

}
