package Y4;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAppPoly {

	WebDriver driver;

	String email = "trinhlbpd07664@fpt.edu.vn";
	String pass = "Larrylenw2004@.";

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\larry\\chromedriver\\chromedriver.exe");
		System.out.println("before method");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

	}

	@Parameters({ "path" })
	@Test
	public void Run() {
		driver.get("https://fpl3.poly.edu.vn/login.php?target=&client_id=fpolyhn&auth_stat=");
		sleep(1000);
		WebElement emailInput = driver.findElement(By.id("username"));
		emailInput.sendKeys(email);
		sleep(100);
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(pass);
		sleep(100);
//		buttonNext.click();
//		sleep(1000);
		WebElement button = driver.findElement(By.cssSelector("button.btn-sm"));
		sleep(1000);
		button.click();
//		buttonNext.click();
	}

	

//	@AfterTest
//	public void CleanUp() {
////		driver.quit();
//	}
//
	public void sleep(int time) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
