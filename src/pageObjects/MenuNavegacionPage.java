package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

public class MenuNavegacionPage extends PageBase {

	public MenuNavegacionPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// WebElements menú superior
	@FindBy(how = How.LINK_TEXT, using = "SIGN-ON")
	private WebElement lnkSignOn;
	@FindBy(how = How.LINK_TEXT, using = "SIGN-OFF")
	private WebElement lnkSignOf;
	@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	private WebElement lnkRegister;
	@FindBy(how = How.LINK_TEXT, using = "SUPPORT")
	private WebElement lnkSupport;
	@FindBy(how = How.LINK_TEXT, using = "CONTACT")
	private WebElement lnkContact;
	@FindBy(how = How.LINK_TEXT, using = "ITINERARY")
	private WebElement lnkItinerary;
	@FindBy(how = How.LINK_TEXT, using = "PROFILE")
	private WebElement lnkProfile;

	// WebElements menú lateral izquierdo
	@FindBy(how = How.LINK_TEXT, using = "Home")
	private WebElement lnkHome;
	@FindBy(how = How.LINK_TEXT, using = "Flights")
	private WebElement lnkFlights;
	@FindBy(how = How.LINK_TEXT, using = "Hotels")
	private WebElement lnkHotels;
	@FindBy(how = How.LINK_TEXT, using = "Car Rentals")
	private WebElement lnkCarRentals;
	@FindBy(how = How.LINK_TEXT, using = "Cruises")
	private WebElement lnkCruises;
	@FindBy(how = How.LINK_TEXT, using = "Destinations")
	private WebElement lnkDestinations;
	@FindBy(how = How.LINK_TEXT, using = "Vacations")
	private WebElement lnkVacations;

	// WebElements menú lateral izquierdo
	@FindBy(how = How.LINK_TEXT, using = "your destination")
	private WebElement lnkYourDestination;
	@FindBy(how = How.LINK_TEXT, using = "featured vacation destinations")
	private WebElement lnkFeaturedVacatioDestinations;
	@FindBy(how = How.LINK_TEXT, using = "Register here")
	private WebElement lnkRegisterHere;
	@FindBy(how = How.LINK_TEXT, using = "Business Travel @ About.com")
	private WebElement lnkBussinessTravel;
	@FindBy(how = How.LINK_TEXT, using = "Salon Travel")
	private WebElement lnkSalonTravel;

	/**
	 * Métodos get, proporcionan acceso desde otras clases a los WebElements
	 * 
	 * @return
	 */
	public WebElement getLnkSingOn() {
		return lnkSignOn;
	}

	public WebElement getLnkYourDestination() {
		return lnkYourDestination;
	}

	public WebElement getLnkFeaturedVacatioDestinations() {
		return lnkFeaturedVacatioDestinations;
	}

	public WebElement getLnkRegisterHere() {
		return lnkRegisterHere;
	}

	public WebElement getLnkBussinessTravel() {
		return lnkBussinessTravel;
	}

	public WebElement getLnkSalonTravel() {
		return lnkSalonTravel;
	}

	public WebElement getLnkSingOf() {
		return lnkSignOf;
	}

	public WebElement getLnkRegister() {
		return lnkRegister;
	}

	public WebElement getLnkSupport() {
		return lnkSupport;
	}

	public WebElement getLnkContact() {
		return lnkContact;
	}

	public WebElement getLnkItinerary() {
		return lnkItinerary;
	}

	public WebElement getLnkProfile() {
		return lnkProfile;
	}

	public WebElement getLnkHome() {
		return lnkHome;
	}

	public WebElement getLnkFlights() {
		return lnkFlights;
	}

	public WebElement getLnkHotels() {
		return lnkHotels;
	}

	public WebElement getLnkCarRentals() {
		return lnkCarRentals;
	}

	public WebElement getLnkCruises() {
		return lnkCruises;
	}

	public WebElement getLnkDestinations() {
		return lnkDestinations;
	}

	public WebElement getLnkVacations() {
		return lnkVacations;
	}

	/**
	 * Verifica que el texto del enlace del webElement coincida con el recibido
	 * por parámetro
	 * 
	 * @param elemento
	 *            : el elemento que representa la etiqueta HTML
	 * @param textoEnlace
	 *            : El texto del enlace
	 * @return resultado: true or false
	 */
	public boolean getTextLink(WebElement elemento, String textoEnlace) {
		boolean resultado;
		if (elemento.getText().equals(textoEnlace)) {
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}// Fin método getTextLink

}