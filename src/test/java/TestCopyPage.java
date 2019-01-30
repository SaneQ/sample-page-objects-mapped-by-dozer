import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import impl.ResultPage;
import impl.SearchPage;
import model.QueryModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TestCopyPage {

    private WebDriver driver;
    private Mapper mapper;

    @BeforeEach
    void initDriver() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://selenium2.ru/");

        mapper = DozerBeanMapperBuilder.create().withMappingFiles("dozerConfig.xml").build();
    }

    @Test
    void copyPage() {
        QueryModel model = new QueryModel("selenium grid");

        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        mapper.map(model, searchPage);

        ResultPage resultPage = searchPage.doSearch();
        mapper.map(resultPage, model);

        Assertions.assertEquals(20, model.results.size());
    }

    @AfterEach
    void stopDriver() {
        driver.quit();
    }
}
