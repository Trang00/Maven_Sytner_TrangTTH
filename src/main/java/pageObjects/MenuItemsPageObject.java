package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class MenuItemsPageObject extends AbstractPage {
	WebDriver driver;
	public MenuItemsPageObject(WebDriver driverMapping) {
		driver=driverMapping;
	}
	
	
	/*
	public void inputToEmailIDTextbox(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}
	public void clickToSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	public String getUserIDText() {
		waitForControlVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextInElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openURL(driver, loginPageUrl);
		//return new LoginPageObject(driver);
		return PageFactoryManager.getLoginPage(driver);
	}
	*/
}
