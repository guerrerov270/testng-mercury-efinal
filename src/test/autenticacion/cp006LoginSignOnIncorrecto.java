package test.autenticacion;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.PagesFacade;

public class cp006LoginSignOnIncorrecto extends TestBase {

	PagesFacade facade;

	@Test
	public void loginIncorrecto() throws FileNotFoundException, IOException {
		facade = new PagesFacade();
		facade.irASignOn();
		facade.hacerLoginIncorrecto();

	}
}
