import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class Ejercicio1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup(); //se encarga de descargar y configurar automáticamente el driver de Chrome (evita tener que hacerlo manualmente).

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options); //driver: el objeto que controla el navegador.
        //Configuracion de espera explicitas
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));//el objeto que maneja las esperas explícitas.
    }

    @Test
    public void demoQA()  throws InterruptedException {
        driver.get("https://demoqa.com/");
        By loader = By.cssSelector("div.loader");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

        //Se define una espera implicita nota: en lo posible no usarla
        Thread.sleep(5000);

        By btnForm = By.xpath("//a[@href='/forms']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnForm)).click();

        Thread.sleep(3000);

        By btnPracticeForm = By.xpath("(//a[@href='/automation-practice-form'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(btnPracticeForm)).click();

        By textFirstName = By.id("firstName");
        WebElement txtFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(textFirstName));
        txtFirstName.sendKeys("Vander");

        By textLastName = By.id("lastName");
        WebElement txtLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(textLastName));
        txtLastName.sendKeys("Monkey D.");

        By textEmail = By.id("userEmail");
        WebElement txtEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(textEmail));
        txtEmail.sendKeys("MonkeyDVanderGrap@test.com");

        By btnGender = By.id("gender-radio-1");
        wait.until(ExpectedConditions.elementToBeClickable(btnGender)).click();

        By textPhone = By.id("userNumber");
        WebElement txtPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(textPhone));
        txtPhone.sendKeys("3001234567");

        Thread.sleep(3000);

        By DateBirth = By.id("dateOfBirthInput");
        WebElement txtDateBirth = wait.until(ExpectedConditions.visibilityOfElementLocated(DateBirth));
        txtDateBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));  // Ctrl+A + Delete
        txtDateBirth.sendKeys("15 oct 2025");
        txtDateBirth.sendKeys(Keys.TAB);

        Thread.sleep(3000);

        By textSubject = By.id("subjectsInput");
        WebElement txtSubject = wait.until(ExpectedConditions.visibilityOfElementLocated(textSubject));
        txtSubject.sendKeys("Computer Science");
        txtSubject.sendKeys(Keys.TAB);

        Thread.sleep(3000);

        By btnHobbies = By.id("hobbies-checkbox-1");
        wait.until(ExpectedConditions.elementToBeClickable(btnHobbies)).click();

        By btnHobbies1 = By.id("hobbies-checkbox-3");
        wait.until(ExpectedConditions.elementToBeClickable(btnHobbies1)).click();

        // Localizar el campo de entrada de archivos
        WebElement btnUpload = driver.findElement(By.id("uploadPicture"));
        btnUpload.sendKeys("C:\\Users\\diego\\OneDrive\\Imágenes\\Vander.jpg");

        By textCurrAddress = By.id("currentAddress");
        WebElement txtCurrAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(textCurrAddress));
        txtCurrAddress.sendKeys("Calle falsa 123");

        By textSelectState = By.id("react-select-3-input");
        WebElement txtSelectState = wait.until(ExpectedConditions.visibilityOfElementLocated(textSelectState));
        txtSelectState.sendKeys("NCR");
        txtSelectState.sendKeys(Keys.TAB);

        By textSelectCity = By.id("react-select-4-input");
        WebElement txtSelectCity = wait.until(ExpectedConditions.visibilityOfElementLocated(textSelectCity));
        txtSelectCity.sendKeys("Gurgaon");
        txtSelectCity.sendKeys(Keys.TAB);

        By btnSubmit = By.id("submit");
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit)).click();


    }
}
