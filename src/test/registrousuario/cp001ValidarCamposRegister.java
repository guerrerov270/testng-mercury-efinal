package test.registrousuario;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.MenuNavegacionPage;
import pageObjects.PagesFacade;
import pageObjects.RegistrarUsuarioPage;
import utils.ElementoNoEncontradoException;
import utils.ExcelUtils;
import utils.PaginaNoEncontradaException;
import utils.ExcelUtils.ExcelType;

public class cp001ValidarCamposRegister extends TestBase {

	PagesFacade facade;
	MenuNavegacionPage menu;
	RegistrarUsuarioPage registrarUsuario;
	static ExcelUtils excelTitulosPaginas;
	static ExcelUtils excelCamposRegister;
	private String nombreInputFirstName = "";
	private String nombreInputLastName = "";
	private String nombreInputPhone = "";
	private String nombreInputEmail = "";
	private String nombreInputAddress1 = "";
	private String nombreInputAddress2 = "";
	private String nombreInputCity = "";
	private String nombreInputState = "";
	private String nombreInputPostalCode = "";
	private String nombreSelectCountry = "";
	private String nombreInputUserName = "";
	private String nombreInputPassword = "";
	private String nombreInputConfirmPassword = "";

	@Test
	public void ingresarRegistrar() throws FileNotFoundException, IOException {

		facade = new PagesFacade();
		menu = facade.getMenuPage();
		facade.irARegistro();
		registrarUsuario = facade.getRegistrarPage();

	}

	@Test(priority = 1)
	public void validarCamposContact() throws Exception {

		try {
			excelCamposRegister = new ExcelUtils("CamposRegister.xlsx",
					ExcelType.XLSX);
			nombreInputFirstName = excelCamposRegister.getCellData(0, 0);
			nombreInputLastName = excelCamposRegister.getCellData(1, 0);
			nombreInputPhone = excelCamposRegister.getCellData(2, 0);
			nombreInputEmail = excelCamposRegister.getCellData(3, 0);

		} catch (IOException e) {

			System.out
					.println("*******************ATENCIÓN*******************************");
			System.out.println(e.getMessage());
			System.out
					.println("**********************************************************");
		}

		// Verifico que me encuentre en la página
		if (driver.getTitle().contentEquals(registrarUsuario.getTitle())) {
			// Validación de los campos del área Preferences

			try {

				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputFirstName()))) {
					throw new ElementoNoEncontradoException(
							nombreInputFirstName);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputLastName()))) {
					throw new ElementoNoEncontradoException(nombreInputLastName);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputPhone()))) {
					throw new ElementoNoEncontradoException(nombreInputPhone);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputEmailUser()))) {
					throw new ElementoNoEncontradoException(nombreInputEmail);
				}

			} catch (ElementoNoEncontradoException e) {
				System.out.println(e.getDescripcion() + e.getMessage());
			}
		} else {

			throw new PaginaNoEncontradaException(registrarUsuario.getTitle());
			// No controlamos la excepción porque el caso de prueba debe fallar

		}

	}// Fin método validarCamposContact

	@Test(priority = 2)
	public void validarCamposMailing() throws Exception {

		try {
			excelCamposRegister = new ExcelUtils("CamposRegister.xlsx",
					ExcelType.XLSX);

			nombreInputAddress1 = excelCamposRegister.getCellData(4, 0);
			nombreInputAddress2 = excelCamposRegister.getCellData(5, 0);
			nombreInputCity = excelCamposRegister.getCellData(6, 0);
			nombreInputState = excelCamposRegister.getCellData(7, 0);
			nombreInputPostalCode = excelCamposRegister.getCellData(8, 0);
			nombreSelectCountry = excelCamposRegister.getCellData(9, 0);

		} catch (IOException e) {

			System.out
					.println("*******************ATENCIÓN*******************************");
			System.out.println(e.getMessage());
			System.out
					.println("**********************************************************");
		}

		// Verifico que me encuentre en la página
		if (driver.getTitle().contentEquals(registrarUsuario.getTitle())) {
			// Validación de los campos del área Preferences

			try {

				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputAddress1()))) {
					throw new ElementoNoEncontradoException(nombreInputAddress1);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputAddres2()))) {
					throw new ElementoNoEncontradoException(nombreInputAddress2);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputCity()))) {
					throw new ElementoNoEncontradoException(nombreInputCity);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputState()))) {
					throw new ElementoNoEncontradoException(nombreInputState);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputPostalCode()))) {
					throw new ElementoNoEncontradoException(
							nombreInputPostalCode);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getSelectCountry()))) {
					throw new ElementoNoEncontradoException(nombreSelectCountry);
				}

			} catch (ElementoNoEncontradoException e) {
				System.out.println(e.getDescripcion() + e.getMessage());
			}
		} else {

			throw new PaginaNoEncontradaException(registrarUsuario.getTitle());
			// No controlamos la excepción porque el caso de prueba debe fallar

		}
	}// Fin método validarCamposMailing

	@Test(priority = 3)
	public void validarCamposUser() throws Exception {

		try {
			excelCamposRegister = new ExcelUtils("CamposRegister.xlsx",
					ExcelType.XLSX);

			nombreInputUserName = excelCamposRegister.getCellData(10, 0);
			nombreInputPassword = excelCamposRegister.getCellData(11, 0);
			nombreInputConfirmPassword = excelCamposRegister.getCellData(12, 0);

		} catch (IOException e) {

			System.out
					.println("*******************ATENCIÓN*******************************");
			System.out.println(e.getMessage());
			System.out
					.println("**********************************************************");
		}

		// Verifico que me encuentre en la página
		if (driver.getTitle().contentEquals(registrarUsuario.getTitle())) {
			// Validación de los campos del área Preferences

			try {

				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputEmailUser()))) {
					throw new ElementoNoEncontradoException(nombreInputUserName);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputPassword()))) {
					throw new ElementoNoEncontradoException(nombreInputPassword);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputConfirmPassword()))) {
					throw new ElementoNoEncontradoException(
							nombreInputConfirmPassword);
				}
				if (!(registrarUsuario
						.isElementPresentAndDisplay(registrarUsuario
								.getInputEmailUser()))) {
					throw new ElementoNoEncontradoException(nombreInputEmail);
				}

			} catch (ElementoNoEncontradoException e) {
				System.out.println(e.getDescripcion() + e.getMessage());
			}
		} else {

			throw new PaginaNoEncontradaException(registrarUsuario.getTitle());
			// No controlamos la excepción porque el caso de prueba debe fallar

		}
	}// Fin método validarCamposUser
}// Fin clase
