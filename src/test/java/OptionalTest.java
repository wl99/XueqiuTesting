import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.OptionalPage;

/**
 * Created by wwl on 2019/2/12.
 */
public class OptionalTest {
    static MainPage mainPage;
    static OptionalPage optionalPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        optionalPage = mainPage.gotoOptional();
    }

    @Test
    void 添加自选股票(){
        optionalPage.gotoSearch();

    }
}
