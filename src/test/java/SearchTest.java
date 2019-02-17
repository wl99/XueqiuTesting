import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import page.MainPage;
import page.SearchPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/12.
 *
 * @author wwl
 */
@TestMethodOrder(OrderAnnotation.class)
public class SearchTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearch();
    }

    @Order(1)
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SearchTest.csv", numLinesToSkip = 1)
    void 搜索测试(String keyword, String exp) {
        String name = searchPage.search(keyword).getAll().get(0);
        assertThat(name, equalTo(exp));
    }

    @Order(2)
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SearchTest.csv", numLinesToSkip = 1)
    void 股票搜索测试(String keyword, String exp) {
        String name = searchPage.search(keyword).getByStock().getAll().get(0);
        assertThat(name, equalTo(exp));
    }

    @Order(3)
    @ParameterizedTest
    @CsvFileSource(resources = "/data/SearchTest.csv", numLinesToSkip = 1)
    void 选择(String keyword) {
        ArrayList<String> arrayList = searchPage.search(keyword).addSelected();
        assertThat(arrayList, hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));
    }
}
