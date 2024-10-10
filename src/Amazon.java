import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Amazon {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
          try {
            // Navigate to Amazon India
            driver.get("https://www.amazon.in");
            driver.manage().window().maximize();

            // Set up explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Search for "Wrist Watches"
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
            searchBox.sendKeys("Wrist Watches");
            searchBox.submit();  

            // Filter by "Leather" under Watch Band Material
            WebElement leatherFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leather']")));
            leatherFilter.click();

            // Wait for filter to apply
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".s-main-slot")));

            // Select "Fastrack" as the brand
            WebElement fastrackFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Fastrack']")));
            fastrackFilter.click();

            // Wait for filter to apply
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".s-main-slot")));

            // Navigate to the 2nd page
            WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@aria-label, 'Go to page 2')]")));
            nextPageButton.click();

            // Wait for the second page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@data-component-type='s-search-result'])[1]")));

            // Add the first product in the first row to the cart
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@data-component-type='s-search-result'])[1]//h2/a")));
            firstProduct.click();

            // Wait for product page to load
            wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));

            // Step 6: Add the product to the cart
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
            addToCartButton.click();

            // Wait for cart confirmation (this could be a popup or a page load)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attach-accessory-cart-subtotal")));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
	
