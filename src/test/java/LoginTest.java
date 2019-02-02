import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.ProfilePage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/2.
 *
 * @author wwl
 */
public class LoginTest {
    @ParameterizedTest
    @CsvSource({
            "18606535377,XXXXXXXX,用户名或密码错误",
            "186065353,XXXXXXXX,手机号码填写错误"
    })
    public void 密码登录(String username, String password, String exp) {
        MainPage mainPage = MainPage.start();
        ProfilePage profilePage = mainPage.gotoProfile();
        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.passwordFail(username, password);

//        toast=loginPage.password("133333","23332");
        assertThat(loginPage.getMessage(), equalTo(exp));
    }
}
