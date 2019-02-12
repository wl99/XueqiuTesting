package page;

import org.openqa.selenium.By;

public class SearchPage extends BasePage{
    public SearchPage search(String keyword){
        find(By.className("android.widget.EditText")).sendKeys(keyword);
        return this;
    }

    public MainPage cancel(){
        find(By.id("action_close")).click();
        return new MainPage();
    }
}
