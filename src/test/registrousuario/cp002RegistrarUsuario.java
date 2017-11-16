package test.registrousuario;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.MenuNavegacionPage;
import pageObjects.PagesFacade;
import pageObjects.RegistrarUsuarioPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp002RegistrarUsuario extends TestBase {

	PagesFacade facade;
	MenuNavegacionPage menu;
	RegistrarUsuarioPage registrarUsuario;
	static ExcelUtils excelDatosRegistro;
	// Valores para realizar el registro de un usuario en la página Register
	private String firstName = "";
	private String lastName = "";
	private String phone = "";
	private String email = "";

	private String address1 = "";
	private String address2 = "";
	private String city = "";
	private String state = "";
	private String postalCode = "";
	private String country = "";

	private String userName = "";
	private String password = "";
	private String confirmPassword = "";

	@Test
	public void ingresarRegistrar() throws FileNotFoundException, IOException {

		facade = new PagesFacade();
		menu = facade.getMenuPage();
		facade.irARegistro();
		registrarUsuario = facade.getRegistrarPage();

	}// Fin método ingresarRegistrar

	@Test(priority = 1)
	public void realizarRegistro() throws Exception {
		

		// Diligencio la página con valores desde el data pool
		excelDatosRegistro = new ExcelUtils("DatosRegistro.xlsx",
				ExcelType.XLSX);
		firstName = excelDatosRegistro.getCellData(0, 0);
		lastName = excelDatosRegistro.getCellData(1, 0);
		phone = excelDatosRegistro.getCellData(2, 0);
		email = excelDatosRegistro.getCellData(3, 0);
		address1 = excelDatosRegistro.getCellData(4, 0);
		address2 = excelDatosRegistro.getCellData(5, 0);
		city = excelDatosRegistro.getCellData(6, 0);
		state = excelDatosRegistro.getCellData(7, 0);
		postalCode = excelDatosRegistro.getCellData(8, 0);
		country = excelDatosRegistro.getCellData(9, 0);
		userName = excelDatosRegistro.getCellData(10, 0);
		password = excelDatosRegistro.getCellData(11, 0);
		confirmPassword = excelDatosRegistro.getCellData(12, 0);

		registrarUsuario.registrarInformacionContacto(firstName, lastName,
				phone, email);
		registrarUsuario.registrarInformacionCorreo(address1, address2, city,
				state, postalCode, country);
		registrarUsuario.registrarInformacionUsuario(userName, password,
				confirmPassword);

		// verifico la operación
		if (!(menu.getTextLink(menu.getLnkSingOf(), "SIGN-OFF"))) {
			Assert.fail("El link no contiene el texto SIGN-OFF, no está registrado");
		}

		if (!(menu.isElementPresentAndDisplay(menu.getLnkSingOf()))) {
			Assert.fail("El link SIGN-OFF no está presente, el registro no se completó");
		}

	}// Fin método realizarRegistro
}
