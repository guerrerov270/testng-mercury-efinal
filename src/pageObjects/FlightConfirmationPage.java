package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.PageBase;

/**
 * Clase que contiene los webElements de
 * http://newtours.demoaut.com/mercurypurchase2.php
 * 
 * @author anamariaquinteroleal
 *
 */
public class FlightConfirmationPage extends PageBase {

	public FlightConfirmationPage(WebDriver driver, String pageTitle) {
		super(driver, pageTitle);
	}

	// Botones
	@FindBy(how = How.CSS, using = "img[src='/images/forms/backtoflights.gif']")
	private WebElement buttonBackToFlights;
	@FindBy(how = How.CSS, using = "img[src='/images/forms/home.gif']")
	private WebElement buttonBackToHome;
	@FindBy(how = How.CSS, using = "img[src='/images/forms/Logout.gif']")
	private WebElement buttonLogOut;

	// Método get para cada elemento
	public WebElement getButtonBackToFlights() {
		return buttonBackToFlights;
	}

	public WebElement getButtonBackToHome() {
		return buttonBackToHome;
	}

	public WebElement getButtonLogOut() {
		return buttonLogOut;
	}

	public void seleccionarBotonFlightConfirmation(String eleccion) {

		switch (eleccion) {
		case "flights":
			clickButtonLink(buttonBackToFlights);
			break;
		case "home":
			clickButtonLink(buttonBackToHome);
			break;
		case "Log out":
			clickButtonLink(buttonLogOut);
			break;

		default:
			break;
		}

	}// Fin método seleccionarBotonFlightConfirmation
}
