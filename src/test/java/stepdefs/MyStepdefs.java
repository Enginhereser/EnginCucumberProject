package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import readers.property.PropertyReaders;
import java.util.List;

public class MyStepdefs extends BaseSteps {

    @Given("user go to the Homepage")
    public void userGoToTheHomepage() {
        driver.get(PropertyReaders.read().get("url"));
        wait.until(ExpectedConditions.urlToBe("https://www.f-i.de/"));
    }

    @When("click aside menu")
    public void hoverOverAndClickToTheHeaderMenu() {
       click(By.xpath(PropertyReaders.read().get("aside.menu")));
        By assertAsideMenu = By.xpath(PropertyReaders.read().get("assert.aside.menu"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(assertAsideMenu));
    }

    @And("hover over links")
    public void clickToLanguageButton() {
        List<WebElement> menus = driver.findElements(By.xpath(PropertyReaders.read().get("aside.menu.link")));
        for (int i = 1; i < 6; i++) {
        click(menus.get(i));
        sleep(500);
            List<WebElement> underMenus = driver.findElements(By.xpath(PropertyReaders.read().get("aside.menu.links2")));
            for (WebElement underMenu : underMenus) {
                hover(underMenu);
                sleep(200);
            }
        }
    }
}
