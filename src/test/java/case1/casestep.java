package case1;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Maps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class casestep {
	WebDriver driver;
	@Given("navigate to homepage")
	public void navigate_to_homepage() {
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\training_c2a.04.29\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("hhtp://google.com");
	driver.get("http://10.232.237.143:443/TestMeApp/");
		}
	
	@When("user enters username and password")
	public void user_enters_username_and_password(io.cucumber.datatable.DataTable datatable){
		List<Map<String ,String>> list=datatable.asMaps();
		for(int i=0;i<list.size();i++) {
			driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		
			//driver.findElement(By.linkText("SignIn")).click();
			String title2=driver.getTitle();
			Assert.assertEquals("Login",title2);
		    driver.findElement(By.id("userName")).sendKeys(list.get(i).get("username"));
		    driver.findElement(By.id("password")).sendKeys(list.get(i).get("password"));
		    driver.findElement(By.name("Login")).click();
		    if(i>=1)
		    {
		   // String txt=driver.findElement(By.id("errormsg")).getText();
		   // Assert.assertEquals("Username or Password is wrong here!!!",txt);
		    driver.findElement(By.linkText("Home")).click();
		    }
		    else {
		    String title=driver.getTitle();
		    Assert.assertEquals("Home",title);
		    //String a="Home";
		  //  String b="Login";
		//    if(title==a) {
		    driver.findElement(By.linkText("SignOut")).click();
		    }
		   
		  //           }
		  //  else if(title==b) {
		    //	driver.findElement(By.linkText("Home")).click();
		  //  }
		  // String tit=driver.getTitle();
		  // Assert.assertEquals("Sign Out",tit);
		  // String title3=driver.getTitle();
		 // Assert.assertEquals("Home",title3);
		    }
	}
	
	@Then("message Login Successfully")
	public void message_Login_Successfully() {
		String title=driver.getTitle();
		Assert.assertEquals("Home",title);
	}
	

	
}
