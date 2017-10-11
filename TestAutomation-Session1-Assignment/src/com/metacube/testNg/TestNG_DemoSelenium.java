package com.metacube.testNg;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_DemoSelenium {
	//Web driver for chrome browser
	WebDriver driverChrome =  new ChromeDriver();
	//Web driver for internet explorer browser
	WebDriver driverIE;
	//Web driver for firefox browser
	WebDriver driverFirefox;
	
	/**
	 * Which must be executed before the test cases at start up
	 * @throws InterruptedException
	 */
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\user10\\Desktop\\workspace\\TestAutomationFolder\\TestAutomationFolder\\drivers\\IEDriverServer_Win32_3.6.0\\IEDriverServer.exe");
		
		
		System.out.println("In Before Test");
	}
	
	//To check on Browser chrome
	@Test(priority=1)
	public void testLinkFoundOnChrome() throws InterruptedException {
		driverChrome.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		driverChrome.findElement(By.className("login")).click();
		driverChrome.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driverChrome.findElement(By.id("passwd")).sendKeys("testing123");
		driverChrome.findElement(By.id("SubmitLogin")).click();
		assertNotNull(driverChrome.findElement(By.className("alert-danger")));
	}
	
	//To check on browser IE
	@Test(priority=2)
	public void testLinkFoundOnIE() throws InterruptedException {
		driverIE =  new InternetExplorerDriver();
		driverIE.get("http://automationpractice.com/index.php");
		Thread.sleep(1000);
		driverIE.findElement(By.className("login")).click();
		driverIE.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driverIE.findElement(By.id("passwd")).sendKeys("testing123");
		driverIE.findElement(By.id("SubmitLogin")).click();
		assertNotNull(driverIE.findElement(By.className("alert-danger")));
	}
	
	//To check on browser firefox
	@Test(priority=3)
	public void testLinkFoundOnFirefox() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\user10\\Desktop\\workspace\\TestAutomationFolder\\TestAutomationFolder\\drivers\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		driverFirefox =  new FirefoxDriver();
		Thread.sleep(2000);
		driverFirefox.get("http://automationpractice.com/index.php");
		driverFirefox.findElement(By.className("login")).click();
		driverFirefox.findElement(By.id("email")).sendKeys("abc@xyz.com");
		driverFirefox.findElement(By.id("passwd")).sendKeys("testing123");
		driverFirefox.findElement(By.id("SubmitLogin")).click();
		assertNotNull(driverFirefox.findElement(By.className("alert-danger")));
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		System.out.println("In After Test");
		Thread.sleep(1000);
		
	}
}