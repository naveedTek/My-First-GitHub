package zee.project.test.pages;

import zee.project.main.base.BaseSetup;

public class POMFactories extends BaseSetup{
	
	
	private HomePage homepage;
	
	
	public POMFactories () {
		this.homepage = new HomePage();
	}
	
	
	
	public HomePage homPage() {
		return homepage;
	}
	
	
	
	
	

}
