package project.pages;


import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import project.browser.DriverManager;

import static org.openqa.selenium.support.PageFactory.initElements;
import static project.browser.ConfigurationManager.configuration;

public class BasePage {

      protected BasePage() {
             initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), configuration().timeout()), this);
         }
     }
