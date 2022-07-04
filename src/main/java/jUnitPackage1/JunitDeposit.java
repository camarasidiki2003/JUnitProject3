package jUnitPackage1;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class JunitDeposit { 
	/* 
	 Scenario: CRM -> Customers -> Add Contact - Add contact and validate contact added in List Contacts
Open Browser and go to site http://techfios.com/test/billing/?ng=admin/
Enter username:  demo@techfios.com 
Enter password: abc123
Click login button
Click on Customers button in the Side Navigation
Click on Add Customer
Fill in the Add Customer Form
Click submit
Go to CRM -> List Customer Page
Search for the new Customer in the search field
Validate contact Customer ​
	 */
	
	// declaration of the webDriver
	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("before class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("after class");
	}
	   
	    
	    @Before
		public void launchBrowser() {
			System.out.println("before method");
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver = new ChromeDriver(); // object variable
			driver.manage().deleteAllCookies();
			driver.get("https://techfios.com/billing/?ng=admin/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		   @Test
		    public void loginTest() {
		   	System.out.println("test method");
			// identify user name element & data insertion
			driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
			// identify password element & data insertion
			driver.findElement(By.id("password")).sendKeys("abc123");
			// identify sign in element & click
			driver.findElement(By.name("login")).click();
			//assertion
			//Assert.;
			//another way to do assert
			//Assert.assert
			System.out.println("This is the account opening part");
			// clicking on Bank & Cash
			driver.findElement(By.partialLinkText("Bank & Cash")).click();
			driver.findElement(By.partialLinkText("New Account")).click();
			//Thread.sleep(5000);
			//file upload
			//identify the elemnt, use sendkeys as long as it is tag input
			//driver.findElement("")).sendkeys;
			//any other ytage you will have to use robot class
			
			// filing out the new account information
			System.out.println("This is ti fill out the account information");
			driver.findElement(By.id("account")).sendKeys("Saving Account");
			driver.findElement(By.id("description")).sendKeys("I am keeeping my saving here");
			driver.findElement(By.id("balance")).sendKeys("$129,000");
			driver.findElement(By.id("account_number")).sendKeys("214723387300");
			driver.findElement(By.id("contact_person")).sendKeys("Bintu C");
			driver.findElement(By.id("ib_url")).sendKeys("www.techfios.com/billing/?ng=admin/");
			//Thread.sleep(3200);
			driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		    //driver.findElement(By.partialLinkText("alert alert-success fade in"));
			//WebElement expected= driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]"));
			//String actualUrl="";
	        
		
				
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click();
			driver.findElement(By.partialLinkText("Dashboard")).click();
		    //driver.findElement(By.xpath("//div[@id='page-wrapper']//input[@id='account']")).sendKeys("Sidy");	
			driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")).click();
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
			driver.findElement(By.linkText("Add Customer")).click();
			driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Sidi");
			//driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();
			
			//driver.finElement(By.name());
				
			
					
			
			By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		
			
			Assert.assertTrue("Wrong Page!!!", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
			
//			Assert.assertEquals("Dashboard page not found!!", "Dashboard", driver.findElement(DASHBOARD_HEADER_FIELD).getText());
//			System.out.println(driver.findElement(DASHBOARD_HEADER_FIELD).getText());
			
			//Assert.assertEquals("Dashboard page not found!!", "Dashboard- iBilling", driver.getTitle());
//			System.out.println(driver.getTitle());
			
			//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
			//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
			
			By COUNTRY_DROPDOWN_FIELD = By.xpath("//*[@id=\"cid\"]");
			
			Select sel = new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
			sel.selectByVisibleText("Amazon");
			
			//homework
			sel.getOptions();
			
			driver.findElement(By.name("email")).sendKeys("sc22@techfios.com");
			driver.findElement(By.id("phone")).sendKeys("2140002010");
			driver.findElement(By.name("address")).sendKeys(" 6451 public rd ");
			driver.findElement(By.name("city")).sendKeys("Dallas");
			driver.findElement(By.name("state")).sendKeys("Texas");
			driver.findElement(By.id("zip")).sendKeys("75253");
			      //Drop Down to handle list of countries
			
	    By ALLCOUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id='country']");
			
			Select sel2 = new Select(driver.findElement(ALLCOUNTRY_DROPDOWN_FIELD));
			sel2.selectByVisibleText("Guinea");
			//driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']")).sendKeys("QA training");
			driver.findElement(By.id("submit")).click();
			
			//Drop Down to handle list of currencies
			
	        By CURRENCYY_DROPDOWN_FIELD = By.xpath("//SELECT[@ID='currency']");
				
				Select sel3 = new Select(driver.findElement(CURRENCYY_DROPDOWN_FIELD));
				sel3.selectByVisibleText("USD");
				//Drop Down to handle list of countries
				
		        By GROUP_DROPDOWN_FIELD = By.xpath("//*[@id=\'group\']");
					
					Select sel4 = new Select(driver.findElement(GROUP_DROPDOWN_FIELD));
				
					sel4.selectByVisibleText("SQL");
					
					//driver.findElement(By.xpath("//*[@id=\\'submit\\']\"")).click();
					
			
					
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/a/span[1]")).click();
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click();
					driver.findElement(By.partialLinkText("Dashboard")).click();
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a"));
					driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")).click();
					driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")).click();
					driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
			        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")).click();
			        
			        
			        driver.findElement(By.xpath("//input[@id='foo_filter']")).sendKeys("2140002010");
			
			
			
			
		}
	
		
		    
		    
		    
		    
		    
		    
		    
		   
		   
		   
		   
		   
		   
		  
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		    
		    //@BeforeTest
			public void launchMyBrowser() {
				System.out.println("Setting System Property and launching the browser, bear with me");
				System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.get("https://techfios.com/billing/?ng=admin/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
			   //@Test
			    public void login() {
			     WebElement USER_NAME_ELEMENT = driver.findElement(By.id("username"));
				 WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//*[@id=\"password\"]"));
				 WebElement SIGNIN_BUTTON_ELEMENT = driver.findElement(By.name("login"));
				 By DASHBOARD_HEADER_FIELD = By.xpath("//h2[normalize-space()='Dashboard']");
			   	System.out.println("test method, Login to the website now");
				USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
				PASSWORD_ELEMENT.sendKeys("abc123");
				SIGNIN_BUTTON_ELEMENT.click();
				//assertion
				System.out.println("This is the account opening part, asserting it to validation the page");
				Boolean pageTitleDisplay;
				try {
					WebElement DASHBOARD_HEADER_ELEMENT = driver.findElement(DASHBOARD_HEADER_FIELD);
					pageTitleDisplay = true;
				}catch(Exception e) {
					pageTitleDisplay = false;
					e.printStackTrace();
					
				} 
				// Explicit wait
				// WebDriverWait wait = new WebDriverWait(driver, 5);
				// wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_HEADER_FIELD)); 
			   //}
			   //@Test
				//public void newCustomer() {
					System.out.println("Welcome you made to the dashboard, next step...:");
					System.out.println("Please bear with I am about to create a new account for a new customer");
					System.out.println("I am auto clicking on Customers button in the Side Navigation now");
					//driver.findElement(By.cssSelector("body > section:nth-child(1) > div:nth-child(1) > nav:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1) > span:nth-child(2)"));
					//driver.findElement(By.xpath("//span[normalize-space()='Customers']"));
					driver.findElement(By.linkText("Add Customer")).click();
					driver.findElement(By.xpath("//a[normalize-space()='Add Customer']")).click();	
					System.out.println("Let go ahead and fill the blanks");			
					driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Sid camus");
					By COUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id='cid']");
					Select sel = new Select(driver.findElement(COUNTRY_DROPDOWN_FIELD));
					sel.selectByVisibleText("ATT");
					sel.getOptions();
					driver.findElement(By.name("email")).sendKeys("myemail@techfios.com");
					driver.findElement(By.id("phone")).sendKeys("214526310");
					driver.findElement(By.name("address")).sendKeys(" 65551 mypublic st ");
					driver.findElement(By.name("city")).sendKeys("Dallas");
					driver.findElement(By.name("state")).sendKeys("Texas");
					driver.findElement(By.id("zip")).sendKeys("75258");
					 By ALLCOUNTRY_DROPDOWN_FIELD = By.xpath("//select[@id='country']");
						
						Select sel2 = new Select(driver.findElement(ALLCOUNTRY_DROPDOWN_FIELD));
						sel2.selectByVisibleText("United States");
					
						
						driver.findElement(By.id("submit")).click();
						
						//Drop Down to handle list of currencies
						
				        By CURRENCYY_DROPDOWN_FIELD = By.xpath("//SELECT[@ID='currency']");
							
							Select sel3 = new Select(driver.findElement(CURRENCYY_DROPDOWN_FIELD));
							sel3.selectByVisibleText("USD");
							//Drop Down to handle list of countries
							
					        By GROUP_DROPDOWN_FIELD = By.xpath("//*[@id=\'group\']");
								
								Select sel4 = new Select(driver.findElement(GROUP_DROPDOWN_FIELD));
							
								sel4.selectByVisibleText("SQL");
								
								driver.findElement(By.xpath("//*[@id=\\'submit\\']\"")).click();
								
								System.out.println("Let set a password for the new user");
								driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
								driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys("abc123");
					
					
					driver.findElement(By.id("description")).sendKeys("I am keeeping my saving here");
					driver.findElement(By.id("balance")).sendKeys("$129,000");
					driver.findElement(By.id("account_number")).sendKeys("214723387300");
					driver.findElement(By.id("contact_person")).sendKeys("Bintu C");
					driver.findElement(By.id("ib_url")).sendKeys("www.techfios.com/billing/?ng=admin/");
					//Thread.sleep(3200);
					driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
					
				}
			    
			    
			    
			    
		
		
}
	   