package genericLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility 
{
	public void selectByVisibleTextMethod(WebElement dropdown, String text)
	{
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(text);
	}
}
