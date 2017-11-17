package test.autenticacion;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.PagesFacade;
import utils.PaginaNoEncontradaException;

public class cp002LoginMercuryCorrecto extends TestBase {

	PagesFacade facade;

	@Test
	public void loginCorrecto() throws FileNotFoundException, IOException,
			PaginaNoEncontradaException {

		facade = new PagesFacade();
		facade.hacerLogin();
	}
}
