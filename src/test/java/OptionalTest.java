import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.OptionalPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    @CsvSource({
            "600570, 恒生电子",
            "600571, 信雅达",
            "xiaomi, 小米集团-W"
    })
    void 添加删除自选股票(String keyword, String stockName) {
        ArrayList<String> array = optionalPage.gotoSearch().search(keyword).addOptional().cancelOnOptionPage().getAll();
        assertThat(array, hasItems(stockName));
        ArrayList<String> array2 = optionalPage.delStock(stockName).getAll();
        assertThat(array.size()-array2.size(),is(1));
    }

}
