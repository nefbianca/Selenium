import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DeMoqa_Tema3 {
    public static void main(String[] args) {
    // Date de test
    String CHROME_DRIVER_PATH = "C:\\SeleniumDrivers\\chromedriver.exe";
    String BASE_URL = "https://demoqa.com/";
    String FULL_NAME = "Ion Popescu";
    String EMAIL = "ion.popescu@test.com";
    String C_ADDRESS = "Str. Poeziei, nr. 10";
    String P_ADDRESS = "Bd. Eminescu, bl. 5";

    WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");

        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get(BASE_URL);

            // Locator pentru cardul Elements
            By elementsCard = By.xpath("//h5[text()='Elements']");
            wait.until(ExpectedConditions.elementToBeClickable(elementsCard)).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']"))).click();

            // Click pe Elements -> Text Box -> Completare si Submit
            System.out.println("Pas 1: Completare Text Box (XPath)...");

            wait.until(ExpectedConditions.elementToBeClickable(elementsCard)).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Text Box']"))).click();

            // Completare formular Text Box
            driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(FULL_NAME);
            driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(EMAIL);
            driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys(C_ADDRESS);
            driver.findElement(By.xpath("//textarea[@id='permanentAddress']")).sendKeys(P_ADDRESS);

            // Click pe Submit
            driver.findElement(By.xpath("//button[@id='submit']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='output']")));
            System.out.println("Text Box trimis.");

            //Check Box menu -> Expand All
            System.out.println("Pas 2 & 3: Navigare Check Box și Selectare...");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Check Box']"))).click();

            // Click pe butonul ">" (Expand All)
            By expandBtn = By.xpath("//button[@title='Expand all']");
            wait.until(ExpectedConditions.elementToBeClickable(expandBtn)).click();

            // Check pe casutele Desktop si Downloads
            driver.findElement(By.xpath("//span[text()='Desktop']")).click();
            driver.findElement(By.xpath("//span[text()='Downloads']")).click();

            // Radio Button -> Select Impressive
            System.out.println("Pas 4: Selectare Radio Button Impressive...");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Radio Button']"))).click();

            // Select Impressive
            By impressiveLabel = By.xpath("//label[@for='impressiveRadio']");
            wait.until(ExpectedConditions.elementToBeClickable(impressiveLabel)).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You have selected ']/span[text()='Impressive']")));
            System.out.println("Test finalizat cu succes.");

        } catch (Exception e) {
            System.err.println("Testul a esuat din cauza unei erori: " + e.getMessage());
            e.printStackTrace();
        }

    }
}

