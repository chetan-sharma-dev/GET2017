package com.metacube.testNg;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_LoginCheck {
	//Web driver for chrome browser
	WebDriver driverChrome;
	//Web driver for firefox browser
	WebDriver driverFirefox;
	//Web driver for internet explorer browser
		WebDriver driverIE;
	
	/**
	* Initializes are the driver
	* executed before all test cases
	* @throws InterruptedException
	*/
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driverChrome =  new ChromeDriver();
		driverChrome.get("http://automationpractice.com/index.php");
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user10\\Desktop\\workspace\\TestAutomationFolder\\TestAutomationFolder\\drivers\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		driverFirefox =  new FirefoxDriver();
		driverFirefox.get("http://automationpractice.com/index.php");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\user10\\Desktop\\workspace\\TestAutomationFolder\\TestAutomationFolder\\drivers\\IEDriverServer_Win32_3.6.0\\IEDriverServer.exe");
		driverIE =  new InternetExplorerDriver();
		driverIE.get("http://automationpractice.com/index.php");
	}
	
	
	
	
	/**
	 * Test case to test account creation for chrome
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	public void testAccountCreationForChrome() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverChrome.findElement(By.id("email_create")).sendKeys("ai@metacube.com");
		driverChrome.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(3000);
		assertEquals(driverChrome.getCurrentUrl(), 
				"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}

	/**
	 * Test case to test forgot password for chrome
	 * @throws InterruptedException
	 */
	@Test(priority=2)
	public void testForgotPasswordForChrome() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		driverChrome.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		assertEquals(driverChrome.getTitle(), "Forgot your password - My Store");
	}
	
	/**
	 * Test case to test account creation for firefox
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void testAccountCreationForFireFox() throws InterruptedException {
		driverFirefox.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverFirefox.findElement(By.id("email_create")).sendKeys("ai@metacube.com");
		driverFirefox.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(5000);
		assertEquals(driverFirefox.getCurrentUrl(), 
				"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}
	
	/**
	 * Test case to test forgot password for firefox
	 * @throws InterruptedException
	 */
	@Test(priority=4)
	public void testForgotPasswordForFireFox() throws InterruptedException {
		driverFirefox.findElement(By.className("login")).click();
		driverFirefox.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		assertEquals(driverFirefox.getTitle(), "Forgot your password - My Store");
	}
	
	/**
	 * Test case to test account creation for IE
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void testAccountCreationForIE() throws InterruptedException {
		driverIE.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverIE.findElement(By.id("email_create")).sendKeys("ai@metacube.com");
		driverIE.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(6000);
		assertEquals(driverIE.getCurrentUrl(), 
				"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}
	
	/**
	 * Test case to test forgot password for IE
	 * @throws InterruptedException
	 */
	@Test(priority=6)
	public void testForgotPasswordForIE() throws InterruptedException {
		driverIE.findElement(By.className("login")).click();
		driverIE.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		assertEquals(driverIE.getTitle(), "Forgot your password - My Store");
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(1000);
		driverChrome.quit();
		driverFirefox.quit();
		driverIE.quit();
	}
}