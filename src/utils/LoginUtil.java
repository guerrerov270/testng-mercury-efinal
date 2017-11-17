package utils;

import base.TestBase;
import pageObjects.FindFlightPage;
import pageObjects.LoginPage;
import utils.ExcelUtils.ExcelType;

/**
 * Clase que realiza la autenticación en Mercury Tours, fue creada para ser
 * usada desde los distintos casos de prueba y así evitar el duplicado de
 * código, la realización de la misma acción en cada caso de prueba.
 * 
 * @author finguerrero
 *
 */
public class LoginUtil {

	protected LoginPage login;
	protected FindFlightPage findFlight;
	// Utilidad para el manejo de excel
	static ExcelUtils excelDatosLogin;
	static ExcelUtils excelTitulosPaginas;
	private String userName = "";
	private String password = "";
	TestBase test;

	public void hacerLogin() throws PaginaNoEncontradaException {
		try {
			// Se crea la instancia para manejar el archivo DatosLogin.xlsx
			excelDatosLogin = new ExcelUtils("DatosLogin.xlsx", ExcelType.XLSX);
			userName = excelDatosLogin.getCellData(1, 1);
			password = excelDatosLogin.getCellData(1, 2);

			// Se crea la instancia para manejar el archivo TitulosPaginas.xlsx
			excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
					ExcelType.XLSX);

			test = new TestBase();
			login = new LoginPage(test.getDriver(),
					excelTitulosPaginas.getCellData(1, 0));
			login.loginMercuryTours(userName, password);
			findFlight = new FindFlightPage(test.getDriver(),
					excelTitulosPaginas.getCellData(2, 0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Verifico que me encuentre en la página Find Flight que es la que debe
		// aparecer después de realizar la autenticación de manera correcta
		// Verifico que me encuentre en la página
		if (!(test.getDriver().getTitle().contentEquals(findFlight.getTitle()))) {
			throw new PaginaNoEncontradaException(findFlight.getTitle());
			// No controlamos la excepción porque el caso de prueba debe fallar
		}

	}// Fin método hacerLogin

	public void hacerLoginIncorrecto() {

		try {
			// Se crea la instancia para manejar el archivo DatosLogin.xlsx
			excelDatosLogin = new ExcelUtils("DatosLogin.xlsx", ExcelType.XLSX);
			userName = excelDatosLogin.getCellData(2, 1);
			password = excelDatosLogin.getCellData(2, 2);

			// Se crea la instancia para manejar el archivo TitulosPaginas.xlsx
			excelTitulosPaginas = new ExcelUtils("TitulosPaginas.xlsx",
					ExcelType.XLSX);

			test = new TestBase();
			login = new LoginPage(test.getDriver(),
					excelTitulosPaginas.getCellData(1, 0));
			login.loginMercuryTours(userName, password);
			findFlight = new FindFlightPage(test.getDriver(),
					excelTitulosPaginas.getCellData(2, 0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	} // Fin método hacerLoginIncorrecto

}// Fin clase LoginUtil
