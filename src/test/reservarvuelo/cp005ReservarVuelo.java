package test.reservarvuelo;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.SelectFlightPage;
import utils.ExcelUtils;
import utils.LoginUtil;
import utils.ExcelUtils.ExcelType;

public class cp005ReservarVuelo extends TestBase {

	LoginUtil login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	static ExcelUtils excelTitulosPaginas;
	static ExcelUtils excelDatosPaginas;
	// private String pageTitle = "";
	private String pageTitleFind = "";
	private String pageTitleSelect = "";
	private String pageTitleBook = "";
	private String pageTitleConfirmation = "";

	// Credenciales de autenticación
	// private String userName = "tutorial";
	// private String password = "tutorial";

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
	private String countryDel = "";

	// Valores para seleccion en la página Confirmation Flight
	private String eleccion = "";

	@Test
	public void login() {

		login = new LoginUtil();
		login.hacerLogin();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void diligenciarFindFlight() throws Exception {

		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		pageTitleFind = excelTitulosPaginas.getCellData(2, 0);
		findFlight = new FindFlightPage(driver, pageTitleFind);
		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosFindFlight.xlsx",
				ExcelType.XLSX);
		tripType = excelDatosPaginas.getCellData(1, 1);
		passengers = excelDatosPaginas.getCellData(2, 1);
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

	}

	@Test(priority = 2, dependsOnMethods = { "login" })
	public void diligenciarSelectFlight() throws Exception {

		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		pageTitleSelect = excelTitulosPaginas.getCellData(3, 0);
		selectFlight = new SelectFlightPage(driver, pageTitleSelect);
		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosSelectFlight.xlsx",
				ExcelType.XLSX);
		departingSelect = excelDatosPaginas.getCellData(1, 1);
		returningSelect = excelDatosPaginas.getCellData(2, 1);
		selectFlight.seleccionSelectFlight(departingSelect, returningSelect);

	}

	@Test(priority = 3, dependsOnMethods = { "login" })
	public void diligenciarBookFlight() throws Exception {

		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		pageTitleBook = excelTitulosPaginas.getCellData(4, 0);
		bookFlight = new BookFlightPage(driver, pageTitleBook);

		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosBookAFlight.xlsx",
				ExcelType.XLSX);
		firstName0 = excelDatosPaginas.getCellData(1, 1);
		lastName0 = excelDatosPaginas.getCellData(2, 1);
		meal0 = excelDatosPaginas.getCellData(3, 1);
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
		countryDel = excelDatosPaginas.getCellData(24, 1);

		bookFlight.seleccionBookAFlight(firstName0, lastName0, meal0, cardType,
				cardNumber, expCMonth, expCYear, cardFirstName, cardMiddleNane,
				cardLastName, ticketless, address1Bill, address2Bill, cityBill,
				stateBill, postalCodeBill, countryBill, sameAsBillingAddress,
				address1Del, address2Del, cityDel, stateDel, postalCodeDel,
				countryDel);
	}

	@Test(priority = 4, dependsOnMethods = { "login" })
	public void verificarConfirmationFlight() throws Exception {

		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		pageTitleConfirmation = excelTitulosPaginas.getCellData(5, 0);
		confirmationFlight = new FlightConfirmationPage(driver,
				pageTitleConfirmation);
		// Diligencio la página con valores desde el data pool
		excelDatosPaginas = new ExcelUtils("DatosConfirmationFlight.xlsx",
				ExcelType.XLSX);
		eleccion = excelDatosPaginas.getCellData(1, 1);
		confirmationFlight.seleccionarBotonFlightConfirmation(eleccion);

	}
}
