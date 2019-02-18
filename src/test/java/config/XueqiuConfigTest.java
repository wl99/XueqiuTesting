package config;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wwl on 2019/2/18.
 */
class XueqiuConfigTest {

    @Test
    void load() {
        XueqiuConfig data = new XueqiuConfig();
        data.load("/data/testData.yaml");
        System.out.println(data.getCase("添加删除自选股票").get(0).getClass());
        ArrayList cases = data.getCase("添加删除自选股票");
        for (int i = 0; i < cases.size(); i++) {
            HashMap d=  (HashMap) cases.get(i);
            d.keySet().forEach(key -> {
                String value = d.get(key).toString();
                System.out.println(key+":"+value);
            });

        }
    }
}