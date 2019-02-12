import org.junit.jupiter.api.BeforeAll;
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

    static MainPage mainPage;
    static ProfilePage profilePage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        profilePage = mainPage.gotoProfile();
    }

    @ParameterizedTest
    @CsvSource({
            "18606535376,XXXXXXXX,用户名或密码错误",
            "1860653536,XXXXXXXX,手机号码填写错误"
    })
    void 密码登录(String username, String password, String exp) {

        LoginPage loginPage = profilePage.gotoLogin();
        loginPage.passwordFail(username, password);

//        toast=loginPage.password("133333","23332");
        assertThat(loginPage.getMessage(), equalTo(exp));
        profilePage=loginPage.gotoProfile();
    }
}
