package projectFirst;

import java.util.Iterator;
import java.util.List;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.lang.String;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productFlipkart {
	public static void main(String[] args) throws InterruptedException {
		String baseUrl = "https:\\flipkart.com";
	//	String driverPath = "E:\\webDriver\\geckodriver-v0.22.0-win64\\geckodriver.exe";
		String driverPath1 = "E:\\webDriver\\chromedriver_win32\\chromedriver.exe";
	//	System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath1);
				
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='text']")).sendKeys("8178493081");
		WebElement pass = driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='password']"));
		pass.sendKeys("Chai123");
//		pass.submit();
		WebElement button = driver.findElement(By.xpath("//div[@class='_1avdGP']//button"));
		button.click();
    	driver.navigate().refresh();
		
		/*Duration time ;
		FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(20,TimeUnit.SECONDS).pollingEvery(1000,TimeUnit.MILLISECONDS)
				.ignoring(StaleElementReferenceException.class);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='vh79eN']")));
		WebElement search = wait2.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return 	driver.findElement(By.xpath("//input[@class='LM6RPg']"));
			}
		});*/
				
		WebElement search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		search.sendKeys("dell laptop");
//		search.getText();
		search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='vh79eN']")));
		search.click();
//		search.submit();
//		Thread.sleep(200);
//		WebElement search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
//		search.sendKeys("iphone x");
//		search.submit();
//		WebElement search;
//		for(int i=0; i<2;i++){
//			  try{
//			     search = driver.findElement(By.xpath("//input[@class='LM6RPg']"));
//			     search.sendKeys("iphone");
//				 search.submit();
//			     break;
//			  }
//			  catch(Exception e){
//			     System.out.println(e.getMessage());
//			  }
//			}
		
		/*GET MAXIMUM ELEMENT AND ITS POSITION*/
		List<WebElement> elemList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='_38sUEc']")));
		Iterator<WebElement> itr = elemList.iterator();
		int max=0,k=0,pos=0;
		while(itr.hasNext()) {
			String s = itr.next().getText().replaceAll("\\p{P}", "");
			s = s +'\0';
			String s1 = "";
			int i=0;
			while(s.charAt(i) != ' ' && s.charAt(i) != '\0') {
				 s1= s1 + s.charAt(i);
				 i++;
			}
			int j=Integer.parseInt(s1);
			int num= j;
			k++;
			if (num > max) {
				max= num;
				pos=k;
			}
		}
		System.out.println(max+"##");
    	System.out.println(pos+"##");
		List<WebElement> list1 = driver.findElements(By.xpath("//span[@class='_38sUEc']/../../div[1]"));
		List<WebElement> list2 = driver.findElements(By.xpath("//span[@class='_38sUEc']"));
		Iterator<WebElement> itr1,itr2,itr3,itr4,itr5 ;
		itr1 = list1.iterator();
		itr2 = list2.iterator();
		String s1="",s2 = "";
		for(int j=1; j<=pos; j++) {
			s1 = itr1.next().getText();
			s2 = itr2.next().getText();
		}
		System.out.println(s1+"@@");
		System.out.println(s2+"##");
		String[] a = s2.split(" ");
		String s = a[0];
//	    System.out.println(s+"&&");
	    
	    List<WebElement> list3 = driver.findElements(By.xpath("//span[contains(text(),'"+s+"')]"));
	    itr3 = list3.iterator();
	    while(itr3.hasNext())
	    	System.out.println(itr3.next().getText());
	    WebElement element1 = null ;
	    boolean flag=true;
	    try {
		   element1 = driver.findElement(By.xpath("//div[contains(@class,'_1UoZlX')]"));
	    }
	    catch(NoSuchElementException ex) {
	    	flag=false;  
	    }
	    
	    /* LIST VIEW */	
	    if(flag) {  
	    	List<WebElement> list4 = driver.findElements(By.xpath("//span[contains(text(),'"+s+"')]/../../../../div[1]"));
	    	List<WebElement> list5 = driver.findElements(By.xpath("//span[contains(text(),'"+s+"')]/../../..//div"));
	    	itr4 = list4.iterator();
	    	itr5 = list5.iterator();
	    	while(itr4.hasNext()) {
	    		System.out.println(itr4.next().getText());
	    		System.out.println(itr5.next().getText());
	    	}
	    }
	    /* GRID VIEW */
	    else {
	    	List<WebElement> list4 = driver.findElements(By.xpath("//span[contains(text(),'"+s+"')]/../..//a[2]"));
	    	List<WebElement> list5 = driver.findElements(By.xpath("//span[contains(text(),'"+s+"')]/.. //div[1]"));
	    	itr4 = list4.iterator();
	    	itr5 = list5.iterator();
	    	while(itr4.hasNext()) {
	    		System.out.println(itr4.next().getText());
	    		System.out.println(itr5.next().getText());
	    	}
	    } 	
//	 driver.close();
	}
}
