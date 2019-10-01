package DirectLine.StepDefinitions;

import org.testng.Assert;

import DirectLine.qa.Pages.HomePage;
import DirectLine.qa.Util.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageSteps extends TestBase {

	HomePage homepageObject;

	@Given("^I am on the Dealer portal page$")
	public void i_am_on_the_Dealer_portal_page() throws Throwable {
		TestBase.initialization();
	}

	// To verify the title of the page
	@When("^I check for the title of the page$")
	public void i_check_for_the_title_of_the_page() throws Throwable {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Dealer Portal");
	}

	@When("^I enter the vehicle registration number in the given text box$")
	public void i_enter_the_vehicle_registration_number_in_the_given_text_box() throws Throwable {
		homepageObject = new HomePage();
		homepageObject.regNumCheck();
	}

	@Then("^I should see the result displayed below the text box$")
	public void i_should_see_the_result_displayed_below_the_text_box() throws Throwable {
		homepageObject = new HomePage();
		homepageObject.resultCheck();
	}

	@When("^I keep registration number box empty$")
	public void i_keep_registration_number_box_empty() throws Throwable {
		homepageObject = new HomePage();
		homepageObject.emptyRegNum();
	}

	@When("^I click on Find vehicle button$")
	public void i_click_on_Find_vehicle_button() throws Throwable {
		homepageObject = new HomePage();
		homepageObject.click();
	}

	@Then("^I should see the validation message on the UI$")
	public void i_should_see_the_validation_message_on_the_UI() throws Throwable {
		homepageObject = new HomePage();
		homepageObject.blankErrorMsg();
	}

	@When("^I enter invalid reg number$")
	public void i_enter_invalid_reg_number() throws Throwable {
		homepageObject = new HomePage();
		homepageObject.enterInvalidRegNum();
	}

	@Then("^I should see the validation message$")
	public void i_should_see_the_validation_message() throws Throwable {
		homepageObject = new HomePage();
		homepageObject.invalidErrorMsg();
	}
}
