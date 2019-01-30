package impl;

import com.github.dozermapper.core.Mapping;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "mod-search-searchword")
    @Mapping("query")
    public WebElement queryField;

    public ResultPage doSearch() {
        queryField.sendKeys(Keys.ENTER);
        return PageFactory.initElements(driver, ResultPage.class);
    }
}
