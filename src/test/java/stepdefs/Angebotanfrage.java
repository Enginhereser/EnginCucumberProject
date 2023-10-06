package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import readers.property.PropertyReaders;

import java.util.List;

public class Angebotanfrage extends BaseSteps{
    @Given("user go to the Homepage")
    public void userGoToTheHomepage() {
        driver.get(PropertyReaders.read().get("url"));
        wait.until(ExpectedConditions.urlToBe("https://www2.deloitte.com/de/de.html"));
    }

    @Given("hover over to Services")
    public void hoverOverToServices() {
        click(By.xpath(PropertyReaders.read().get("coockies")));
        click(By.xpath(PropertyReaders.read().get("header_menus")));

    }

    @When("click the button Abschlussprufung")
    public void clickTheButtonAbschlussprufung() {
        sleep(2000);
        List<WebElement> submenu_links = driver.findElements(By.xpath(PropertyReaders.read().get("submenu_links")));
        wait.until(ExpectedConditions.visibilityOfAllElements(submenu_links.get(0)));
        click(submenu_links.get(0));
    }

    @And("click on the right of page the button zur Angebotsanfrage")
    public void clickOnTheRightOfPageTheButtonZurAngebotsanfrage() {
        sleep(1000);
        List<WebElement> asidemenu_form = driver.findElements(By.xpath(PropertyReaders.read().get("asidemenu_form")));
        wait.until(ExpectedConditions.visibilityOfAllElements(asidemenu_form.get(3)));
        scrollBy(150);
        sleep(1000);
        click(asidemenu_form.get(3));
    }

    @Then("verify color of input field")
    public void verifyColorOfInputField() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(PropertyReaders.read().get("red_error_from_form")),1));

    }

    @And("click the button Übermitteln")
    public void clickTheButtonÜbermitteln() {
        List<WebElement> selectmenu = driver.findElements(By.xpath(PropertyReaders.read().get("selectmenu")));
        scrollBy(300);
        click(selectmenu.get(2));
        Select select = new Select(selectmenu.get(2));
        select.selectByValue("Consumer");
        click(selectmenu.get(2));
        sleep(2000);
        WebElement button_ubermitteln = driver.findElement(By.xpath(PropertyReaders.read().get("button_Ubermitteln")));
        scrollBy(300);
        click(button_ubermitteln);
        sleep(3000);

    }

    @Then("verify color of input field and error message")
    public void verifyColorOfInputFieldAndErrorMessage() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(PropertyReaders.read().get("red_error_from_form")),7));
        List<WebElement> red_error_from_form = driver.findElements(By.xpath(PropertyReaders.read().get("red_error_from_form")));
        for (WebElement borders : red_error_from_form) {
            String border = borders.getCssValue("border-color");
            String afterColor = Color.fromString(border).asHex();
            Assert.assertEquals(afterColor,PropertyReaders.read().get("after_border_color"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyReaders.read().get("error_message"))));
        }
    }

    @And("Fill in the mandatory fields")
    public void fillInTheMandatoryFields(DataTable table) {
        List<WebElement> inputs = driver.findElements(By.xpath(PropertyReaders.read().get("obligator_input")));
        List<String> inputText = table.asList();
        int index = 0;
        for (WebElement input : inputs) {

            sendKeys(input,inputText.get(index));
            index ++;
            sleep(1500);
        }

    }
}
