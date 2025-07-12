package ProductOrderTest;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;

    String size = "M";
    int quantity = 5;

    @FindBy(id = "category-3")
    private WebElement clothesDropdownMenu;

    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/div[2]/article/div/div[2]/h2/a")
    private WebElement productToOrder;

    @FindBy(className = "discount")
    private WebElement discountLabel;

    @FindBy(id = "group_1")
    private WebElement sizeDropdown;

    @FindBy(className = "bootstrap-touchspin-up")
    private WebElement quantitySelector;

    @FindBy(css = "button[data-button-action='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckoutButton;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        clothesDropdownMenu.click();

        productToOrder.click();
    }

    public String verifyDiscount() {

        String actualDiscount = discountLabel.getText();
        return actualDiscount;
    }

    public void selectSize(String size) {
        this.size = size;
        Select dropdown = new Select(sizeDropdown);
        dropdown.selectByVisibleText(size);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        int defaultValue = 1;
        int clicksNeeded = quantity - defaultValue;
        for (int i=0; i<clicksNeeded; i++){
            try {
                Thread.sleep(200);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            quantitySelector.click();

        }


    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));


        try {
            addToCartButton.click();
        } catch (StaleElementReferenceException e) {
            addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            addToCartButton.click();
        }
        proceedToCheckoutButton.click();
    }
}
