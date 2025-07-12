package ProductOrderTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class OrderProductTest {
    private static WebDriver driver;


    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");
    }

    @Test
    public void testOrderingProduct() throws IOException {
        HomePage homePage = new HomePage(driver);
        homePage.goTosignInPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInToAccount();
        Assertions.assertEquals("Paula Wojcik", loginPage.getAccountName(), "Account not found!");

        ProductPage productPage = new ProductPage(driver);
        productPage.selectProduct();
        productPage.verifyDiscount();
        productPage.selectSize(productPage.size);
        productPage.setQuantity(productPage.quantity);
        productPage.addToCart();

        Assertions.assertEquals("-20%", productPage.verifyDiscount(), "Discount mismatch");


        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();
        checkoutPage.addressConfirmation();
        checkoutPage.shippingMethodConfirmation();
        checkoutPage.paymentConfirmation();


        OrderConfirmationPage orderconfirm = new OrderConfirmationPage(driver);
        String filePath = "screenshots/order-confirmation"+System.currentTimeMillis()+".png";
        orderconfirm.takeScreenshot(filePath);

        File screenshotFile = new File((filePath));
        Assertions.assertTrue(screenshotFile.exists(), "Screenshot was not taken!");
        Assertions.assertTrue(screenshotFile.length() > 0, "Screenshot is empty!");

        //OrderHistoryPage orderHistoryPage= new OrderHistoryPage(driver);
        //orderHistoryPage.getToOrderHistoryPage();
        //orderHistoryPage.confirmInvoiceStatus();

        //Assertions.assertEquals("Awaiting check payment",orderHistoryPage.confirmInvoiceStatus(),"Invoice Status mismatch");
        // Assertions.assertEquals(checkoutPage.getTotalPrice(),orderHistoryPage.confirmTotalPrice()," Price is not the same");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
