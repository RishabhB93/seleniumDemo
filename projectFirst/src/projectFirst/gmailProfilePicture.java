package projectFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class gmailProfilePicture {
	
	public static void main(String[] args) {
		String baseUrl = "https:\\gmail.com";
		String driverPath = "E:\\\\webDriver\\\\chromedriver_win32\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriverWait wait;
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(baseUrl);
		driver.manage().window().maximize();
		
		
		WebElement elid = driver.findElement(By.id("identifierId"));
		elid.sendKeys("seleniumdemo22");
		elid = driver.findElement(By.id("identifierNext"));
		elid.click();
		wait = new WebDriverWait(driver,10);
		WebElement elpass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Xb9hP']//input[@type='password']")));
		elpass.sendKeys("Chai@123");
		elpass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));
		elpass.click();

		WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div/a")));
		profile.click();
		profile = driver.findElement(By.xpath("//span[@class='gb_lb']"));
		profile.click();
		//driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@role='dialog']//iframe")));
		//WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=':f.select-files-button']//div[@role='button']")));
		//box.click();
		WebElement box = driver.findElement(By.xpath("//div[@class='oh-Fc-wi-td-u']//input"));
		box.sendKeys("C:\\Users\\Rishabh Babbar\\Desktop\\JAVA\\tony.jpg");
		WebDriverWait wait1 = new WebDriverWait(driver,500);
		WebElement butt = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='button' and @id='picker:ap:3']")));
		butt.click();
	  //driver.switchTo().defaultContent();
	  //driver.navigate().refresh();				
	  //driver.switchTo().window(arg0)	
	  //driver.close();
	}

}
