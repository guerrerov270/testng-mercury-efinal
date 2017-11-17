package test.menu;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.MenuNavegacionPage;
import pageObjects.PagesFacade;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;
import base.TestBase;

public class cp004ValidarLinkLateralDerecho extends TestBase {

	PagesFacade facade;
	MenuNavegacionPage menu;
	private String lnkYourDestination = "";
	private String lnkFeaturedVacatioDestinations = "";
	private String lnkRegisterHere = "";
	private String lnkBussinessTravel = "";
	private String lnkSalonTravel = "";
	// Utilidad para el manejo de excel
	static ExcelUtils excelLinksMenu;

	@Test
	public void validarLinkLateralDerecho() {

		try {
			facade = new PagesFacade();
			menu = facade.getMenuPage();
			excelLinksMenu = new ExcelUtils("LinksMenu.xlsx", ExcelType.XLSX);

			// Cargamos el texto de los links desde el excel
			lnkYourDestination = excelLinksMenu.getCellData(2, 1);
			lnkFeaturedVacatioDestinations = excelLinksMenu.getCellData(2, 2);
			lnkRegisterHere = excelLinksMenu.getCellData(2, 3);
			lnkBussinessTravel = excelLinksMenu.getCellData(2, 4);
			lnkSalonTravel = excelLinksMenu.getCellData(2, 5);

			if (!(menu.getTextElement(menu.getLnkYourDestination(),
					lnkYourDestination))) {
				throw new ElementoNoEncontradoException(lnkYourDestination);
			}
			if (!(menu.getTextElement(menu.getLnkFeaturedVacatioDestinations(),
					lnkFeaturedVacatioDestinations))) {
				throw new ElementoNoEncontradoException(
						lnkFeaturedVacatioDestinations);
			}
			if (!(menu.getTextElement(menu.getLnkRegisterHere(),
					lnkRegisterHere))) {
				throw new ElementoNoEncontradoException(lnkRegisterHere);
			}
			if (!(menu.getTextElement(menu.getLnkBussinessTravel(),
					lnkBussinessTravel))) {
				throw new ElementoNoEncontradoException(lnkBussinessTravel);
			}
			if (!(menu.getTextElement(menu.getLnkSalonTravel(), lnkSalonTravel))) {
				throw new ElementoNoEncontradoException(lnkSalonTravel);
			}

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {

			System.out.println(e.getMessage());
		} catch (ElementoNoEncontradoException e) {

			System.out.println(e.getMessage());
		}

	} // Fin método validarLinkLateralDerecho
}// Fin clase
