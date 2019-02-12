package page;

import driver.Driver;
import org.openqa.selenium.By;

/**
 * Created by wwl on 2019/2/2.
 */
public class MainPage extends BasePage {
    private By profile = By.id("user_profile_icon");
    private By search = By.id("home_search");
    private By tab=By.id("tabs");
    private By tab_name=By.id("tab_name");

    public static MainPage start() {
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile() {
        find(profile).click();
        return new ProfilePage();
    }

    public SearchPage gotoSearch(){
        find(search).click();
        return new SearchPage();
    }

    public OptionalPage gotoOptional(){
        // 获取标签列表中的第二个
        find(tab).findElements(tab_name).get(1).click();
        return new OptionalPage();
    }
}
