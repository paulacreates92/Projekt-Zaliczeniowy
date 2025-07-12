package CreateNewAddress;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateNewAddressSteps {
    private WebDriver driver;


    @Given("I'm opening browser with mystore-testlab.coderslab.pl")
    public void openTheBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-autofill");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/");

    }

    @When("I login on already created account using {string} and {string}")
    public void iLoginOnAlreadyCreatedAccount(String email, String password) {
        driver.findElement(By.id("_desktop_user_info")).click();
        driver.findElement(By.id("field-email")).sendKeys(email);
        driver.findElement(By.id("field-password")).sendKeys(password);
        driver.findElement(By.id("submit-login")).click();
    }


    @Then("I create new address using {string},{string},{string},{string},{string},{string}")
    public void iCreateNewAddressUsingAliasAddressCityPostal_codePhone(String alias, String address, String city, String postal_code,String country, String phone) {

        driver.findElement(By.id("addresses-link")).click();
        driver.findElement(By.cssSelector("#content > div.addresses-footer > a")).click();
        WebElement aliasInput = driver.findElement(By.id("field-alias"));
        aliasInput.sendKeys(alias);
        WebElement addressInput = driver.findElement(By.id("field-address1"));
        addressInput.sendKeys(address);
        driver.findElement(By.id("field-city")).sendKeys(city);
        driver.findElement(By.id("field-postcode")).sendKeys(postal_code);
        WebElement dropdownmenu= driver.findElement(By.id("field-id_country"));
        Select dropdown= new Select(dropdownmenu);
        dropdown.selectByVisibleText(country);
        driver.findElement(By.id("field-phone")).sendKeys(phone);
        driver.findElement(By.className("form-control-submit")).click();

    }

    @Then("I check if the new address is correct with {string},{string},{string},{string},{string},{string}")
    public void iCheckIfTheNewAddressIsCorrect(String alias, String address, String city, String postal_code,String country, String phone) {
        driver.findElement(By.xpath("(//a[@data-link-action='edit-address'])[2]")).click();

        String aliasSaved = driver.findElement(By.id("field-alias")).getAttribute("value");
        String addressSaved = driver.findElement(By.id("field-address1")).getAttribute("value");
        String citySaved = driver.findElement(By.id("field-city")).getAttribute("value");
        String postalCodeSaved = driver.findElement(By.id("field-postcode")).getAttribute("value");
        String countrySaved= driver.findElement(By.id("field-id_country")).getText();
        String phoneSaved = driver.findElement(By.id("field-phone")).getAttribute("value");


        Assertions.assertEquals(alias, aliasSaved, "Alias mismatch");
        Assertions.assertEquals(address, addressSaved, "Address mismatch");
        Assertions.assertEquals(city, citySaved, "City mismatch");
        Assertions.assertEquals(postal_code, postalCodeSaved, "Postal code mismatch");
        Assertions.assertEquals(phone, phoneSaved, "Phone mismatch");

        driver.findElement(By.cssSelector("#content > div > div > form > footer > button")).click();


    }


    @Then("I delete the new address and check if the address was deleted")
    public void iDeleteTheNewAddress() {
        List<WebElement> addressesCountBefore = driver.findElements(By.cssSelector("article.address"));
        int beforeCount = addressesCountBefore.size();

        driver.findElement(By.xpath("(//article[contains(@class,'address')]//a[@data-link-action='delete-address'])[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.findElements(By.cssSelector("article.address")).size() < beforeCount);

        List<WebElement> addressesCountAfter = driver.findElements(By.cssSelector("article.address"));
        int afterCount = addressesCountAfter.size();

        Assertions.assertEquals(beforeCount - 1, afterCount, "Address was not deleted.");

    }


    @And("I close the browser")
    public void iCloseTheBrowser() {

        driver.close();
    }
}
