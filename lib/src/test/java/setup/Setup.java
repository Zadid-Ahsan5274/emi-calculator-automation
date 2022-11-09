package setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class Setup {

	public static final String PACKAGE_NAME = "com.continuum.emi.calculator";
	public AndroidDriver driver;

	@BeforeTest
	public AndroidDriver setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "Realme");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("uuid", "75USOJ8HKBZTFEDY");
		cap.setCapability("appPackage", "com.continuum.emi.calculator");
		cap.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
		cap.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/emicalculator.apk");
		cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, "true");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

}
