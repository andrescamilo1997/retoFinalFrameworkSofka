package com.automationpractice.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contact_us.feature"},
        glue = {"com.automationpractice.test.stepdefinition"},
        publish = true
)
public class ContactUsTestRunner {
}
