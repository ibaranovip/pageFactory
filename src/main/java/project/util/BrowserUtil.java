package project.util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.browser.DriverManager;


public class BrowserUtil {


    //metod click mouse
    public static void click(WebElement webElement) {
        webElement.click();
   }


   //wait For Clickablility
    public  static WebElement    waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),timeout);
          return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //wait  presence Of ElementLocated
    public static WebElement presenceOfElementLocated(By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),timeout);
       return    wait.until(ExpectedConditions.presenceOfElementLocated(element));

    }
    //scrollIntoView
    public static WebElement scrollIntoView(WebElement element) {
        return (WebElement) ((JavascriptExecutor) DriverManager.getDriver()).
                executeScript("arguments[0].scrollIntoView(true);", element);}


    //waitForVisibility
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  static void imitationMause(WebElement webElement, WebElement webElement2){
        JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", webElement);
        webElement2.click();
        }
    public static WebElement ExecuteScript(WebElement webElement,WebElement webElement2 ) {
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].click();", webElement);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 2);
        wait.until(ExpectedConditions.elementToBeClickable(webElement2));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement2);
        webElement2.click();
        return null;
    }
    public static WebElement ExecuteChekBox(WebElement webElement2, String s) {

        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 2);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement2, s));
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", webElement2);
        webElement2.click();
        return null;
    }

    //Building a drag and drop action
    public  static void drop(WebElement webElement, WebElement webElement2){
        Actions builder = new Actions(DriverManager.getDriver());
        Action dragAndDrop = builder.clickAndHold(webElement)
                .moveToElement(webElement2)
                .release(webElement2)

                .build();
        //Performing the drag and drop action
        dragAndDrop.perform();

    }

    //selectValueInDropDown
    public static void selectValueInDropDown(WebElement value)
    {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        String jsCmd = "document.getElementsByName('show')[0].value='" + value + "'";
        js.executeScript(jsCmd);

    }
    //Select item options
    public static void SelectEtem(WebElement webElement, String option){

        Select select = new Select(webElement);
        select.selectByVisibleText(option);
    }

      //imitation move mouse
    public  static void moveMouse(WebElement webElement, WebElement webElement2){
        Actions builder = new Actions(DriverManager.getDriver());

//Building action
        Action moveMouse = builder.moveToElement(webElement)
                .click(webElement2)
                .build();
        //Performing  action
        moveMouse.perform();

    }


}
