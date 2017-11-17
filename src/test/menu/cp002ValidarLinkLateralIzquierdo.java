package test.menu;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.MenuNavegacionPage;
import pageObjects.PagesFacade;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp002ValidarLinkLateralIzquierdo extends TestBase {

	PagesFacade facade;
	MenuNavegacionPage menu;
	private String lnkHome = "";
	private String lnkFlights = "";
	private String lnkHotels = "";
	private String lnkCarRentals = "";
	private String lnkCruises = "";
	private String lnkDestinations = "";
	private String lnkVacations = "";
	// Utilidad para el manejo de excel
	static ExcelUtils excelLinksMenu;

	@Test
	public void validarLinkLateralIzquierdo() {

		try {
			facade = new PagesFacade();
			menu = facade.getMenuPage();
			excelLinksMenu = new ExcelUtils("LinksMenu.xlsx", ExcelType.XLSX);

			// Cargamos el texto de los links desde el excel
			lnkHome = excelLinksMenu.getCellData(1, 1);
			lnkFlights = excelLinksMenu.getCellData(1, 2);
			lnkHotels = excelLinksMenu.getCellData(1, 3);
			lnkCarRentals = excelLinksMenu.getCellData(1, 4);
			lnkCruises = excelLinksMenu.getCellData(1, 5);
			lnkDestinations = excelLinksMenu.getCellData(1, 6);
			lnkVacations = excelLinksMenu.getCellData(1, 7);

			if (!(menu.getTextElement(menu.getLnkHome(), lnkHome))) {
				throw new ElementoNoEncontradoException(lnkHome);
			}
			if (!(menu.getTextElement(menu.getLnkFlights(), lnkFlights))) {
				throw new ElementoNoEncontradoException(lnkFlights);
			}
			if (!(menu.getTextElement(menu.getLnkHotels(), lnkHotels))) {
				throw new ElementoNoEncontradoException(lnkHotels);
			}
			if (!(menu.getTextElement(menu.getLnkCarRentals(), lnkCarRentals))) {
				throw new ElementoNoEncontradoException(lnkCarRentals);
			}
			if (!(menu.getTextElement(menu.getLnkCruises(), lnkCruises))) {
				throw new ElementoNoEncontradoException(lnkCruises);
			}
			if (!(menu.getTextElement(menu.getLnkDestinations(),
					lnkDestinations))) {
				throw new ElementoNoEncontradoException(lnkDestinations);
			}
			if (!(menu.getTextElement(menu.getLnkVacations(), lnkVacations))) {
				throw new ElementoNoEncontradoException(lnkVacations);
			}

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {

			System.out.println(e.getMessage());
		} catch (ElementoNoEncontradoException e) {

			System.out.println(e.getMessage());
		}

	} // Fin método validarLinkLateral
} // Fin clase
