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
        Integer len = cases.size();
        Arguments[] arg = new Arguments[len];
        for (int i = 0; i < len; i++) {
            HashMap<String, String> d = (HashMap<String, String>) cases.get(i);
            Collection<String> valueCollection = d.values();
            final int size = valueCollection.size();
//            List<String> valueList = new ArrayList<String>(valueCollection);

            String[] arr = new String[size];
            d.values().toArray(arr);

            if (size == 1) {
                arg[i] = arguments(arr[0]);
            } else if (size == 2) {
                arg[i] = arguments(arr[0], arr[1]);
            } else {
                arg[i] = arguments(arr[0], arr[1], arr[2]);
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
