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


    private String username = "18606535366";
    private String password = "5454234";
    private String app = "https://XXXX/xueeqiu.apk";


    private ArrayList<HashMap<String, Object>> optionaldata = new ArrayList<HashMap<String, Object>>();
    private ArrayList<HashMap<String, Object>> logindata = new ArrayList<HashMap<String, Object>>();

    static HashMap<String, ArrayList<HashMap<String, String>>> data = new HashMap<String, ArrayList<HashMap<String, String>>>();

    public void load(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            data = mapper.readValue(XueqiuConfig.class.getResource(path), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getCase(String casename) {
        return data.get(casename);
    }

    public ArrayList<HashMap<String, Object>> getLogindata() {
        return logindata;
    }

    public ArrayList<HashMap<String, Object>> getOptionaldata() {
        return optionaldata;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getApp() {
        return app;
    }

    public String getCases(String cases) {
        return cases;
    }

}
