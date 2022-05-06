package com.herakles.step_definitions;

import com.herakles.pages.GooglePage;
import com.herakles.utilities.BrowserUtils;
import com.herakles.utilities.ConfigurationReader;
import com.herakles.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Mission3_stepdefinition {

    GooglePage googlePage = new GooglePage();

    @Given("Navigate to url")
    public void navigate_to_url() {
        Driver.get().get(ConfigurationReader.get("url2"));
    }

    @When("Write {string} to search box and press Enter")
    public void write_to_search_box_and_press_enter(String string) {
        googlePage.searchBox.sendKeys(string);
        googlePage.searchBox.sendKeys(Keys.ENTER);
    }

    @When("Print out to console how many of the search results include {string} in their domains.")
    public void print_out_to_console_how_many_of_the_search_results_include_in_their_domains(String string) {
        List<WebElement> domains = Driver.get().findElements(By.xpath("//cite[@role='text']"));
        String s;
        int numberOfDomainIncludeFacebook = 0;
        List<String> domainsString = new ArrayList<>();
        for (int i = 0; i < domains.size(); i++) {
            if (domains.get(i).getText().contains("facebook")) {
                domainsString.add(domains.get(i).getText());
            }
        }
        for (int i = 0; i < domainsString.size(); i++) {
            s = domainsString.get(i).substring(0, domainsString.get(i).indexOf(".com"));
            domainsString.set(i, s);
            if (domainsString.get(i).contains("facebook")) {
                numberOfDomainIncludeFacebook = numberOfDomainIncludeFacebook + 1;
                System.out.println(domainsString.get(i));
            }

        }


        System.out.println("The number of domain which includes facebook: " + numberOfDomainIncludeFacebook);



    }
}
