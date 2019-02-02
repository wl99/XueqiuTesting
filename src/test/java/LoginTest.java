import org.junit.Test;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/2.
 * @author wwl
 */
public class LoginTest {
    @Test
    public void 非手机号(){
        MainPage mainPage=MainPage.start();
        ProfilePage profilePage = mainPage.gotoProfile();
        LoginPage loginPage=profilePage.gotoLogin();
        loginPage.passwordFail("32423434234","234234234");

//        toast=loginPage.password("133333","23332");
        assertThat(loginPage.getMessage(),equalTo("手机号码填写错误"));
    }
}
