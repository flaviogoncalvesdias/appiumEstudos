package page;

import java.net.MalformedURLException;

import core.DSL;

public class MenuPage {
	
	private DSL dsl;
	
	public MenuPage() throws MalformedURLException{
		dsl = new DSL();
	}
	
	public void acessarFormulario() {
		dsl.clicarEmFormulario();

	}

}
