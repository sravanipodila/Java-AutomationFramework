package com.phis.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
             "html:target/default-cucumber-reports",
              "json:target/cucumber.json"
        },
        features = {"src/test/resources/features/homepage.feature"},
        glue = "com/phis/step_definitions"
        , dryRun = false
        , tags = "@leader"
)
public class CukesRunner {
}
