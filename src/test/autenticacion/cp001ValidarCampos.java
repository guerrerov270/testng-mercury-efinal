package test.autenticacion;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.LoginPage;
import pageObjects.PagesFacade;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp001ValidarCampos extends TestBase {

	PagesFacade facade;
	protected LoginPage login;
	// Utilidad para el manejo de excel
	static ExcelUtils excelCamposLogin;
	private String nomCampoUser = "";
	private String nomCampoPass = "";
	private String nomBotonSing = "";

	@Test
	public void verificarCamposLogin() {

		try {
			facade = new PagesFacade();
			login = facade.getLoginPage();
			// Se crea la instancia para manejar el archivo CamposLogin.xlsx
			excelCamposLogin = new ExcelUtils("CamposLogin.xlsx",
					ExcelType.XLSX);
			nomCampoUser = excelCamposLogin.getCellData(1, 0);
			nomCampoPass = excelCamposLogin.getCellData(1, 1);
			nomBotonSing = excelCamposLogin.getCellData(1, 2);

			if (!(login.isElementPresentAndDisplay(login.getInputUserName()))) {
				throw new ElementoNoEncontradoException(nomCampoUser);
			}
			if (!(login.isElementPresentAndDisplay(login.getInputPassword()))) {
				throw new ElementoNoEncontradoException(nomCampoPass);
			}
			if (!(login.isElementPresentAndDisplay(login.getButtonSingIn()))) {
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
