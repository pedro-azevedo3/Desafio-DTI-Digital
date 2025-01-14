package automationpractice.test;

import automationpractice.factory.selenium.BrowserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest extends BrowserService {

    private static final String URL = "http://www.automationpractice.pl/index.php";

    @BeforeEach
    public void abrirNavegador(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void fecharNavegador(){
        driver.quit();
    }

}
