package Assignment9;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assignment9 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/signup");
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement signup=driver.findElement(By.xpath("//button[@type='submit']"));
		//scrolling to the signup button
		js.executeScript("arguments[0].scrollIntoView();", signup);
		if(signup.isEnabled()) //checking sugnup button is enabled or disabled using if condition
		{
			System.out.println("enabled ");
		}
		else 
		{
			System.out.println("disabled ");
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("sahil");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("in@nrn.ai");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("ineuron");
			driver.findElement(By.xpath("//*[text()='Testing']")).click();
			driver.findElement(By.xpath("//input[@value='Male']")).click();
			 Select State=new Select(driver.findElement(By.xpath("//select[@id='state']")));
			 State.selectByValue("Uttar Pradesh");
			
			
		}
		if(signup.isEnabled()) // if the signup button got enabled proceed to submit 
		{
			System.out.println("Sign up button is enabled click on signup button to complete ");
			js.executeScript("arguments[0].scrollIntoView();", signup);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
		}
		//login to verify user created or not 
		driver.findElement(By.xpath("//input[@id='email1']")).sendKeys("in@nrn.ai");
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("ineuron");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		 String expectedurl= driver.getCurrentUrl(); // get current url 
		 System.out.println("current url will be -->"+expectedurl);
		
		String actualurl="https://ineuron-courses.vercel.app/"; // actual url refers after login this will be url 

		

	   
	   if(actualurl.equals(expectedurl)) // verify if extected and actual url is same or not 
	   {
		   System.out.println("User successfully logged in ");
	   }
	   else
	   {
		   System.out.println("User not logged in ");
	   }
	   
	   driver.quit();

	}

}
