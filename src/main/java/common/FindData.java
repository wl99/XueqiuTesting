package common;


import config.XueqiuConfig;
import org.junit.jupiter.params.provider.Arguments;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindData {
    static XueqiuConfig data = new XueqiuConfig();


    private static Stream<Arguments> getData(String casename) {
        data.load("/data/testData.yaml");

        ArrayList<HashMap<String, Object>> cases = data.getCase(casename);
        int len = cases.size();
        Arguments[] arg = new Arguments[len];
        for (int i = 0; i < len; i++) {
            HashMap<String, Object> d = cases.get(i);
            Object[] o = d.values().toArray();
            arg[i] = arguments(o);
        }
        return Arrays.stream(arg);
    }

    static Stream<Arguments> 添加删除自选股票() {
        String method = Thread.currentThread().getStackTrace()[1].getMethodName();
        return getData(method);
    }

    static Stream<Arguments> 密码登录() {
        return getData("密码登录");
    }
}
