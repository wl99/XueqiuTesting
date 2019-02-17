package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wwl on 2019/2/15.
 */
public class XueqiuConfig {
    static String username = "18606535366";
    static String password = "5454234";
    static String app = "https://XXXX/xueeqiu.apk";

    static ArrayList<HashMap<String, Object>> optionaldata = new ArrayList<>();
    static ArrayList<HashMap<String, Object>> logindata = new ArrayList<>();
//    static HashMap<String, ArrayList<HashMap<String, Object>>> data = new HashMap<String, ArrayList<HashMap<String, Object>>>();

    static void load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            XueqiuConfig data = mapper.readValue(XueqiuConfig.class.getResource(path),XueqiuConfig.class);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
