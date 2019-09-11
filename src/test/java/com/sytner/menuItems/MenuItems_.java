package com.sytner.menuItems;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.MenuItemsPageObject;
import pageObjects.PageFactoryManager;

public class MenuItems_ extends AbstractTest{
	private WebDriver driver;
	public MenuItemsPageObject MenuItemsPage;
	public  String SytnerPageUrl;
	@Test
	public void MenuItems_001_AboutUs(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 02: Click on About us menu item");
		MenuItemsPage.ClickMenuItems(driver, "About Us");
		MenuItemsPage.getCurrenUrl(driver);
		System.out.println(MenuItemsPage.getCurrenUrl(driver));
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_002_News(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on News menu item");
		MenuItemsPage.ClickMenuItems(driver, "News");
		
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_003_CustemerService(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Customer Service menu item");
		MenuItemsPage.ClickMenuItems(driver, "Customer Service");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_004_Careers(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Careers menu item");
		MenuItemsPage.ClickMenuItems(driver, "Careers");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_005_Finance(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Finance menu item");
		MenuItemsPage.ClickMenuItems(driver, "Finance");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_006_Finance(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Finance menu item");
		MenuItemsPage.ClickMenuItems(driver, "Finance");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_007_UsedCarSearch(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Used Car Search menu item");
		MenuItemsPage.ClickMenuItems(driver, "Used Car Search");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_008_NewCars(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on New Cars menu item");
		MenuItemsPage.ClickMenuItems(driver, "New Cars");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_009_CarMaintenance(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Car Maintenance menu item");
		MenuItemsPage.ClickMenuItems(driver, "Car Maintenance");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_010_Promotions(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		//MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Promotions menu item");
		
	// hiện tại ko có CT KM
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_011_BusinessUsers(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Business Users menu item");
		MenuItemsPage.ClickMenuItems(driver, "Business Users");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_012_SellYourCar(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on SellYour Car menu item");
		MenuItemsPage.ClickMenuItems(driver, "SellYour Car");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_013_DealerLocator(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Dealer Locator menu item");
		MenuItemsPage.ClickMenuItems(driver, "Dealer Locator");
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Test
	public void MenuItems_014_HomeIcon(Method testMethod) {
		log.info("============== START: " + testMethod.getName() + " ============== ");

		log.info("Step 01: Open Sytner site");
		MenuItemsPage.openSytnerPage(driver, SytnerPageUrl);
		
		log.info("Step 02: Click on Dealer Locator menu item");
		MenuItemsPage.ClickMenuItems(driver, "Dealer Locator");
		
		log.info("Step 03: Click on Home Icon menu item");
		
	
		log.info("============== AND: " + testMethod.getName() + " ============== ");
	}
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		log.info("============== START: LOGIN ============== ");
		driver = opentMultiBrowser(browserName);
		MenuItemsPage = PageFactoryManager.getMenuItemsPage(driver);
		SytnerPageUrl=MenuItemsPage.getCurrenUrl(driver);
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}
}
