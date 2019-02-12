package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by wwl on 2019/2/2.
 * @author wwl
 */
public class BasePage {
    static WebElement find(By locator) {
        try {
            return Driver.getCurrentDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }

    static By locate(String locator) {
        if (locator.matches("/.*")) {
            return By.xpath(locator);
        } else {
            return By.id(locator);
        }
    }

    static By text(String content) {
        return By.xpath("//*[@text='" + content + "']");
    }
}
