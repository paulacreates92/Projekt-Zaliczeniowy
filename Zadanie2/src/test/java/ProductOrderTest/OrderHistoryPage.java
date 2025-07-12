package ProductOrderTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {
    WebDriver driver;

    @FindBy(id = "_desktop_logo")
    private WebElement logo;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]")
    private WebElement userInfoPageButton;

    @FindBy(xpath = "//*[@id=\"history-link\"]")
    private WebElement orderAndHistoryInformationLink;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[4]/span")
    private WebElement invoiceStatusInfo;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr[1]/td[2]")
    private WebElement invoiceTotalPrice;


    public OrderHistoryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void getToOrderHistoryPage(){
        logo.click();
        userInfoPageButton.click();
        orderAndHistoryInformationLink.click();
    }
    public String confirmInvoiceStatus(){
        String invoiceStatus= invoiceStatusInfo.getText();
        return invoiceStatus;
    }
    public String confirmTotalPrice(){
        String totalPrice= invoiceTotalPrice.getText();
        return totalPrice;
    }
}
