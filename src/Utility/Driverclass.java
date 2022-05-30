package Utility;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driverclass {
	public static WebDriver driver;
	public static String baseURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login"; // URL
	private static Scanner sc;

	public static WebDriver open() {
		sc = new Scanner(System.in);
		System.out.println("Choose Chrome or Edge to run \nEnter the browser name:");
		String browser = sc.nextLine();
		// string "browser" is taken where either "Chrome"or "Edge" is to be written for
		// opening Chromedriver or edgedriver respectively
		if (browser.equalsIgnoreCase("chrome")) {
			// chrome Driver
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium software\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			// Edge driver
			System.setProperty("webdriver.edge.driver", "E:\\Selenium software\\Edge\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static void driverQuit() {
		driver.quit();
	}

}
