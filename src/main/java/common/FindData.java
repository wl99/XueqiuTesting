package common;


import config.GlobalConfig;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

import java.util.stream.Stream;

public class FindData {
    public static GlobalConfig config = new GlobalConfig();


    static Stream<Arguments> getData(String casename) {
        config.load("/data/testData.yaml");
        config.xueqiu.
    }
}
