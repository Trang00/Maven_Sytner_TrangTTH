package commons;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import pageObjects.PageFactoryManager;
import pageUIs.AbstractPageUI;

public class AbstractPage {

	WebElement element;
	List<WebElement> elements;
	JavascriptExecutor javascriptExecutor;
	WebDriverWait waitExplicit;
	Actions action;
	By byLocator;
	// int shortTimeout = 5;
	// long shortTimeout=5;
	// int longTimeout = 30;

	// long longTimeout=30;
	// WEB BROWSER
	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrenUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Constansts.LONG_TIMEOUT);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// WEB ELEMENT
	public void clickToElement(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		highlightElement(driver, locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String value) {
		highlightElement(driver, locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void senkeyToElement(WebDriver driver, String value, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		// highlightElement(driver, locator);
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInHtmlDropdown(WebDriver driver, String locator, String valueInDropdown) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(valueInDropdown);
	}

	public void getSelectedItemInHtmlDropdown(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.getFirstSelectedOption().getText();
	}

	public void selectItemInHtmlDropdownDynamic(WebDriver driver, String valueInDropdown, String locator,
			String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.selectByVisibleText(valueInDropdown);
	}

	public void getSelectedItemInHtmlDropdownDynamic(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath,
			String valueExpected) throws Exception {

		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Constansts.LONG_TIMEOUT);

		WebElement parent = driver.findElement(By.xpath(parentXpath));
		javascript.executeScript("arguments[0].click();", parent);
		Thread.sleep(1000);

		List<WebElement> child = driver.findElements(By.xpath(childXpath));
		wait.until(ExpectedConditions.visibilityOfAllElements(child));
		Thread.sleep(1000);

		for (WebElement childItem : child) {
			if (childItem.getText().equals(valueExpected)) {
				javascript.executeScript("arguments[0].scrollIntoView(true);", childItem);
				Thread.sleep(3000);
				javascript.executeScript("arguments[0].click();", childItem); // childItem.click();
				break;
			}
		}

	}

	public String getAttributeValueInElement(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextInElement(WebDriver driver, String locator) {
		highlightElement(driver, locator);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextDynamicInElement(WebDriver driver, String locator, String... dynamicValue) {
		//
		// highlight(driver, AbstractPageUI.DYNAMIC_TEXT);
		locator = String.format(locator, (Object[]) dynamicValue);
		highlightElement(driver, locator);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {

		try {
			WebElement element = driver.findElement(By.xpath(locator));
			// highlightElement(driver, locator);
			boolean status = element.isDisplayed();
			return status;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		highlightElement(driver, locator);
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			boolean status = element.isDisplayed();
			return status;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnable(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindowID(WebDriver driver, String parent) {// khi chỉ có 2 window
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindow : allWindows) {
			if (!childWindow.equals(parent)) {
				driver.switchTo().window(childWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String titleExpected) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String currentWinTitle = driver.getTitle();
			if (currentWinTitle.equals(titleExpected)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String childWindows : allWindowID) {
			if (!childWindows.equals(parentWindow)) {
				driver.switchTo().window(childWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
	}

	public void backToTopWindow(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void sendKeyDynamicboardToElement(WebDriver driver, Keys key, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, String locatorSource, String locatorTarget) {
		WebElement sourceButton = driver.findElement(By.xpath(locatorSource));
		WebElement targetButton = driver.findElement(By.xpath(locatorTarget));
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceButton, targetButton).build().perform();
	}

	public void drag_the_and_drop_html5_by_xpath(WebDriver driver, String sourceLocator, String targetLocator)
			throws AWTException {

		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));

		Robot robot = new Robot();
		robot.setAutoDelay(500);

		Dimension sourceSize = source.getSize();
		Dimension targetSize = target.getSize();

		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		Point targetLocation = target.getLocation();
		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		sourceLocation.x += 20 + xCentreSource;
		sourceLocation.y += 110 + yCentreSource;
		targetLocation.x += 20 + xCentreTarget;
		targetLocation.y += 110 + yCentreTarget;

		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x,
				((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

		robot.mouseMove(targetLocation.x, targetLocation.y);

		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999);
		return number;
	}

	public void uploadFileBySendkeysSingle(WebDriver driver, String locator, String filePath) {
		WebElement addFileButton = driver.findElement(By.xpath(locator));
		addFileButton.sendKeys(filePath);
	}

	public void uploadFileBySendkeysMulti(WebDriver driver, String locator, String filePath1, String filePath2,
			String filePath3) {
		WebElement addFileButton = driver.findElement(By.xpath(locator));
		addFileButton.sendKeys(filePath1 + "\n" + filePath2 + "\n" + filePath3);
	}

	public void uploadRobot(WebDriver driver, String locatorChrome, String locatorFirefox, String locatorIE,
			String fileNamePath01) throws Exception {

		StringSelection select = new StringSelection(fileNamePath01);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		if (driver.toString().toLowerCase().contains("chrome")) {
			driver.findElement(By.cssSelector(locatorChrome)).click();
		} else if (driver.toString().toLowerCase().contains("firefox")) {
			driver.findElement(By.xpath(locatorFirefox)).click();
		} else if (driver.toString().toLowerCase().contains("internet explorer")) {
			driver.findElement(By.xpath(locatorIE)).click();
		}

		Thread.sleep(1000);

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void uploadAutoIT(WebDriver driver, String locatorChrome, String locatorFirefox, String locatorIE,
			String fileNamePath01) throws Exception {
		if (driver.toString().toLowerCase().contains("chrome")) {
			driver.findElement(By.cssSelector(locatorChrome)).click();
		} else if (driver.toString().toLowerCase().contains("firefox")) {
			driver.findElement(By.xpath(locatorFirefox)).click();
		} else if (driver.toString().toLowerCase().contains("internet explorer")) {
			driver.findElement(By.xpath(locatorIE)).click();
		}
		if (driver.toString().toLowerCase().contains("chrome")) {
			Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\chrome.exe", fileNamePath01 });
		} else if (driver.toString().toLowerCase().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\firefox.exe", fileNamePath01 });
		} else {
			Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\ie.exe", fileNamePath01 });
		}

	}

	public Object executeForBrowser(WebDriver driver, String javaSript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(javaSript);
	}

	public Object clickToElementByJS(WebDriver driver, String locator) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object clickToElementByJS(WebDriver driver, String locator, String... dynamicValue) {
		try {
			locator = String.format(locator, (Object[]) dynamicValue);
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	public Object sendkeyToElementByJS(WebDriver driver, String xpathName, String value) {
		WebElement element = driver.findElement(By.xpath(xpathName));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}


	public Object scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void highlight(WebDriver driver, String xpathName) {
		WebElement element = driver.findElement(By.xpath(xpathName));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public void highlightElement(WebDriver driver, String locator) {
		javascriptExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		String originalStyle = element.getAttribute("style");
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				"border:3px solid red; border-style:dashed;");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javascriptExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element, "style",
				"border:3px solid red; border-style:dashed;", originalStyle);
	}

	public Object removeAttributeInDOM(WebDriver driver, String xpathName, String attribute) {
		WebElement element = driver.findElement(By.xpath(xpathName));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public Object removeAttributeInDOM(WebDriver driver, String locator, String attribute, String... values) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public Object navigateToUrlByJS(WebDriver drive, String url) {
		JavascriptExecutor js = (JavascriptExecutor) drive;
		return js.executeScript("window.location = '" + url + "'");
	}

	public void waitForControlPresence(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constansts.LONG_TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constansts.LONG_TIMEOUT);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
	}

	public void waitForControlVisible(WebDriver driver, String locator, String... dynamicValue) {
		locator = String.format(locator, (Object[]) dynamicValue);
		WebDriverWait wait = new WebDriverWait(driver, Constansts.LONG_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitToElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, Constansts.SHORT_TIMEOUT);
		overrideGlobalTimeout(driver, Constansts.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		overrideGlobalTimeout(driver, Constansts.LONG_TIMEOUT);
	}

	public void waitForControlClickable(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Constansts.LONG_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, Constansts.SHORT_TIMEOUT);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			overrideGlobalTimeout(driver, Constansts.LONG_TIMEOUT);
			return true;
		}
		if (elements.size() > 0 && elements.get(0).isDisplayed()) {
			overrideGlobalTimeout(driver, Constansts.LONG_TIMEOUT);
			return true;

		} else {
			overrideGlobalTimeout(driver, Constansts.LONG_TIMEOUT);
			return false;
		}
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator, String... dynamicValue) {
		overrideGlobalTimeout(driver, Constansts.SHORT_TIMEOUT);
		locator = String.format(locator, (Object[]) dynamicValue);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			overrideGlobalTimeout(driver, Constansts.LONG_TIMEOUT);
			return true;

		} else {
			overrideGlobalTimeout(driver, Constansts.LONG_TIMEOUT);
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void AccepAlertwait(WebDriver driver) {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}

	public String getAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}
	//////
	public void ClickMenuItems(WebDriver driver, String dynamicValue) {
		waitForControlVisible(driver, AbstractPageUI.MENU_ITEMS_LINK, dynamicValue);
		clickToElement(driver, AbstractPageUI.MENU_ITEMS_LINK, dynamicValue);
		
	}
	public void openSytnerPage(WebDriver driver,String SytnerPageUrl) {
		openURL(driver, SytnerPageUrl);
	}


}
