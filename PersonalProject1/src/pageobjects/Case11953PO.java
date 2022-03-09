package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Case11953PO"                                
     , summary=""
     , relativeUrl=""
     , connection="Guidewire"
     )             
public class Case11953PO {

	@TextType()
	@FindBy(xpath = "//div[@id='sfdc_username_container']//input[@placeholder='Username']")
	public WebElement username;
	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Forgot your password?']")
	public WebElement forgotYourPassword;
			
}
