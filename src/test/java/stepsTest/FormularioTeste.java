package stepsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTeste {
	private AndroidDriver driver;

//	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
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

		java.util.List<MobileElement> elementosEncontrados = driver
				.findElements(By.className("android.widget.TextView"));
		elementosEncontrados.get(1).click();

		MobileElement nome = (MobileElement) driver.findElement(MobileBy.AccessibilityId("nome"));
		nome.sendKeys("Flávio Dias");

		assertEquals("Flávio Dias", nome.getText());
		driver.quit();
	}

//	@Test
	public void devePreencherCampoTextoCombo() throws MalformedURLException {
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

		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		driver.findElement(MobileBy.AccessibilityId("console")).click();

		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		String textSelecionado = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView"))
				.getText();
		assertEquals("Nintendo Switch", textSelecionado);
		driver.quit();
	}

	@Test
	public void deveInteragirCheckBox() throws MalformedURLException {
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

		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

		MobileElement check = (MobileElement) driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement swt = (MobileElement) driver.findElement(MobileBy.AccessibilityId("switch"));
		
		swt.getAttribute("checked");// Pega o atributo checked e retorna true ou false - String true ou false
		check.getAttribute("checked");// String true ou false
		
		assertTrue("Esperado false",check.getAttribute("checked").equals("false"));
		assertTrue("Esperado false",swt.getAttribute("checked").equals("true"));
		
		//Altera estados
		check.click();
		swt.click();
		
		assertFalse("Esperado false",check.getAttribute("checked").equals("false"));
		assertFalse("Esperado false",swt.getAttribute("checked").equals("true"));

		
		
		driver.quit();
		
	}

}
