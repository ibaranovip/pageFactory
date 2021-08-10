package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StepRegistration extends BasePage {
    @FindBy(xpath = "//input[@name='email']")
    public WebElement login;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordCheck;


    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement buttonLogin;


}