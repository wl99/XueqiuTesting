package common;


import config.XueqiuConfig;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class FindData {
    static XueqiuConfig data = new XueqiuConfig();


    static Stream<Arguments> getData(String casename, String filepath) {
        data.load(filepath);
        Arguments[] arg = new Arguments[3];
        ArrayList cases = data.getCase(casename);
        for (int i = 0; i < cases.size(); i++) {
            HashMap d = (HashMap) cases.get(i);
            arg[i]= Arguments.of(d.values());
        }
        return Arrays.stream(arg);
    }

    static Stream<String> tinyStrings() {
        return Stream.of(".", "oo", "OOO");
    }
}
