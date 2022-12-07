package POMExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalCartPage extends AbstractPage{

    @FindBy(css="tr[class*='list'] div[class*='block-info']")
    private WebElement addedItemTitle;

    public PersonalCartPage(WebDriver driver){
        super(driver);
    }

    public String getAddedItemTitle(){
        return this.addedItemTitle.getText();
    }
}
