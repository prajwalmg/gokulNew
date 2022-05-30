package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Locate {
	public static WebElement username(WebDriver driver) {
		// id of username
		WebElement username = driver.findElement(By.id("txtUsername"));
		return username;
	}

	public static WebElement password(WebDriver driver) {
		// id of password
		WebElement password = driver.findElement(By.id("txtPassword"));
		return password;
	}

	public static WebElement login(WebDriver driver) {
		// class name of login
		WebElement login = driver.findElement(By.className("button"));
		return login;
	}

	public static WebElement admin(WebDriver driver) {
		// id of admin
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		return admin;
	}

	public static WebElement qualification(WebDriver driver) {
		// id of qualifications
		WebElement qualification = driver.findElement(By.id("menu_admin_Qualifications"));
		return qualification;
	}

	public static WebElement skills(WebDriver driver) {
		// id of skills
		WebElement skills = driver.findElement(By.id("menu_admin_viewSkills"));
		return skills;
	}

	public static WebElement add(WebDriver driver) {
		// id of add button
		WebElement add = driver.findElement(By.id("btnAdd"));
		return add;
	}

	public static WebElement skname(WebDriver driver) {
		// id of skill name field
		WebElement skname = driver.findElement(By.id("skill_name"));
		return skname;
	}

	public static WebElement save(WebDriver driver) {
		// id of save button
		WebElement save = driver.findElement(By.id("btnSave"));
		return save;
	}

	public static WebElement test(WebDriver driver) {
		// xpath of Testing Demo text Field
		WebElement test = driver.findElement(By.xpath(
				"//a[contains(text(),'Testing Demo')]/parent::td//preceding-sibling::td//input[@name='chkListRecord[]']"));
		return test;
	}

	public static WebElement del(WebDriver driver) {
		// id of delete button
		WebElement del = driver.findElement(By.id("btnDel"));
		return del;
	}

	public static WebElement txt(WebDriver driver) {
		// xpath of successfully deleted text
		WebElement txt = driver.findElement(By.xpath("//div[@class='message success fadable']"));
		return txt;
	}

	public static WebElement titl(WebDriver driver) {
		// xpath to find the element
		WebElement titl = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/form/table/tbody"));
		return titl;
	}

}
