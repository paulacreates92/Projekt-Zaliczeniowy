package ProductOrderTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckoutSubmitButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span/strong")
    private WebElement totalPriceAmmount;

    @FindBy(name = "id_address_delivery")
    private WebElement addressCheckbox;

    @FindBy(name = "confirm-addresses")
    private WebElement continueToShippingButton;

    @FindBy(id = "delivery_option_8")
    private WebElement selfPickUpCheckbox;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryButton;

    @FindBy(id = "payment-option-1")
    private WebElement payByCheckCheckbox;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termConditionsCheckbox;

    @FindBy(css = "#payment-confirmation > div.ps-shown-by-js > button")
    private WebElement placeOrderButton;


    public CheckoutPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void proceedToCheckout(){
        proceedToCheckoutSubmitButton.click();
    }


    public String getTotalPrice(){
        String totalPrice= totalPriceAmmount.getText();
        return totalPrice;
    }



    public void addressConfirmation() {
        if (addressCheckbox.isSelected()) {
            continueToShippingButton.click();
        } else {
            System.out.println("There is no saved address");
        }

    }

    public void shippingMethodConfirmation(){
        if(selfPickUpCheckbox.isSelected()){
            confirmDeliveryButton.click();
        }else{
            System.out.println("You didn't select self pick up method!");
        }
    }

    public void paymentConfirmation(){
        if(payByCheckCheckbox.isSelected()){

        }else {
            payByCheckCheckbox.click();
        }
        if(termConditionsCheckbox.isSelected()){

        }else {
            termConditionsCheckbox.click();
        }
        placeOrderButton.click();
    }

}


