package page;

import java.net.MalformedURLException;

import core.DSL;

public class FormularioPage {

	private DSL dsl;

	public FormularioPage() throws MalformedURLException {
		dsl = new DSL();
	}

	public void escreverNome(String nome) {
		dsl.preencherNome(nome);
	}

	public String obterTextoPorNome(String nome) {
		return dsl.retornaValorElelementoPorTexto(nome);
	}

	public void clicarLista() {
		dsl.clicaAccId("console");
	}

	public void clicarCheck() {
		dsl.clicaAccId("check");

	}

	public void clicarCombo() {
		dsl.clicaAccId("switch");

	}

	public void selecionarConsole(String console) {
		dsl.selecionaOpcao(console);

	}

	public void clicarSalvar() {
		dsl.clicaBtnTexto("SALVAR");

	}

}
