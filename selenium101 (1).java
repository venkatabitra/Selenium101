import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class SeleniumJava101 {
	RemoteWebDriver driver;
    @BeforeTest
     public void setUp() {
     DesiredCapabilities capabilities = new DesiredCapabilities();
     capabilities.setCapability("browserName", "Chrome");
     capabilities.setCapability("browserVersion", "113.0");
     try {
    	 driver = new RemoteWebDriver(new URL("http:// venkata_bitra: kW6IT800aAmwpqKTLrPr8aQuOJjmtixrA77KqXKfmJ8qIKj5vo@hub.lambdatest.com/wd/hub"),
    	    	 capabilities);
        } catch (MalformedURLException e) {
     // TODO Auto-generated catch block
    e.printStackTrace();
    }
     }
    @Test
    public void Main() throws InterruptedException {   
    	//Test Scenario01
    	// Set the path to the ChromeDriver executable
    	// Open LambdaTest Selenium Playground
    	driver.get("https://www.lambdatest.com/selenium-playground");
 
    	// Click "Simple Form Demo" under Input Forms
    	WebElement simpleFormDemoLink = driver.findElement(By.linkText("Simple Form Demo"));
    	simpleFormDemoLink.click();
 
    	// Validate that the URL contains "simple-form-demo"
    	String currentURL = driver.getCurrentUrl();
    	if (currentURL.contains("simple-form-demo")) {
    	System.out.println("URL validation passed!");
    	} else {
    	System.out.println("URL validation failed!");
    	}
 
    	// Create a variable for a string value
    	String message = "Welcome to LambdaTest";
 
    	// Enter values in the "Enter Message" text box
    	WebElement enterMessageTextbox = driver.findElement(By.xpath("//input[@id='user-message']"));
    	enterMessageTextbox.sendKeys(message);
 
    	// Click "Get Checked Value"
    	WebElement getCheckedValueButton = driver.findElement(By.xpath("//button[text()='Get Checked Value']"));
    	getCheckedValueButton.click();
 
    	// Validate whether the same text message is displayed in the right-hand panel
    	WebElement yourMessageElement = driver.findElement(By.id("message"));
    	String displayedMessage = yourMessageElement.getText();
 
    	if (displayedMessage.equals(message)) {
    	System.out.println("Message validation passed!");
    	} else {
    	System.out.println("Message validation failed!");
    	}
 
    	//Test Scenario02
    	// Click "Drag & Drop Sliders" under "Progress Bars & Sliders"
    	driver.get("https://www.lambdatest.com/selenium-playground");
    	WebElement dragDropSlidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
    	dragDropSlidersLink.click();
 
    	// Select the slider "Default value 15"
    	WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
 
    	// Get the initial value
    	String initialValue = slider.getAttribute("value");
    	System.out.println("Initial value: " + initialValue);
 
    	// Drag the slider to make it 95
    	Actions actions = new Actions(driver);
    	actions.clickAndHold(slider)
    	.moveByOffset(215, 0) // Adjust the offset based on the slider range
    	.release()
    	.perform();
 
    	// Validate whether the range value shows 95
    	String finalValue = slider.getAttribute("value");
    	System.out.println("Final value: " + finalValue);
 
    	if (finalValue.equals("95")) {
    	System.out.println("Slider validation passed!");
    	} else {
    	System.out.println("Slider validation failed!");
    	}
 
    	//TestScenario03
 
    	// Click "Input Form Submit" under "Input Forms"
    	driver.get("https://www.lambdatest.com/selenium-playground");
    	WebElement inputFormSubmitLink = driver.findElement(By.linkText("Input Form Submit"));
    	inputFormSubmitLink.click();
 
    	// Click "Submit" without filling in any information in the form
    	WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
    	submitButton.click();
 
    	// Assert "Please fill in the fields" error message
    	String errorMessage = driver.findElement(By.xpath("//input[@id='name']")).getAttribute("validationMessage");
    	if (errorMessage.equals("Please fill out this field.")) {
    	System.out.println("Error message validation passed!");
    	} else {
    	System.out.println("Error message validation failed!");
    	}
 
    	// Fill in Name, Email, and other fields
    	WebElement nameField = driver.findElement(By.id("name"));
    	nameField.sendKeys("John Doe");
 
    	WebElement emailField = driver.findElement(By.xpath("//div//label[normalize-space()='Email*']/following-sibling::input"));
    	emailField.sendKeys("johndoe@example.com");
 
    	WebElement passwordField = driver.findElement(By.xpath("//div//label[normalize-space()='Password*']/following-sibling::input"));
    	passwordField.sendKeys("Abc@123");
 
    	WebElement companyField = driver.findElement(By.xpath("//div//label[normalize-space()='Company*']/following-sibling::input"));
    	companyField.sendKeys("Persistent");
 
    	WebElement websiteField = driver.findElement(By.xpath("//div//label[normalize-space()='Website*']/following-sibling::input"));
    	websiteField.sendKeys("Persistent");
 
    	// From the Country drop-down, select "United States" using the text property
    	Select countryDropdown = new Select(driver.findElement(By.xpath("//div//label[normalize-space()='Country*']/following-sibling::select")));
    	countryDropdown.selectByVisibleText("United States");
 
    	WebElement cityField = driver.findElement(By.xpath("//div//label[normalize-space()='City*']/following-sibling::input"));
    	cityField.sendKeys("Pune");
 
    	// Fill all fields and click "Submit"
 
    	WebElement addressField = driver.findElement(By.id("inputAddress1"));
    	addressField.sendKeys("123 Street");
    	WebElement addressField1 = driver.findElement(By.id("inputAddress2"));
    	addressField1.sendKeys("1234 Street");
 
    	WebElement stateField = driver.findElement(By.xpath("//div//label[normalize-space()='State*']/following-sibling::input"));
    	stateField.sendKeys("Maharastra");
 
    	WebElement zipField = driver.findElement(By.xpath("//div//label[normalize-space()='Zip Code*']/following-sibling::input"));
    	zipField.sendKeys("422107");
 
    	submitButton.click();
 
    	// Once submitted, validate the success message
    	WebElement successMessage = driver.findElement(By.xpath("//p[@class='success-msg hidden']"));
    	String expectedSuccessMessage = "Thanks for contacting us, we will get back to you shortly.";
    	String actualSuccessMessage = successMessage.getText();
 
    	if (actualSuccessMessage.equals(expectedSuccessMessage)) {
    	System.out.println("Success message validation passed!");
    	} else {
    	System.out.println("Success message validation failed!");
    	}
    }
    	@AfterTest
    	 public void tearDown() throws Exception {
        driver.quit();
    	}
}