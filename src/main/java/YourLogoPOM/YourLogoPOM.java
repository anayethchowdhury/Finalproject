package YourLogoPOM;

import org.openqa.selenium.By;

public class YourLogoPOM {
    public String url = "http://automationpractice.com/";

    public By Signin1 = new By.ByCssSelector(".header_user_info");
    public By htmlformtag = new By.ByCssSelector(".page-heading");
    public By signinemail = new By.ByCssSelector("#email_create");

    public By loginemail = new By.ByCssSelector("#email");



    public By createacc = new By.ByCssSelector("#SubmitCreate");

    public By title  = new By.ByCssSelector("#uniform-id_gender1");
    public By cxfirstname = new By.ByCssSelector("#customer_firstname");
    public By cxlastname = new By.ByCssSelector("#customer_lastname");
    public By password = new By.ByCssSelector("#passwd");

    public By dobdays = new By.ByCssSelector("#days");
    public By dobmonths = new By.ByCssSelector("#months");
    public By dobyears = new By.ByCssSelector("#years");
    public By address= new By.ByCssSelector("#address1");
    public By state = new By.ByCssSelector("#id_state");
    public By city = new By.ByCssSelector("#city");
    public By zipcode= new By.ByCssSelector("#postcode");
    public By mobilephone = new By.ByCssSelector("#phone_mobile");
    public By register = new By.ByCssSelector("#submitAccount");
    public By signin = new By.ByCssSelector("#SubmitLogin");
    public By women = new By.ByCssSelector("#block_top_menu > ul > li:nth-child(1)");

    public By tops= new By.ByCssSelector(".subcategory-image");
    public By continueshopping= new By.ByCssSelector(".continue");
    public By addtocart= new By.ByCssSelector("#add_to_cart");
    public By proceedcheckout= new By.ByCssSelector("[title=\"Proceed to checkout\"]");
    public By proceedcheckout1= new By.ByCssSelector("[title=\"Proceed to checkout\"]:nth-child(1)");
    public By addressproceedcheckout= new By.ByCssSelector("[name=\"processAddress\"]");
    public By shippingproceedcheckout= new By.ByCssSelector("[name=\"processCarrier\"]");

    public By termsandcondition= new By.ByCssSelector("#uniform-cgv");
    public By paymentbankwire= new By.ByCssSelector(".bankwire");
    public By getAddtocart= new By.ByCssSelector(".shopping_cart");
    public By checkout= new By.ByCssSelector("#button_order_cart");
    public By totalproducct= new By.ByCssSelector("#total_product");
    public By totalshipping= new By.ByCssSelector("#total_shipping");
    public By TOTAL= new By.ByCssSelector("#total_price_container");


    public By addinvisblecart= new By.ByCssSelector(".ajax_block_product .ajax_add_to_cart_button");

    public By smallsize= new By.ByCssSelector("#layered_id_attribute_group_1");
    public By confirmorder= new By.ByCssSelector("#cart_navigation .button-medium");




}
