package test.autenticacion;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.PagesFacade;
import pageObjects.SignOnPage;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp004ValidarCamposSignOn extends TestBase {

	protected SignOnPage signOn;
	PagesFacade facade;
	static ExcelUtils excelCamposLogin;
	private String nomCampoUser = "";
	private String nomCampoPass = "";
	private String nomBotonSing = "";

	@Test
	public void verificarCamposLoginSignOn() throws FileNotFoundException,
			IOException {

		try {
			facade = new PagesFacade();
			signOn = facade.getSignOnPage();
			// Voy a la página Sign On
			facade.irASignOn();

			// Se crea la instancia para manejar el archivo CamposLogin.xlsx
			excelCamposLogin = new ExcelUtils("CamposSignOn.xlsx",
					ExcelType.XLSX);
			nomCampoUser = excelCamposLogin.getCellData(1, 0);
			nomCampoPass = excelCamposLogin.getCellData(1, 1);
			nomBotonSing = excelCamposLogin.getCellData(1, 2);

			if (!(signOn.isElementPresentAndDisplay(signOn.getInputUserName()))) {
				throw new ElementoNoEncontradoException(nomCampoUser);
			}
			if (!(signOn.isElementPresentAndDisplay(signOn.getInputPassword()))) {
				throw new ElementoNoEncontradoException(nomCampoPass);
			}
			if (!(signOn.isElementPresentAndDisplay(signOn.getButtonSingIn()))) {
				throw new ElementoNoEncontradoException(nomBotonSing);
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
