package FinalProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage2 extends BaseAction {

    public BlogPage2(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[3]/div[2]/div/a[1]")
    public WebElement previousClic;

    public BlogPage PreviousClic() {
        previousClic.click();
        return new BlogPage(driver);
    }

}

