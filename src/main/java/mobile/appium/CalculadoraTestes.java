package mobile.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTestes {
	
	
	@Test
	public void testeCalc() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "ce071827b85d4e09047e");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    int a = 2;
	    int b = 3;
	    int soma = a + b;
		
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
		Thread.sleep(1000);
		MobileElement firstNumber = driver.findElementById("com.google.android.calculator:id/digit_" + a);
	    firstNumber.click();
	    MobileElement plus = driver.findElementByAccessibilityId("mais");
	    plus.click();
	    MobileElement secondNumber = driver.findElementById("com.google.android.calculator:id/digit_" + b);
	    secondNumber.click();
	    MobileElement equals = driver.findElementById("com.google.android.calculator:id/eq");
	    equals.click();
	    MobileElement result = driver.findElementById("com.google.android.calculator:id/result");
	    
	    String result_string = result.getText();
	    
	    boolean condition = soma == Integer.parseInt(result_string);
	    
	    String message = condition ? "A soma confere com o esperado." : "O resultado não confere com o esperado.";
	    
	    Assert.assertTrue(message, condition);
	    
	    
	    
	    //driver.quit();
	}

}
