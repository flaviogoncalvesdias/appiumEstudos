package stepsTest;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import core.DSL;
import core.DriveFactory;
import page.FormularioPage;
import page.MenuPage;

public class DesafioTestes {
	private DSL dsl;
	private MenuPage menu;
	private FormularioPage formulario;


	@Before
	public void iniciaTeste() throws MalformedURLException {
		menu = new MenuPage();
		formulario = new FormularioPage();

	}

	@AfterClass
	public static void finalizaTestes() {
		DriveFactory.killDriver();
	}

	@Test
	public void validaForulario() throws MalformedURLException {
		menu.acessarFormulario();
		formulario.escreverNome("Flávio Dias");
		formulario.clicarLista();
		formulario.selecionarConsole("PS4");
		formulario.clicarCheck();
		formulario.clicarCombo();
		formulario.clicarSalvar();
		

		assertTrue("Nome não encontrado", formulario.obterTextoPorNome("Nome: Flávio Dias").contains("Flávio Dias"));
		assertTrue("Console não encontrado", formulario.obterTextoPorNome("Console: ps4").contains("ps4"));
		assertTrue("Switch On não encontrado", formulario.obterTextoPorNome("Switch: Off").contains("Off"));
		assertTrue("Checkbox não encontrado", formulario.obterTextoPorNome("Checkbox: Marcado").contains("Marcado"));

	}

}
