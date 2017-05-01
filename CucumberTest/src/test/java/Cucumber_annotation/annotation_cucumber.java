package Cucumber_annotation; 

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When; 

public class annotation_cucumber { 
	WebDriver driver;
	
   @Given("^I am on Amazon page$") 
	
   public void goToAmazon() { 
      driver = new FirefoxDriver(); 
      driver.navigate().to("https://www.amazon.com/"); 
   }
	
   @When("^I search with text 'Nikon'$") 
   public void searchText(String arg1) {   
	   driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nikon"); 
	   driver.findElement(By.xpath("//input[@type='submit']")).click();
   }
	
   @When("^sorted it as Price:High to Low$") 
   public void sortingSearch(String arg1) {
	   Select SortBy = new Select(driver.findElement(By.id("sort")));
	   SortBy.selectByVisibleText("Price: High to Low"); 
   } 
	
   @Then("^Nikon search results with expected order should appear$") 
   public void checkpage() {  
	        WebElement textSorted= driver.findElement(By.xpath("//div[@id='centerPlus']/h3"));
       
	        String actualTextSorted = textSorted.getText();        
	        
	        System.out.println(actualTextSorted);

        }
	
   @When("^I click on the second item in the list$") 
   public void checkDetails() { 
	   driver.manage().window().maximize();
	   System.out.println("window Maximized");
	   WebElement elem = driver.findElement(By.xpath("//li[@id ='result_1']//h2")); 
	   elem.click();
	   }
   
   @When("^verified the details for text 'Nikon D3X'$") 
   public void verifyText() { 
	   WebElement showMore = driver.findElement(By.xpath("//div[@id='feature-bullets']//span[@class='a-expander-prompt']"));
	   showMore.click(); 
	   String foo = driver.findElement(By.xpath("//div[@id='feature-bullets']")).getText();
	   String expectedSearchedText = "Nokia D3X";
	   assertTrue("Verification failed: actual text doesnt contain Nokia D3X." , foo.contains(expectedSearchedText));
	   driver.close();
	   }
   
   
} 
