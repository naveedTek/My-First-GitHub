package zee.project.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import zee.project.main.base.BaseSetup;

public class HomePage extends BaseSetup{
	
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	
	@FindBy(id="signinLink")
	public WebElement signBtn;
	
	
	
	

}
