import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import page.MainPage;
import page.OptionalPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/data/OptionalTest.csv", numLinesToSkip = 1)
    void 添加删除自选股票(String keyword, String stockName) {
        ArrayList<String> array = optionalPage.gotoSearch().search(keyword).addOptional().cancelOnOptionPage().getAll();
        assertThat(array, hasItems(stockName));
        ArrayList<String> array2 = optionalPage.delStock(stockName).getAll();
        assertThat(array.size() - array2.size(), is(1));
    }

    @ParameterizedTest
    @MethodSource("common.FindData.getData#添加删除自选股票"+"/data/testData.yaml")
    void 添加删除自选股票2(String keyword, String stockName) {
        ArrayList<String> array = optionalPage.gotoSearch().search(keyword).addOptional().cancelOnOptionPage().getAll();
        assertThat(array, hasItems(stockName));
        ArrayList<String> array2 = optionalPage.delStock(stockName).getAll();
        assertThat(array.size() - array2.size(), is(1));
    }

}
