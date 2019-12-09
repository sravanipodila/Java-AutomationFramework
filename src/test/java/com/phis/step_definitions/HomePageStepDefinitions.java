package com.phis.step_definitions;

import com.phis.pages.HuntPage;
import com.phis.utilities.BrowserUtils;
import com.phis.utilities.ConfigurationReader;
import com.phis.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageStepDefinitions {

// OPTION + ENTER       MAC
//// ALT + ENTER       WINDOWS
////     CHecking git
////


    @Given("user on the login page")
    public void user_on_the_login_page() {
        System.out.println("I am opening the login page");
        // open the login page of the application
        // url is in the properties file
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("user logs in as a team lead")
    public void user_logs_in_as_a_team_lead() {
//        System.out.println("I am logging in");
//        System.out.println("email: " + ConfigurationReader.getProperty("leader_email"));
//        System.out.println("password: " + ConfigurationReader.getProperty("leader_password"));


//
//        Driver.getDriver().findElement(By.xpath("/html/body/form/div[7]/div[1]/div[2]/div[1]/div[2]/table/tbody/tr[3]/td[1]/div/span[2]/input")).click();
////
////        Select dropdown = new Select(Driver.getDriver().findElement(By.xpath("/html/body/form/div[7]/div[1]/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[1]/select")));
////
////        dropdown.selectByIndex(55);
////
////        BrowserUtils.wait(5);
//        PageFactory.initElements(Driver.getDriver(), HuntPage());
        HuntPage click2 = new HuntPage();
        PageFactory.initElements(Driver.getDriver(), HuntPage.class);

        click2.text321.click();

//       WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
//        click2.text321.sendKeys(ConfigurationReader.getProperty("leader_password"));
//
//        signInPage.signIn.click();

    }

//    @Then("homepage should be displayed")
//    public void homepage_should_be_displayed() {
//
//        System.out.println("I can see the home page now!!");
//        // verify the header
//        String expected = "map";
//
//        MapPage mapPage= new MapPage();
//
////        BrowserUtils.waitForVisibility(mapPage.map, 5);
//
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
////        wait.until(ExpectedConditions.textToBePresentInElement(mapPage.header, "map"));
//
//        wait.until(ExpectedConditions.urlContains("map"));
//
//        // ExpectedConditions.url to be
//
//        String actual = mapPage.title.getText();
//
//        // assertions are coming from Junit
//        Assert.assertEquals(expected, actual);
//
//    }
//
//    @Then("the title should be correct")
//    public void the_title_should_be_correct() {
//        System.out.println("Checking title");
//    }
//
//    @When("user logs in as a team member")
//    public void user_logs_in_as_a_team_member() {
//        System.out.println("I am logging in as member");
//
//        SignInPage signInPage = new SignInPage();
//        signInPage.email.sendKeys(ConfigurationReader.getProperty("member_email"));
//        signInPage.password.sendKeys(ConfigurationReader.getProperty("member_password"));
//        signInPage.signIn.click();
//
//    }
//
//    @When("user logs in as a teacher")
//    public void user_logs_in_as_a_teacher() {
//        System.out.println("I am logging in as teacher");
//
//        SignInPage signInPage = new SignInPage();
//        signInPage.email.sendKeys(ConfigurationReader.getProperty("teacher_email"));
//        signInPage.password.sendKeys(ConfigurationReader.getProperty("teacher_password"));
//        signInPage.signIn.click();
//
//    }


}

