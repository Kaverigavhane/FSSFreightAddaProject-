package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;

public class SuperAdminSignInpagePageObjects extends TestActions {
	WebDriver driver;
	Logger log = Logger.getLogger(SuperAdminSignInpagePageObjects.class);

	public SuperAdminSignInpagePageObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//input[@placeholder='Username']")
    public WebElement SuperadminUserId; 
    @FindBy(xpath="//input[@id='password']")
    public WebElement SuperAdminuserPassword;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement SuperAdminuserLoginButton;
    
    @FindBy(xpath="//img[@alt='no image']")
    public WebElement SuperAdmin_profile;
    
    @FindBy(xpath="//div[ text()='superadmin']")
    public WebElement User_name;
    
    @FindBy(id="remember")
    WebElement RememberMeCheackbox;
    
    
    
    
    public void enterSuperAdminUserId(String SuperAdminuserId) {
        this.sendkeys(SuperadminUserId,SuperAdminuserId);   
    }
    /*
     * verify superadmin enter user password.
     * @Parameters:adminpassword
     * @return:No
     */
    public void enterSuperAdminuserPassword(String SuperAdminuserpassword) {
        this.sendkeys(SuperAdminuserPassword,SuperAdminuserpassword);
    }
    
    /*
     * verify superadmin click on login button.
     * @Parameters:No
     * @return: No
     */
    public void clickOnSuperAdminLoginButton() {
        this.click(SuperAdminuserLoginButton);
    }
    public String isSuperAdminProfileNameDisplayed() {
        String ActualdProfileText = null;
        log.info("Click on superadmin profile");
        try {
            this.click(SuperAdmin_profile);
            
        } catch (Exception e) {
            log.info("Failure to click on  admin profile");   
        }
        return ActualdProfileText;
    }
    
public String isUserNameDisplayed() {
        
        String username=null;
        log.info("Click on Superadmin profile");
        try {
            username= User_name.getText();
        } catch (Exception e) {
            log.info("Failure to click on  Superadmin profile");  
        }
        return username;
                
    }
public boolean isUsernameTextboxDisplayed( ) {
     return SuperadminUserId.isDisplayed();
}
public boolean isPasswordTextboxDisplayed( ) {
   return SuperAdminuserPassword.isDisplayed();
}
public String isLOGINButtonTextDisplayed( ) {
    String LOGINButtonText=SuperAdminuserLoginButton.getText();
   return LOGINButtonText;
}
public boolean isLOGINButtonEnabled( ) {
   return SuperAdminuserLoginButton.isEnabled();
}
public boolean isRememberMeCheackboxSelected( ) {
    RememberMeCheackbox.click();
   return RememberMeCheackbox.isSelected();
}
public boolean isAdminProfileIconDisplayed( ) {
    return User_name.isDisplayed();
}
    
    
}
