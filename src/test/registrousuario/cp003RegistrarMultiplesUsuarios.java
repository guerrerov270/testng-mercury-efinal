package test.registrousuario;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.MenuNavegacionPage;
import pageObjects.PagesFacade;
import pageObjects.RegistrarUsuarioPage;
import utils.ExcelUtils;
import utils.ExcelUtils.ExcelType;

public class cp003RegistrarMultiplesUsuarios extends TestBase {

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
	public void realizarRegistroMultiple() throws Exception {

		// Diligencio la página con valores desde el data pool
		excelDatosRegistro = new ExcelUtils(
				"DatosRegistroMultiplesUsuarios.xlsx", ExcelType.XLSX);
		int cantidadUsuarios = Integer.parseInt(excelDatosRegistro.getCellData(
				13, 1));
		for (int i = 0; i < cantidadUsuarios; i++) {

			// Voy a registrar
			facade = new PagesFacade();
			menu = facade.getMenuPage();
			facade.irARegistro();
			registrarUsuario = facade.getRegistrarPage();
			firstName = excelDatosRegistro.getCellData(0, 0 + i);
			lastName = excelDatosRegistro.getCellData(1, 0 + i);
			phone = excelDatosRegistro.getCellData(2, 0 + i);
			email = excelDatosRegistro.getCellData(3, 0 + i);
			address1 = excelDatosRegistro.getCellData(4, 0 + i);
			address2 = excelDatosRegistro.getCellData(5, 0 + i);
			city = excelDatosRegistro.getCellData(6, 0 + i);
			state = excelDatosRegistro.getCellData(7, 0 + i);
			postalCode = excelDatosRegistro.getCellData(8, 0 + i);
			country = excelDatosRegistro.getCellData(9, 0 + i);
			userName = excelDatosRegistro.getCellData(10, 0 + i);
			password = excelDatosRegistro.getCellData(11, 0 + i);
			confirmPassword = excelDatosRegistro.getCellData(12, 0 + i);

			registrarUsuario.registrarInformacionContacto(firstName, lastName,
					phone, email);
			registrarUsuario.registrarInformacionCorreo(address1, address2,
					city, state, postalCode, country);
			registrarUsuario.registrarInformacionUsuario(userName, password,
					confirmPassword);

			// verifico la operación
			if (!(menu.getTextLink(menu.getLnkSingOf(), "SIGN-OFF"))) {
				Assert.fail("El link no contiene el texto SIGN-OFF, no está registrado");
			}

			if (!(menu.isElementPresentAndDisplay(menu.getLnkSingOf()))) {
				Assert.fail("El link SIGN-OFF no está presente, el registro no se completó");
			}

			// Doy click a sign off para un nuevo registro
			menu.clickButtonLink(menu.getLnkSingOf());

		} // Fin ciclo for

	}// Fin método realizarRegistro
}
