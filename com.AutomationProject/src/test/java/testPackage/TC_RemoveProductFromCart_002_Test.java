package testPackage;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibrary.BaseTest;
import pomPackage.ElectronicsPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(genericLibrary.MyListeners.class)
public class TC_RemoveProductFromCart_002_Test extends BaseTest{
  @Test
  public void removeProductFromCart()
  {
	  WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.getCellPhoneLink().click();
		ep.getSmartphoneAddToCartButton().click();
		
		wp.getShoppingCartLink().click();
		
		ShoppingCartPage sp = new ShoppingCartPage(driver);
		sp.getSmaertphoneCheckbox().click();
		
		sp.getUpdateShoppingCartButton().click();
		
		SoftAssert sa = new SoftAssert();
		try 
		{
		sa.assertEquals(sp.getSmartphoneCartProduct().isDisplayed(),false, "Product is not removed from cart");
		}
		catch(Exception e)
		{
			Reporter.log("Product is removed from cart", true);
		}
		sa.assertAll();
  }
}
