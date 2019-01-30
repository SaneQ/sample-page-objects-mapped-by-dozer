package impl;

import com.github.dozermapper.core.CustomConverter;
import org.openqa.selenium.WebElement;

public class WebElementConverter implements CustomConverter {

    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        if (sourceFieldValue == null) {
            return existingDestinationFieldValue;
        }

        if (sourceFieldValue instanceof WebElement) {
            WebElement element = (WebElement) sourceFieldValue;

            if (element.getTagName().equals("input")) {
                return element.getAttribute("value");
            } else {
                return element.getText();
            }

        } else if (existingDestinationFieldValue instanceof WebElement) {
            WebElement element = (WebElement) existingDestinationFieldValue;
            element.sendKeys(sourceFieldValue.toString());
            return existingDestinationFieldValue;

        } else {
            return existingDestinationFieldValue;
        }
    }
}
