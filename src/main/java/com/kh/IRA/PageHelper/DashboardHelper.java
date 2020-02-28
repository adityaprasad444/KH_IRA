package com.kh.IRA.PageHelper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.Pages.DashboardPage;
import com.kh.IRA.TestBase.TestBase;

public class DashboardHelper extends TestBase {

	public static DashboardPage dp;

	public DashboardHelper() {
		dp=new DashboardPage();
		asrt=new SoftAssert();
	}

	public void verifyDashboard() {
		WebElement dash=driver.findElement(By.xpath(dp.getDashboard()));
		List<WebElement> Dashlinks= dash.findElements(By.tagName("a"));
		for (int i=0;i<Dashlinks.size();i++) {
			String Text=Dashlinks.get(i).getText();
			try {
				highlightElement(driver, driver.findElement(By.linkText(Text)));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.linkText(Text)).click();
			String urlappend=Dashlinks.get(i).getAttribute("href");
			asrt.assertEquals(driver.getCurrentUrl(), urlappend);
			asrt.assertAll();
		}}

	public static void logout() {
		try {
			highlightElement(driver, driver.findElement(By.xpath(dp.getLogout())));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath(dp.getLogout())).click();
	}
}