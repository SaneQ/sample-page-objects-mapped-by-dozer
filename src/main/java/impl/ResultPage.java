package impl;

import com.github.dozermapper.core.Mapping;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "dt.result-title a")
    @Mapping("results")
    public List<WebElement> links;
}
