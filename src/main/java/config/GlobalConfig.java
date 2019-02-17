package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wwl on 2019/2/15.
 */
public class GlobalConfig {
    public XueqiuConfig xueqiu = new XueqiuConfig();
    public AppiumConfig appium = new AppiumConfig();

    public static GlobalConfig load(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            GlobalConfig config = mapper.readValue(GlobalConfig.class.getResource(path), GlobalConfig.class);
            return config;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void write(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            mapper.writeValue(new File(path), new GlobalConfig());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
