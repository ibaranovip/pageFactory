package projectTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import project.pages.LoginPage;
import project.util.BrowserUtil;
import project.util.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginTest extends BaseTest{

    @Test(priority=1,testName="",description="")
    @Step
    @Epic("Regression test")

    public void chek() {
        LoginPage loginPage = new LoginPage();

       BrowserUtil.moveMouse(loginPage.menuItem, loginPage.selectWatches);
       loginPage.selectWatchesId.click();
       BrowserUtil.SelectEtem(loginPage.selectOption,"No");
       loginPage.buttonPutСart.click();
       loginPage.goShoppingCart.click();
       loginPage.placeOrder.click();

       loginPage.fueldFirstName.sendKeys(DataGenerator.createUserInfo().get("firstname"));
       loginPage.fueldLastName.sendKeys(DataGenerator.createUserInfo().get("lastname"));
       BrowserUtil.SelectEtem(loginPage.fueldCountry,"Россия");
       loginPage.fueldStreet.sendKeys(DataGenerator.createUserInfo().get("address"));
       loginPage.fueldCity.sendKeys(DataGenerator.createUserInfo().get("city"));
       loginPage.fueldRegion.sendKeys(DataGenerator.createUserInfo().get("region"));
       loginPage.fueldEmail.sendKeys(DataGenerator.createUserInfo().get("email"));
       loginPage.fueldPhoneNumber.sendKeys(DataGenerator.createUserInfo().get("phone"));
       loginPage.fueldPostCode.sendKeys(DataGenerator.createUserInfo().get("postcode"));
       loginPage.rememberYou.click();
       loginPage.placeOrderEnd.click();

       assertThat("Заказ принят").
               isEqualTo(loginPage.getAssert.getText());

    }

}
