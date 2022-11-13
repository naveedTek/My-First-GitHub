package zee.project.main.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import java.time.temporal.ChronoUnit;
import zee.project.main.config.Browser;
import zee.project.main.config.ChromeBrowser;
import zee.project.main.config.ChromeHeadless;
import zee.project.main.config.EdgeBrowser;
import zee.project.main.config.FirefoxBrowser;
import zee.project.main.utilities.ReadYamlFiles;

public class BaseSetup {
	
	private static WebDriver webDriver;
	private final ReadYamlFiles enviromnentVariables;
	public static Logger logger;
	
	
	
	public  BaseSetup() {
		
		String ymlFilePath = System.getProperty("user.dir")+"/src/main/resources/environment_config.yml";
		String log4jFilePath= System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
		
		try {
			enviromnentVariables = ReadYamlFiles.getYamlInstance(ymlFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("incorrect Filepath please check filepath");
			throw new RuntimeException("errors in filePath"+e.getMessage());
		}
		
		logger = Logger.getLogger("logger_files");
		PropertyConfigurator.configure(log4jFilePath);
		
	}
	
	
	public WebDriver getDriver() {
		return webDriver;
	}
	
	public void setBrowser() {
		HashMap uiproperties = enviromnentVariables.getYamlProperty("ui");
		String url = uiproperties.get("url").toString();
		Browser browser;
		switch(uiproperties.get("browser").toString().toLowerCase().trim()) {
		
		case "chrome":
			if((boolean) uiproperties.get("headless")) {
				browser = new ChromeHeadless();
			}else {
				browser = new ChromeBrowser();		
			} webDriver = browser.openBrowser(url);
			break;
		case "firefox":
			browser = new FirefoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
			default:
				throw new RuntimeException("invaild Browser Please pass the right Browser!");
		}
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
	}
	
	
	
	public void quitBrowser() {
		if(webDriver != null ) {
			webDriver.quit();
		}
	}
	
	
	
	

}
