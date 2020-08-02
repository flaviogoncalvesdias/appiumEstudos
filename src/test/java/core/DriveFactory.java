package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriveFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() throws MalformedURLException {

		if (driver == null) {
			createDriver();
		}
		return driver;

	}

	private static void createDriver() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "RQ8MA0F8HRT");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("app",
				"/Users/mac/Documents/Projetos_Estudos/EstudosApiUdemy/EstudosAppiumUdemy/appiumEstudos/src/test/resources/CTAppium_1_2.apk");
		desiredCapabilities.setCapability("autoGrantPermissions", "true");
		desiredCapabilities.setCapability("noReset", "true");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void killDriver() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
