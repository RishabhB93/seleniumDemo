package projectFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
//import java.util.Set;
import java.util.Set;

public class scenario22 {

	public static void main(String[] args) {
		String baseUrl = "https:\\flipkart.com";
//		String driverPath = "E:\\webDriver\\geckodriver-v0.22.0-win64\\geckodriver.exe";
		String driverPath1 = "E:\\webDriver\\chromedriver_win32\\chromedriver.exe";
//		System.setProperty("webdriver.gecko.driver", driverPath);
		System.setProperty("webdriver.chrome.driver", driverPath1);

//      WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.manage().window().maximize();
		driver.navigate().to(baseUrl);
		
		/*LOGIN*/
		driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='text']")).sendKeys("8178493081");
		WebElement pass = driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='password']"));
		pass.sendKeys("Chai123");
		WebElement button = driver.findElement(By.xpath("//div[@class='_1avdGP']//button"));
		button.click();
//		driver.navigate().refresh();

		Actions action = new Actions(driver);
		WebElement li = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Electronics')]")));
		action.moveToElement(li).build().perform();
		System.out.println("Performing action");
		WebElement li2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Apple']")));
		action.moveToElement(li2).click().perform();
		WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='iPhone']")));
		img.click();
		
		/*ADDING PRODUCTS FOR COMPARE*/	
		List<WebElement> licheck = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_3O0U0u']//div[@class='_1p7h2j']")));
		Iterator<WebElement> itr1 = licheck.iterator();
		for (int i = 0; i <= 3; i++) {
			itr1.next().click();
		}
		WebElement comp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'COMPARE')]")));
		comp.click();
		
		/*CHECK BUTTON IS ENABLED OR NOT*/
		List<WebElement> libtn = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='ADD TO CART']")));
		
		/*GET MINIMUM PRICE*/
		List<WebElement> liprice = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Delivery')]//following::div[@class='_1vC4OE']")));
		Iterator<WebElement> itr2 = liprice.iterator();
		Set<Integer> s1 = new HashSet<Integer>();
		int min=0,k=0,pos=0;
		while(itr2.hasNext()) {
			String s = itr2.next().getText().replaceAll("[₹,]", "");
			System.out.println(s);
//			s1.add(Integer.parseInt(s));
			int j=Integer.parseInt(s);
			int num= j;
			k++;
			if (num < min) {
				min= num;
				pos=k;
			}
		}
		System.out.println(min+"##");
    	System.out.println(pos+"##");
/*		Object obj = Collections.min(s1);
	    System.out.println("Minimum Element of HashSet is : " + obj);
	    String value = obj.toString();
	    System.out.println(value);*/
	    
//    	List<WebElement> li3 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Delivery')]//following::a[@class='_3YNWH1']")));
    	List<WebElement> li4 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Delivery')]//following::div[@class='_1vC4OE']")));
//    	Iterator<WebElement> itr3 = li3.iterator();
    	Iterator<WebElement> itr4 = li4.iterator();
    	String s="",s2 = "";
    	for(int i=0; i<=pos; i++) {
//  		s = itr3.next().getText();
    		s2 = itr4.next().getText();
    	}
//   	System.out.println(s+"!!");
    	System.out.println(s2+"%%");
    	
    	List<WebElement> li5 = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Delivery')]//following::div[@class='_1vC4OE']")));
    	List<Integer> lipos = new ArrayList<Integer>();
  //  	List<WebElement> li5 = driver.findElements(By.xpath("//span[contains(text(),'Delivery')]//following::div[contains(text(),'"+s2+"')]"));
    	Iterator<WebElement> itr5 = li5.iterator();
    	int i=2;
	    while(itr5.hasNext()) {
	    	String price = itr5.next().getText();
	    	System.out.println(price);
	    	if(price.equals(s2))
	    		lipos.add(i);
	    	i++;
	    }
	    Iterator<Integer> itr6 = lipos.iterator();
	    while(itr6.hasNext())
	    	System.out.println(itr6.next()+"++");
	    
	    int count=2;
	    for(int r=0; r<lipos.size(); r++) {
	    	WebElement web1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2lK_YI']/div[3]/div["+lipos.get(r)+"]/a")));
	    	WebElement web2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2lK_YI']/div[4]/div["+lipos.get(r)+"]/div/div[1]")));
	    	System.out.println(web1.getText());
	    }
	    	/*if(j==lipos.get(j)) {
	    		System.out.println(itr7.next().getText()+"^^");
	    		System.out.println(j);
	    	}
	    	j++;*/
	    
//	    driver.findElement(By.xpath("//span[contains(text(),'Delivery')]//following::div[contains(text(),'16,999')]"));
//	    driver.findElement(By.xpath("//div[contains(text(),'15,999')]/../../../..//a"));
	    
//		for (WebElement e : libtn) {
//			if (e.isEnabled()) {
//				
//			}
//			else{
//				libtn.remove(e);				
//			}	
//		}

// 		Iterator<WebElement> itr2 = libtn.iterator();
//    	while(itr2.hasNext()) {
//    		
//    		if()
//    	}
	    
	  //div[contains(@class,'_1SVp3c')]/div[@class='_1k1axX _1DLH7w']//div[@class='col-4-5']/div/div[]/a
	  //div[@class='_2lK_YI']/div[3]/div[5]/a
	}
}
