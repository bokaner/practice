package com.login.co;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cookies {
WebDriver driver;

@BeforeTest
public void setup() throws Exception {
driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.get("http://164.100.196.214/MP");
//driver.findElement(By.xpath(".//*[@id='areaAccordion']/div[3]/div[1]/h4/a")).click();
//Thread.sleep(2000);
//driver.findElement(By.xpath(".//*[@id='RTOLogin']/div/div/a")).click();
//Thread.sleep(2000);
 
}

@Test
public void extrctCookie(){
//Get and extract all cookies of google domain and print cookie parameters.
Set<Cookie> totalCookies = driver.manage().getCookies();
System.out.println("Total Number Of cookies : " +totalCookies.size());

for (Cookie currentCookie : totalCookies) {
System.out.println(String.format("%s -> %s -> %s -> %s", "Domain Name : "+currentCookie.getDomain(), "Cookie Name : "+currentCookie.getName(), "Cookie Value : " +currentCookie.getValue(), " Cookie Expiry : "+currentCookie.getExpiry()));
}
}
}