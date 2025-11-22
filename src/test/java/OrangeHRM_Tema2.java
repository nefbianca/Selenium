import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class OrangeHRM_Tema2 {

    public static void OrangeHRM {

        // 1. Initializarea si navigare
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));


        // Click pe tile-ul Elements
        WebElement elementsTile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']")));
        elementsTile.click();

        // Click pe meniul "Text Box"
        WebElement textBoxMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Text Box']")));
        textBoxMenu.click();

        // Completarea formularului Text Box
        driver.findElement(By.id("userName")).sendKeys("Bianca Nef");
        driver.findElement(By.id("userEmail")).sendKeys("bianca.nef@test.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Strada Testului, Nr. 1");
        driver.findElement(By.id("permanentAddress")).sendKeys("Bulevardul Selenium, Bl. 10");

        // Click pe Submit
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Verificare: Se afișează datele introduse
        WebElement outputName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
        Assert.assertTrue(outputName.getText().contains("Bianca Nef"));


        // Click pe meniul "Check Box"
        WebElement checkBoxMenu = driver.findElement(By.xpath("//span[text()='Check Box']"));
        checkBoxMenu.click();

        // Click pe butonul >
        WebElement expandButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rct-icon-expand-all")));
        expandButton.click();

        // Click pe casetele Desktop si Downloads
        WebElement desktopLabel = driver.findElement(By.xpath("//label[contains(., 'Desktop')]"));
        desktopLabel.click();

        WebElement downloadsLabel = driver.findElement(By.xpath("//label[contains(., 'Downloads')]"));
        downloadsLabel.click();


        // Click pe meniul Radio Button
        WebElement radioButtonMenu = driver.findElement(By.xpath("//span[text()='Radio Button']"));
        radioButtonMenu.click();

        // Selectare Impressive
        WebElement impressiveRadio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Impressive']")));
        impressiveRadio.click();

        driver.close();
    }
}