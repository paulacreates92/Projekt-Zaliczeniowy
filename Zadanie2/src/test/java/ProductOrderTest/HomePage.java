package ProductOrderTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;

    @FindBy(id="_desktop_user_info")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTosignInPage(){
        signInButton.click();
    }
}
