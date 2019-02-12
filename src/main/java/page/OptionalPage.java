package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by wwl on 2019/2/12.
 *
 * @author wwl
 */
public class OptionalPage extends BasePage {
    public SearchPage gotoSearch() {
        find(By.id("action_create_cube")).click();
        return new SearchPage();
    }

    public OptionalPage delStock(String stockName) {
        WebElement e1 = find(By.id("listview")).findElement(text(stockName));
        TouchAction ta = new TouchAction(Driver.getCurrentDriver());
        PointOption op = new PointOption();
        op.withCoordinates(e1.getLocation().getX(),e1.getLocation().getY());
        try {
            ta.longPress(op).release().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
        find(text("删除")).click();
        return this;
    }

    public ArrayList<String> getAll() {
        ArrayList<String> array = new ArrayList<String>();
        for (WebElement e : finds(By.id("portfolio_stockName"))) {
            array.add(e.getText());
        }
        return array;
    }

}
