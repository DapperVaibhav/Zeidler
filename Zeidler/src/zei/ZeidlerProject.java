package zei;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class ZeidlerProject {
	WebDriver driver;
	
  @Test(priority=0)  //Create
  public void AddComputer() throws InterruptedException {
	  driver.findElement(By.xpath("//a[@id='add']")).click();
	  driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Vaibhav");
	  driver.findElement(By.xpath("//input[@id='introduced']")).sendKeys("1994-12-16");
	  driver.findElement(By.xpath("//input[@id='discontinued']")).sendKeys("1994-12-31");
	  
	  Select company= new Select(driver.findElement(By.xpath("//select[@id='company']")));
      company.selectByVisibleText("Nokia");
      
      driver.findElement(By.xpath("//input[@class='btn primary']")).click();
      Thread.sleep(2000);
  }
      @Test(priority=1)  //Read
      public void FilterCompanyName() throws InterruptedException {
      driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("Vaibhav");
      driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
      Thread.sleep(2000);
      }
      
      @Test(priority=2)  //Update
      public void UpdateCompanyName() throws InterruptedException {
    	  driver.findElement(By.linkText("Vaibhav")).click();
          Thread.sleep(2000);
    	  
          WebElement Cname= driver.findElement(By.xpath("//input[@id='name']"));
    	  Cname.clear(); 
    	  Cname.sendKeys("Vaibhav_New");
    	  
    	  WebElement DateI=driver.findElement(By.xpath("//input[@id='introduced']"));
    	  DateI.clear();
    	  DateI.sendKeys("1994-12-15");
    	  
    	  WebElement DateD=driver.findElement(By.xpath("//input[@id='discontinued']"));
    	  DateD.clear();
    	  DateD.sendKeys("1994-12-30");
    	  
    	  Select company= new Select(driver.findElement(By.xpath("//select[@id='company']")));
          company.selectByVisibleText("Sony");
       
          driver.findElement(By.xpath("//input[@class='btn primary']")).click();
          Thread.sleep(2000);
          
      }
      
      @Test(priority=3)  //Delete
      public void Delete() throws InterruptedException {
      driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("Vaibhav_New");
      driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
      Thread.sleep(2000);	  
      driver.findElement(By.linkText("Vaibhav_New")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@class='btn danger']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("Vaibhav_New");
      driver.findElement(By.xpath("//input[@id='searchsubmit']")).click();
      Thread.sleep(2500);
      if(driver.findElement(By.xpath("//div[@class='well']")).isDisplayed()) {
    	  System.out.println("Successfully Deleted not in list");
      }
      else {
    	  System.out.println("Not Deleted Successfully");
      }
      
  }
  
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\vaibhav\\Desktop\\Vaihav imp data\\ChromeDriver\\ChromeDriver_31052020\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.get("http://computer-database.herokuapp.com/computers?f=");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
  }

  @AfterTest
  
  public void afterTest() {
	  driver.close();
  }

}
