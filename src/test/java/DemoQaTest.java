import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pages.PracticeFormPage;

public class DemoQaTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // Colocar el Zoom 70%
        options.addArguments("--force-device-scale-factor=0.7");
        driver = new ChromeDriver(options);
    }

    @Test
    void llenarFormulario (){
        String img = "C:\\Users\\diego\\OneDrive\\Imágenes\\Vander.jpg";
        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.open();
        practiceFormPage.fillForm(img);
    }

    @AfterEach
    void close(){
        driver.quit();
    }
}
