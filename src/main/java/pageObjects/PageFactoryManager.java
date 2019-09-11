package pageObjects;

import org.openqa.selenium.WebDriver;


public class PageFactoryManager {
	public static MenuItemsPageObject getMenuItemsPage(WebDriver driver) {
		return new MenuItemsPageObject(driver);
	}
	

	
}
