package test.menu;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.MenuNavegacionPage;
import pageObjects.PagesFacade;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp001ValidarLinkSuperior extends TestBase {

	PagesFacade facade;
	MenuNavegacionPage menu;
	private String lnkSingOn = "";
	private String lnkRegister = "";
	private String lnkSupport = "";
	private String lnkContact = "";

	// Utilidad para el manejo de excel
	static ExcelUtils excelLinksMenu;

	@Test
	public void validarLinkSuperior() throws FileNotFoundException, IOException {

		facade = new PagesFacade();
		// Se crea la instancia para manejar el archivo LinksMenu.xlsx
		try {
			excelLinksMenu = new ExcelUtils("LinksMenu.xlsx", ExcelType.XLSX);
			menu = facade.getMenuPage();

			// Cargamos el texto de los links desde el excel
			lnkSingOn = excelLinksMenu.getCellData(0, 1);
			lnkRegister = excelLinksMenu.getCellData(0, 2);
			lnkSupport = excelLinksMenu.getCellData(0, 3);
			lnkContact = excelLinksMenu.getCellData(0, 4);

			if (!(menu.getTextElement(menu.getLnkSingOn(), lnkSingOn))) {
				throw new ElementoNoEncontradoException(lnkSingOn);
			}
			if (!(menu.getTextElement(menu.getLnkSingOn(), lnkSingOn))) {
				throw new ElementoNoEncontradoException(lnkRegister);
			}
			if (!(menu.getTextElement(menu.getLnkSingOn(), lnkSupport))) {
				throw new ElementoNoEncontradoException(lnkSupport);
			}
			if (!(menu.getTextElement(menu.getLnkSingOn(), lnkContact))) {
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
