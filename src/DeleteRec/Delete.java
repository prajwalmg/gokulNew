package DeleteRec;

//import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Screenshot;
import Locators.Locate;
import Utility.Driverclass;
import Utility.Excel;

public class Delete {
	public static WebDriver driver;
	public static String username;
	public static String password;
	public static String skillname;
	public static String msg;
	public static int count = 0;

	// opening browser importing from driver class (enter chrome or edge in console)
	public void openBrowser() {
		// open method from driverclass for opening browser
		driver = Driverclass.open();
		// invoking screenshot method from screenshot class
		Screenshot s = new Screenshot();
		// screenshot of main page
		s.Screenshots("mainpage", driver);

	}

	// browser close
	public void closeBrowser() {
		// driverquit method from driverclass for closing browser
		Driverclass.driverQuit();
	}

	// main code
	public void orangehrm() {
		// invoking screenshot
		Screenshot s = new Screenshot();
		// invoking excel
		Excel read = new Excel();
		username = read.readExcel("C:\\Users\\Admin\\eclipse-workspace\\JavaProject\\excel\\read.xlsx", "read", 0, 0);
		password = read.readExcel("C:\\Users\\Admin\\eclipse-workspace\\JavaProject\\excel\\read.xlsx", "read", 0, 1);
		skillname = read.readExcel("C:\\Users\\Admin\\eclipse-workspace\\JavaProject\\excel\\read.xlsx", "read", 0, 2);
		System.out.println("Username is:" + username);// print name
		System.out.println("Password is:" + password);// print password
		System.out.println("SkillName is:" + skillname);// print the text taken as input
		Locate.username(driver).sendKeys(username);// taking username
		Locate.password(driver).sendKeys(password);// taking password
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		Locate.login(driver).click();// clicking login button
		Locate.admin(driver).click();// clicking on admin
		Locate.qualification(driver).click();// clicking on qualification
		Locate.skills(driver).click();// clicking on skills
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		// taking screenshot on skillsmenu
		s.Screenshots("skillsmenu", driver);

		Locate.add(driver).click();// clicking on add button
		Locate.skname(driver).sendKeys(skillname);// giving input text as mentioned
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		// taking screenshot on skillinput page
		s.Screenshots("skillInputPage", driver);
		Locate.save(driver).click();// click on save button
		Locate.test(driver).click();// click on the checkbox corresponding to the text(mentioned)
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		// taking screenshot on checkbox
		s.Screenshots("checkbox", driver);
		Locate.del(driver).click();// clicking on delete button
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);
		msg = Locate.txt(driver).getText();// getting the successful mesaage
		// taking screenshot on successfully deleted text
		s.Screenshots("successfulmsg", driver);
		System.out.println(msg);
		// checking sucessfull message is appeared or not
		if (msg.equals("Successfully Deleted")) {
			System.out.println("Skill deleted Successfully");
		} else {
			System.out.println("Skill not deleted");
		}

		// to verify that particular skill not present after deleting or not
		WebElement Titles = Locate.titl(driver);
		List<WebElement> TitleLinks = Titles.findElements(By.tagName("tr"));
		for (WebElement skill : TitleLinks) {
			String listText = skill.getText();
			if (listText.equals("Testing Demo"))
				count++;
		}
		if (count == 0) {
			System.out.println("Testing Demo skill is not Present");// printing if skill not present

		} else {
			System.out.println("Testing Demo Skill is present");// printing if skill is present
		}

	}

	public static void main(String[] args) {
		Delete d = new Delete();
		d.openBrowser();
		d.orangehrm();
		d.closeBrowser();
	}

}
