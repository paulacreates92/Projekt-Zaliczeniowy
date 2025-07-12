package ProductOrderTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
    private WebDriver driver;

    public OrderConfirmationPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void takeScreenshot(String filePath) throws IOException {
        File dir = new File("screenshots");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(filePath));
    }
}
