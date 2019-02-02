package page;

import org.openqa.selenium.By;

/**
 * Created by wwl on 2019/2/2.
 * @author wwl
 */
public class ProfilePage extends BasePage {
    By login = text("点击登录");

    public LoginPage gotoLogin() {
        find(login).click();
        return new LoginPage();
    }
}
