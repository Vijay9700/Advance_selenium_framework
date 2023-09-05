package dummy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.basetest.BaseTest;

import junit.framework.Assert;
@Listeners(com.crm.generic.listenerutility.ListenerImplementation.class)
public class UseOfListener extends BaseTest{
	
	@Test
	public void onTestFail()
	{
		Assert.assertEquals(driver.getTitle(), "vijay");
	}

}
