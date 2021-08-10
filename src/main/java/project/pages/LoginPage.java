package project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage  {


    @FindBy(xpath = "//li[@class='menu-item menu-item-has-children dropdown']")
    public WebElement menuItem;

    //select menu Watches
    @FindBy(xpath = "//a[@title='Watches']")
      public WebElement selectWatches;
    //select watches
    @FindBy(xpath = "//a[@data-product_id='312']")
    public WebElement selectWatchesId;

    //select option - yes/no  //select[@id='logo']

    @FindBy(xpath = "//select[@id='logo']")
    public WebElement selectOption;


    //put to shopping cart
    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    public WebElement buttonPutСart;




//goShoppingCart
    @FindBy(css = ".container-fluid.site-header > .container a[title='Корзина'] > .amount-cart.hidden-xs")
    public WebElement goShoppingCart;

//Place Order
    @FindBy(xpath = "//a[text()[contains(.,'Оформить заказ')]]")
    public WebElement placeOrder;
//adresStreat

    @FindBy(xpath = "//input[@name='billing_address_1']")
    public WebElement fueldStreet;
//city
    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement fueldCity;

//postCode
    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement fueldPostCode;
//firstName
    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement fueldFirstName;
//lastName
    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement fueldLastName;
//email
    @FindBy(xpath = "/html//input[@id='billing_email']")
    public WebElement fueldEmail;

//phoneNumber
    @FindBy(xpath = "//input[@id='billing_phone']")
    public WebElement fueldPhoneNumber;
//saveButton
    @FindBy(xpath = "//button[@id='place_order']")
    public WebElement placeOrderEnd;
//rememberYou
    @FindBy(xpath = "//input[@name='createaccount']")
    public WebElement rememberYou;
//region
    @FindBy(xpath = "/html//input[@id='billing_state']")
    public WebElement fueldRegion;
//selestFueldCountry
    @FindBy(xpath = "//select[@name='billing_country']")
    public WebElement  fueldCountry;


//getAssert
    @FindBy(xpath = "//h1[text()[contains(.,'Заказ принят')]]")
    public WebElement getAssert;




}
