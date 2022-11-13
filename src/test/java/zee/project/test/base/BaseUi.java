package zee.project.test.base;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import zee.project.main.utilities.CommonUtility;

public class BaseUi extends CommonUtility{
	
	
	
	
	@Before
    public void setupTests() {
       super. setBrowser();

    }
	
	  @After
	    public void closeTests(Scenario scenario) {
	        if (scenario.isFailed()) {
	            byte[] screenShot = takeScreenShotAsBytes();
	            scenario.attach(screenShot, "iamge/png", scenario.getName() + " scenario Failed");
	        }

	        
	       super. quitBrowser();

	    }
	

}
