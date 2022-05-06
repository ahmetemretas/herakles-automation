package com.herakles.step_definitions;

import com.herakles.pages.KicchiPage;
import com.herakles.utilities.ConfigurationReader;
import com.herakles.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mission2_stepdefinition {

    KicchiPage kicchiPage = new KicchiPage();

    @Given("navigate to the url")
    public void navigate_to_the_url() {
        Driver.get().get(ConfigurationReader.get("url1"));
    }

    @Given("Click on the Generate random number button")
    public void click_on_the_generate_random_number_button() {
        kicchiPage.generateRandomNumber.click();
    }

    @Given("Click on the Verify number button")
    public void click_on_the_verify_number_button() {
        kicchiPage.verifyNumber.click();
    }

    @When("Verify a JS alert message is displayed")
    public void verify_a_js_alert_message_is_displayed() throws InterruptedException {
        Alert alert = Driver.get().switchTo().alert();
        WebDriverWait wait = new WebDriverWait(Driver.get(),30);
        wait.until(ExpectedConditions.alertIsPresent());

    }

    @Then("Verify the alert message is {string}")
    public void verify_the_alert_message_is(String string) {
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertEquals("It is not as expected",string,alert.getText());
    }
}
