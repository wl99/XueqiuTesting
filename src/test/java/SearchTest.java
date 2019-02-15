import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
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
public class SearchTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = MainPage.start();
        searchPage = mainPage.gotoSearch();
    }

    @ParameterizedTest
    @CsvSource({
            "pdd, 拼多多",
            "alibaba, 阿里巴巴",
            "sogo, 搜狗"
    })
    void 搜索测试(String keyword, String exp) {
        String name = searchPage.search(keyword).getAll().get(0);
        assertThat(name, equalTo(exp));
    }

    @ParameterizedTest
    @CsvSource({
            "600570, 恒生电子",
            "600571, 信雅达",
            "xiaomi, 小米集团-W"
    })
    void 股票搜索测试(String keyword, String exp) {
        String name = searchPage.search(keyword).getByStock().getAll().get(0);
        assertThat(name, equalTo(exp));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/SearchTest.csv")
    void 选择(String keyword) {
        ArrayList<String> arrayList = searchPage.search(keyword).addSelected();
        assertThat(arrayList, hasItems("com.xueqiu.android:id/followed_btn", "com.xueqiu.android:id/follow_btn"));
    }
}
