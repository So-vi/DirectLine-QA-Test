package DirectLine.qa.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import DirectLine.qa.Util.TestBase;
import DirectLine.qa.Util.TestUtil;

public class HomePage extends TestBase {

	// Page Factory Elements
	@FindBy(xpath = "//*[@id='vehicleReg']")
	WebElement regTextBox;

	@FindBy(xpath = "//*[@id='search']")
	WebElement findVehicleButton;

	@FindBy(xpath = "//*[@class='resultDate-bold']")
	List<WebElement> listResult;

	@FindBy(xpath = "//*[@class='error-required']")
	WebElement blankErrorMsg;

	@FindBy(xpath = "//*[@class='result']")
	WebElement invalidErrorMsg;

	// Initializing Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// To verify reg number
	public void regNumCheck() throws InterruptedException {
		regTextBox.sendKeys(TestUtil.vehicle_RegNum);
		findVehicleButton.click();
	}

	// To verify the result
	public void resultCheck() {
		String coverStartDate = listResult.get(0).getText();
		String coverEndDate = listResult.get(1).getText();
		Assert.assertEquals(coverStartDate, TestUtil.cover_StartDate);
		Assert.assertEquals(coverEndDate, TestUtil.cover_EndDate);
		driver.close();
	}

	// To verify blank reg number value
	public void emptyRegNum() {
		regTextBox.clear();
		regTextBox.sendKeys("");
	}

	// To click on Find Vehicle Button
	public void click() {
		findVehicleButton.click();
	}

	// To verify blank reg number validation message
	public void blankErrorMsg() {
		blankErrorMsg.click();
		Assert.assertEquals(blankErrorMsg.getText(), "Please enter a valid car registration");
		driver.close();
	}

	// To enter invalid reg number
	public void enterInvalidRegNum() {
		regTextBox.clear();
		regTextBox.sendKeys("Vfg63745");
	}

	// To verify invalid reg number
	public void invalidErrorMsg() {
		invalidErrorMsg.click();
		Assert.assertEquals(invalidErrorMsg.getText(), "Sorry record not found");
		driver.quit();
	}
}
