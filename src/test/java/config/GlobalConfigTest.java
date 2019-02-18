package config;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wwl on 2019/2/15.
 */
class GlobalConfigTest {

    @Test
    void load() {
        GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");
        assertThat(config, not(equalTo(null)));
        System.out.println(config);
        System.out.println(config.xueqiu.getUsername());
        System.out.println(config.appium.url);
        System.out.println(config.appium.capabilities.get("aaa"));
        GlobalConfig data = GlobalConfig.load("/data/testData.yaml");
        assertThat(data, not(equalTo(null)));
        System.out.println(data.xueqiu.getOptionaldata());
        System.out.println(data.xueqiu.getLogindata().get(0).get("exp"));

    }
}