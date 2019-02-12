package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

/**
 * Created by wwl on 2019/2/12.
 *
 * @author wwl
 */

public class SearchPage extends BasePage {
    By editText = By.className("android.widget.EditText");
    By cancel = By.id("action_close");

    public SearchPage search(String keyword) {
        find(editText).sendKeys(keyword);
        return this;
    }

    public MainPage cancel() {
        find(cancel).click();
        return new MainPage();
    }

    public OptionalPage cancelOnOptionPage() {
        find(cancel).click();
        return new OptionalPage();
    }

    public ArrayList<String> getAll() {
        ArrayList<String> array = new ArrayList<String>();
        for (WebElement e : finds(By.id("stockName"))) {
            array.add(e.getText());
        }
        return array;
    }

    public SearchPage getByStock() {
        find(By.id("ti_tab_indicator")).findElement(text("股票")).click();
        return this;
    }

    public SearchPage addOptional(){
        try {
            find(By.id("follow_btn")).click();
        } catch (NoSuchElementException e) {
            System.out.println("该已被添加");
        }
        return this;
    }


    public ArrayList<String> addSelected() {
        ArrayList<String> array = new ArrayList<String>();
        WebElement select = find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn') ]"));
        array.add(select.getAttribute("resourceId"));
        select.click();
        WebElement select2 = find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn') ]"));
        array.add(select2.getAttribute("resourceId"));
        return array;
    }

    public SearchPage removeSelected() {
        try {
            find(By.id("followed_btn")).click();
        } catch (NoSuchElementException e) {
            System.out.println("不在已选状态！");
        }
        return this;
    }
}
