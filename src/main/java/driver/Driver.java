package driver;

import config.GlobalConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by wwl on 2019/2/2.
 *
 * @author wwl
 */
public class Driver {
    private static AppiumDriver<WebElement> driver;

    public static void start() {
        GlobalConfig config = GlobalConfig.load("/data/globalConfig.yaml");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        config.appium.capabilities.keySet().forEach(key -> {
            Object value = config.appium.capabilities.get(key);
            desiredCapabilities.setCapability(key, value);
        });
        URL remoteUrl = null;
        try {
            remoteUrl = new URL(config.appium.url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(config.appium.wait, TimeUnit.SECONDS);
    }

    public static AppiumDriver<WebElement> getCurrentDriver() {
        return driver;
    }
}
