package test.reservarvuelo;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.BookFlightPage;
import pageObjects.CruisePage;
import pageObjects.FindFlightPage;
import pageObjects.FlightConfirmationPage;
import pageObjects.MenuNavegacionPage;
import pageObjects.SelectFlightPage;
import test.autenticacion.cp002LoginMercuryCorrecto;

public class cp006ReservarVueloCruises extends TestBase {

	cp002LoginMercuryCorrecto login;
	CruisePage cruises;
	MenuNavegacionPage menu;
	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	String pageTitle = "Welcome: Mercury Tours";
	String pageTitleFind = "Find a Flight: Mercury Tours";
	String pageTitleSelect = "Select a Flight: Mercury Tours";
	String pageTitleBook = "Book a Flight: Mercury Tours";
	String pageTitleCruises = "Cruises: Mercury Tours";
	String pageTitleConfirmation = "Flight Confirmation: Mercury Tours";

	// Credenciales de autenticación
	//private String userName = "tutorial";
	//private String password = "tutorial";

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
	public void ingresarPorCruises() throws Exception {
		// Clic en el link de Cruise
		menu = new MenuNavegacionPage(driver, pageTitle);
		menu.clickButtonLink(menu.getLnkCruises());

		// Clic en Now Accepting
		cruises = new CruisePage(driver, pageTitleCruises);
		cruises.clickButtonLink(cruises.getLnkNowAccepting());

	}

	@Test(priority = 2, dependsOnMethods = { "login" })
	public void diligenciarFindFlight() throws Exception {

		findFlight = new FindFlightPage(driver, pageTitleFind);
		findFlight.seleccionFindFlight(tripType, passengers, departing,
				monthIni, dayIni, arrivingIn, monthEnd, dayEnd, serviceClass,
				airline);
	}

	@Test(priority = 3, dependsOnMethods = { "login" })
	public void diligenciarSelectFlight() throws Exception {

		selectFlight = new SelectFlightPage(driver, pageTitleSelect);
		selectFlight.seleccionSelectFlight(departingSelect, returningSelect);
	}

	@Test(priority = 4, dependsOnMethods = { "login" })
	public void diligenciarBookFlight() throws Exception {

		bookFlight = new BookFlightPage(driver, pageTitleBook);
		bookFlight.seleccionBookAFlight(firstName0, lastName0, meal0, cardType,
				cardNumber, expCMonth, expCYear, cardFirstName, cardMiddleNane,
				cardLastName, ticketless, address1Bill, address2Bill, cityBill,
				stateBill, postalCodeBill, countryBill, sameAsBillingAddress,
				address1Del, address2Del, cityDel, stateDel, postalCodeDel,
				countryDel);
	}

	@Test(priority = 5, dependsOnMethods = { "login" })
	public void verificarConfirmationFlight() throws Exception {

		confirmationFlight = new FlightConfirmationPage(driver,
				pageTitleConfirmation);
		confirmationFlight.seleccionarBotonFlightConfirmation(eleccion);
	}
}
