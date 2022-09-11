package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    private static final String TEXT_AREA_XPATH = "//div[contains(@class, 'uiInput uiInputTextArea uiInput--default uiInput--textarea')]//span[text()='%s']//parent::label//following-sibling::textarea";
    private String labelText;
    private WebDriver driver;


    public TextArea(WebDriver driver, String labelText) {
        this.labelText = labelText;
        this.driver = driver;
    }

    public void inputAreaText(String text) {
        String finalXpath = String.format(TEXT_AREA_XPATH, labelText);
        driver.findElement(By.xpath(finalXpath)).sendKeys(text);

    }
}
