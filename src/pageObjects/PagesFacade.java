package pageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import base.TestBase;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

/**
 * Clase Fachada que me permite reducir la complejidad de las relaciones entre
 * los casos de prueba y las Pages, evita duplicar código en cada caso de prueba
 * y añade un nivel más de abstracción para hacer más secilla la estructura de
 * la aplicación.Aquí voy a inicializar cada Page, entonces a cada caso de
 * prueba le bastará con una sola instancia de esta fachada para acceder a las
 * Pages que necesite en vez de una instancia por cada Page.
 * 
 * @author finguerrero
 * @version 06/11/2017
 * @see <a href = "https://github.com/guerrerov270/testng-mercury-efinal" />
 *      Repositorio del proyecto en Github </a>
 */
public class PagesFacade {

	FindFlightPage findFlight;
	SelectFlightPage selectFlight;
	BookFlightPage bookFlight;
	FlightConfirmationPage confirmationFlight;
	CruisePage cruisePage;
	LoginPage loginPage;
	MenuNavegacionPage menuPage;
	RegistrarUsuarioPage registrarPage;
	SignOnPage signOnPage;
	static ExcelUtils excelTitulosPaginas;
	TestBase test;

	public PagesFacade() throws FileNotFoundException, IOException {

		test = new TestBase();
		excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
				ExcelType.XLSX);
		findFlight = new FindFlightPage(test.getDriver(),
				excelTitulosPaginas.getCellData(2, 0));
		selectFlight = new SelectFlightPage(test.getDriver(),
				excelTitulosPaginas.getCellData(3, 0));
		bookFlight = new BookFlightPage(test.getDriver(),
				excelTitulosPaginas.getCellData(4, 0));
		confirmationFlight = new FlightConfirmationPage(test.getDriver(),
				excelTitulosPaginas.getCellData(5, 0));
		cruisePage = new CruisePage(test.getDriver(),
				excelTitulosPaginas.getCellData(6, 0));
		menuPage = new MenuNavegacionPage(test.getDriver(),
				excelTitulosPaginas.getCellData(1, 0));

	}

	public void irASelectFlight() {

		findFlight.clickButtonLink(findFlight.getButtonContinue());

	}

	public void irABookFlight() {

		selectFlight.clickButtonLink(selectFlight.getButtonContinue());

	}

	public void irAConfirmationFlight() {

		bookFlight.clickButtonLink(bookFlight.getButtonBuyFlights());

	}

	public FindFlightPage getFindFlight() {
		return findFlight;
	}

	public SelectFlightPage getSelectFlight() {
		return selectFlight;
	}

	public BookFlightPage getBookFlight() {
		return bookFlight;
	}

	public FlightConfirmationPage getConfirmationFlight() {
		return confirmationFlight;
	}

	public CruisePage getCruisePage() {
		return cruisePage;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public MenuNavegacionPage getMenuPage() {
		return menuPage;
	}

	public RegistrarUsuarioPage getRegistrarPage() {
		return registrarPage;
	}

	public SignOnPage getSignOnPage() {
		return signOnPage;
	}

}
