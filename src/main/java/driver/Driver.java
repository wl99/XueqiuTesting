package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by wwl on 2019/2/2.
 * @author wwl
 */
public class Driver {
    private static AppiumDriver<WebElement> driver;

    public static void start() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "huiwei");
        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
        desiredCapabilities.setCapability("autoGrantPermissions", true);

        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    public static AppiumDriver<WebElement> getCurrentDriver(){
        return driver;
    }
}
