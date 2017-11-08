package test.reservarvuelo;



import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp005ReservarVuelo extends TestBase {

	cp002LoginMercuryCorrecto login;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	static ExcelUtils excelTitulosPaginas;
	//private String pageTitle = "";
	private String pageTitleFind = "";
	private String pageTitleSelect = "";
	private String pageTitleBook = "";
	private String pageTitleConfirmation = "";

	// Credenciales de autenticación
	// private String userName = "tutorial";
	// private String password = "tutorial";

	// Valores para seleccionar las opciones en la página Find Flight
	private String tripType = "One way";
	private String passengers = "1";
	private String departing = "London";
	private String monthIni = "November";
	private String dayIni = "24";
	private String arrivingIn = "Sydney";
	private String monthEnd = "January";
	private String dayEnd = "10";
	private String serviceClass = "First class";
	private String airline = "Unified Airlines";

	// Valores para seleccionar las opciones en la página Select Flight
	private String departingSelect = "Flight 363";
	private String returningSelect = "Flight 633";

	// Valores para seleccionar las opciones en la página Book a flight
	private String firstName0 = "Nombre 1";
	private String lastName0 = "Apellido 1";
	private String meal0 = "Vegetarian";
	private String cardType = "Visa";
	private String cardNumber = "89786-8767";
	private String expCMonth = "07";
	private String expCYear = "2010";
	private String cardFirstName = "Nombre";
	private String cardMiddleNane = "Segnombre";
	private String cardLastName = "Apellido";
	private boolean ticketless = true;
	private String address1Bill = "Direccion 1";
	private String address2Bill = "Direccion 2";
	private String cityBill = "Ciudad";
	private String stateBill = "Estado";
	private String postalCodeBill = "057";
	private String countryBill = "QATAR";
	boolean sameAsBillingAddress = true;
	private String address1Del = "Direccion 1";
	private String address2Del = "Direccion 2";
	private String cityDel = "Ciudad";
	private String stateDel = "Estado";
	private String postalCodeDel = "059";
	private String countryDel = "UNITED STATES";

	// Valores para seleccion en la página Confirmation Flight
	private String eleccion = "home";

	@Test
	public void login() {

		login = new cp002LoginMercuryCorrecto();
		login.loginCorrecto();
	}

	@Test(priority = 1, dependsOnMethods = { "login" })
	public void diligenciarFindFlight() throws Exception {

		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		pageTitleFind = excelTitulosPaginas.getCellData(2, 0);
		findFlight = new FindFlightPage(driver, pageTitleFind);
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
		selectFlight.seleccionSelectFlight(departingSelect, returningSelect);

	}

	@Test(priority = 3, dependsOnMethods = { "login" })
	public void diligenciarBookFlight() throws Exception {

		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		pageTitleBook = excelTitulosPaginas.getCellData(4, 0);
		bookFlight = new BookFlightPage(driver, pageTitleBook);
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
		confirmationFlight.seleccionarBotonFlightConfirmation(eleccion);

	}
}
