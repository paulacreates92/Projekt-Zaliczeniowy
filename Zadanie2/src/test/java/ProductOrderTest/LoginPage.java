package ProductOrderTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private static WebDriver driver;

    String login= "pauwoj@test.pl";
    String password= "123456789";

    @FindBy(id="field-email")
    private WebElement emailInput;

    @FindBy(id="field-password")
    private WebElement passwordInput;

    @FindBy(id="submit-login")
    private WebElement signInSubmitButton;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement getAccountName;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void signInToAccount(){
        if (emailInput.isDisplayed()){
            emailInput.clear();
            emailInput.sendKeys(login);
        }else {
            emailInput.sendKeys(login);
        }

        if(passwordInput.isDisplayed()){
            passwordInput.clear();
            passwordInput.sendKeys(password);
        }else {
            passwordInput.sendKeys(password);
        }
        signInSubmitButton.click();
    }
    public String getAccountName(){
        String getAccountInfo= getAccountName.getText();
        return getAccountInfo;
    }
}
