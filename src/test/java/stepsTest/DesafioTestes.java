package stepsTest;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class DesafioTestes {
	public static  AndroidDriver driver;

	@Before
	public void before() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "RQ8MA0F8HRT");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("app",
				"/Users/mac/Documents/Projetos_Estudos/EstudosApiUdemy/EstudosAppiumUdemy/appiumEstudos/src/test/resources/CTAppium_1_2.apk");
		desiredCapabilities.setCapability("autoGrantPermissions", "true");
		desiredCapabilities.setCapability("noReset", "true");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	public static void finalizaTestes() {
		driver.quit();
	}

	@Test
	public void validaForulario() {

		clicarEmFormulario();
		preencherNome("Flávio Dias");
		clicaAccId("console");
		selecionaOpcao("PS4");
		clicaAccId("check");
		clicaAccId("switch");
		clicaBtnTexto("SALVAR");

		assertTrue("Nome não encontrado", retornaValorElelementoPorTexto("Nome: Flávio Dias").contains("Flávio Dias"));
		assertTrue("Console não encontrado", retornaValorElelementoPorTexto("Console: ps4").contains("ps4"));
		assertTrue("Switch On não encontrado", retornaValorElelementoPorTexto("Switch: Off").contains("Off"));
		assertTrue("Checkbox não encontrado", retornaValorElelementoPorTexto("Checkbox: Marcado").contains("Marcado"));

	}

	private void selecionaOpcao(String opcao) {
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='"+opcao+"']")).click();;
	}

	private void clicaAccId(String accId) {
		driver.findElement(MobileBy.AccessibilityId(accId)).click();
	}

	private void preencherNome(String nome) {
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys(nome);
	}

	private void clicarEmFormulario() {
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();;
	}

	private void clicaBtnTexto(String txt) {
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+txt+"']")).click();
	}

	private String retornaValorElelementoPorTexto(String txt) {
		return driver.findElement(By.xpath("//*[@text='"+txt+"']")).getText();
	}
}
