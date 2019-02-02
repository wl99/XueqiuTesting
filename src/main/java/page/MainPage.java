package page;

import driver.Driver;
import org.openqa.selenium.By;

/**
 * Created by wwl on 2019/2/2.
 */
public class MainPage extends BasePage {
    By profile = By.id("user_profile_icon");

    public static MainPage start() {
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile() {
        find(profile).click();
        return new ProfilePage();
    }
}