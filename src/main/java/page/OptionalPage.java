package page;

import org.openqa.selenium.By;

/**
 * Created by wwl on 2019/2/12.
 *
 * @author wwl
 */
public class OptionalPage extends BasePage {
    public SearchPage gotoSearch(){
        find(By.id("action_create_cube")).click();
        return new SearchPage();
    }

}
