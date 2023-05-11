// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TC93TemplateRegistroTabletTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tC93TemplateRegistroTablet() {
    driver.get("http://localhost:3000/");
    driver.manage().window().setSize(new Dimension(768, 1024));
    driver.findElement(By.cssSelector("span > img")).click();
    driver.findElement(By.linkText("Crear cuenta")).click();
    driver.findElement(By.cssSelector(".Menu_closeMenu__i2kTK > span")).click();
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).sendKeys("Marcelo");
    driver.findElement(By.id("lastName")).click();
    driver.findElement(By.id("lastName")).sendKeys("Trilus");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mtrilus@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234567");
    driver.findElement(By.id("password2")).sendKeys("1234567");
    driver.findElement(By.cssSelector(".Form_submitButton__GMX99")).click();
  }
}