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
import utils.PaginaNoEncontradaException;

public class cp003ValidarLinkDespuesLogin extends TestBase {

	PagesFacade facade;
	MenuNavegacionPage menu;
	private String lnkSignOff = "";
	private String lnkItinerary = "";
	private String lnkProfile = "";
	private String lnkSupport = "";
	private String lnkContact = "";
	// Utilidad para el manejo de excel
	static ExcelUtils excelLinksMenu;

	@Test
	public void validarLinksDespuesDeLogin() throws PaginaNoEncontradaException {

		try {
			facade = new PagesFacade();
			// Hacemos el login en la página
			facade.hacerLogin();

			menu = facade.getMenuPage();
			excelLinksMenu = new ExcelUtils("LinksMenu.xlsx", ExcelType.XLSX);

			// Cargamos el texto de los links desde el excel
			lnkSignOff = excelLinksMenu.getCellData(0, 5);
			lnkItinerary = excelLinksMenu.getCellData(0, 6);
			lnkProfile = excelLinksMenu.getCellData(0, 7);
			lnkSupport = excelLinksMenu.getCellData(0, 3);
			lnkContact = excelLinksMenu.getCellData(0, 4);

			if (!(menu.getTextElement(menu.getLnkSingOf(), lnkSignOff))) {
				throw new ElementoNoEncontradoException(lnkSignOff);
			}
			if (!(menu.getTextElement(menu.getLnkItinerary(), lnkItinerary))) {
				throw new ElementoNoEncontradoException(lnkItinerary);
			}
			if (!(menu.getTextElement(menu.getLnkProfile(), lnkProfile))) {
				throw new ElementoNoEncontradoException(lnkProfile);
			}
			if (!(menu.getTextElement(menu.getLnkSupport(), lnkSupport))) {
				throw new ElementoNoEncontradoException(lnkSupport);
			}
			if (!(menu.getTextElement(menu.getLnkContact(), lnkContact))) {
				throw new ElementoNoEncontradoException(lnkContact);
			}

		} catch (FileNotFoundException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {

			System.out.println(e.getMessage());
		} catch (ElementoNoEncontradoException e) {

			System.out.println(e.getMessage());
		}
	}
}
