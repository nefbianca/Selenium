import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OrangeHRM_Tema2 {

    public static void main(String[] args) throws InterruptedException {
        // Date de Test
        String user = "Admin";
        String pass = "admin123";
        String numeAngajat = "Odis Adalwin"; // Nume existent pe demo
        String stradaNoua = "Bulevardul Test 123";
        String mobilNou = "0700112233";

        // 1. Configurarea si pornirea browserului
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        try {
            // 1. Logare pe site
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys(user);
            driver.findElement(By.name("password")).sendKeys(pass);
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // 2. click PIM
            By pimLink = By.xpath("//a[contains(@href, '/pim')]");
            wait.until(ExpectedConditions.elementToBeClickable(pimLink)).click();

            // 3. cauta un nou user dupa nume
            By numeField = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
            wait.until(ExpectedConditions.elementToBeClickable(numeField)).sendKeys(numeAngajat);
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Așteaptă rezultatele
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-body']")));

            //4. acceseaza pagina userului cautat (click pe iconița de Edit) ---
            By editBtn = By.xpath("(//div[@class='oxd-table-row'])[1]//button[contains(@class, 'edit')]");
            wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();

            // 5. merge in contact details ---
            By contactLink = By.xpath("//a[text()='Contact Details']");
            wait.until(ExpectedConditions.elementToBeClickable(contactLink)).click();

            // 6. adauga Datele de contact sau le updateaza ---
            By stradaField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]");
            By mobilField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[7]");

            // Curăță câmpurile și introduce datele noi
            wait.until(ExpectedConditions.visibilityOfElementLocated(stradaField)).clear();
            driver.findElement(stradaField).sendKeys(stradaNoua);

            driver.findElement(mobilField).clear();
            driver.findElement(mobilField).sendKeys(mobilNou);

            // 7. Save
            By saveBtn = By.xpath("(//button[@type='submit'])[1]");
            driver.findElement(saveBtn).click();

            // Verificare succes
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'oxd-toast--success')]")));
            System.out.println("Succes! Datele de contact au fost actualizate.");

        } catch (Exception e) {
            System.err.println("Testul a eșuat: " + e.getMessage());
        } finally {
            // Curățenie
            Thread.sleep(3000); // Pauză pentru a vedea rezultatul
            driver.quit();
        }
    }
}

