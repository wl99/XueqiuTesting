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

        ArrayList cases = data.getCase(casename);
        int len = cases.size();
        Arguments[] arg = new Arguments[len];
        for (int i = 0; i < len; i++) {
            HashMap<String, String> d = (HashMap<String, String>) cases.get(i);
            Collection<String> valueCollection = d.values();
            final int size = valueCollection.size();
            List valueList = new ArrayList<>(valueCollection);
            if (size == 1) {
                arg[i] = arguments(valueList.get(0));
            } else if (size == 2) {
                arg[i] = arguments(valueList.get(0), valueList.get(1));
            } else {
                arg[i] = arguments(valueList.get(0), valueList.get(1), valueList.get(2));
            }
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
