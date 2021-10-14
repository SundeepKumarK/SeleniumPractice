import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class SelProject {
	static WebDriver driver;
	static String URL;
 public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "/Users/kumarsu5/Downloads/chromedriver_win32/chromedriver.exe");
  	register();
	login();

 }
 
@SuppressWarnings("deprecation")
public static void register(){
	 	  driver=new ChromeDriver();
	  URL="http://automationpractice.com/index.php";

	  driver.get(URL);
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.manage().window().maximize();
	  
	  //Click on Sign in
	  driver.findElement(By.linkText("Sign in")).click();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  //Enter email address
	  driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("sandy11@gmail.com");
	  
	  //Click on "Create an account"
	  driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  //Select Title
	  driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
	  driver.findElement(By.name("customer_firstname")).sendKeys("Sundeep");
	  driver.findElement(By.name("customer_lastname")).sendKeys("Kumar");
	  driver.findElement(By.id("passwd")).sendKeys("Abc@123");
	  
	  // Enter your address
	  driver.findElement(By.id("company")).sendKeys("LamResearch");
	  driver.findElement(By.id("address1")).sendKeys("20A,2nd cross");
	  driver.findElement(By.id("city")).sendKeys("Bangalore");
	  
	  // Select State
	  WebElement statedropdown=driver.findElement(By.name("id_state"));
	  Select oSelect=new Select(statedropdown);
	  oSelect.selectByValue("6");

	  driver.findElement(By.name("postcode")).sendKeys("51838");
	  
	  // Select Country
	  WebElement countrydropDown=driver.findElement(By.name("id_country"));
	  Select oSelectC=new Select(countrydropDown);
	  oSelectC.selectByVisibleText("United States");
	  
	  //Enter Mobile Number
	  driver.findElement(By.id("phone_mobile")).sendKeys("9163337033");
	  driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
	  driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
	  driver.findElement(By.name("submitAccount")).click();
	  //String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();
	  String Actual_Title = driver.getTitle();
	  String Expected_Title = ("My account - My Store");
try {
	Assert.assertEquals(Expected_Title, Actual_Title);
	System.out.println("Assert - passed, User created");
}
	catch (AssertionError e){
     System.out.println("Assert - failed, User not created");
   throw e;
}
}
 @SuppressWarnings("deprecation")
public static void login(){ 
	 driver=new ChromeDriver();
	  URL="http://automationpractice.com/index.php";

	  driver.get(URL);
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.manage().window().maximize();
	  driver.findElement(By.linkText("Sign in")).click();
	  driver.findElement(By.name("email")).sendKeys("sandy11@gmail.com");
	  driver.findElement(By.id("passwd")).sendKeys("Abc@123");
	  driver.findElement(By.xpath("//button[@name=\"SubmitLogin\"]")).click();
	  String Actual_Title = driver.getTitle();
	  String Expected_Title = ("My account - My Store");
	  try {
			Assert.assertEquals(Expected_Title, Actual_Title);
			System.out.println("Assert - passed, User Logged In");
		}
			catch (AssertionError e){
		     System.out.println("Assert - failed, User not Logged In");
		   throw e;
		}
 }
 
}