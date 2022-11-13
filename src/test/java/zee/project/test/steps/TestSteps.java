package zee.project.test.steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import zee.project.main.utilities.CommonUtility;
import zee.project.test.pages.POMFactories;

public class TestSteps extends CommonUtility{
	
	
	POMFactories factory = new POMFactories();
	
	
	
	
	
	
	
	
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String expectedTitle = "React App";
		String actualTitle = getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		logger.info(actualTitle+" is equal to "+ expectedTitle);
	}
	@Then("User clicks on sign in btn")
	public void userClicksOnSignInBtn() {
		click(factory.homPage().signBtn);
		logger.info("User clicked on signIn Button");
	}

	
	
	
	
	
	

}
