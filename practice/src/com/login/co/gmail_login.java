package com.login.co;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class gmail_login {
  
WebDriver driver;
String name="";


@BeforeMethod
public void openurl()throws InterruptedException
{
   // Scanner in = new Scanner(System.in);
  //  System.out.println("Enter the gmail id: ");
  //  String emailId = in.next();
  //  System.out.println("Enter the pass: ");
 //   String pass = in.next();
  
    driver = new FirefoxDriver(); //open firefox browser
  
    //login to gmail
    driver.get("http://www.gmail.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    driver.findElement(By.name("Email")).sendKeys("ujji.sharma@gmail.com");
    driver.findElement(By.xpath("//input[@id='next']")).click();
    driver.findElement(By.name("Passwd")).sendKeys("");
   driver.findElement(By.xpath("//input[@id='signIn']")).click();
  //  driver.findElement(By.xpath(".//*[@id=':lx']")).sendKeys("vivajain1986@gmail.com");
    
    List<WebElement> chatboxsize = driver.findElements(By.xpath("//table[@class='vH']/tbody"));
    System.out.println("number of people in the gmail chat: "+chatboxsize.size());
    String name="";
    for (int i=1; i <=chatboxsize.size(); i++)
    {
        name = driver.findElement(By.xpath("//table[@class='vH']/tbody["+i+"]/tr[1]//span[1]")).getAttribute("textContent");
        System.out.println(name);
   }
    
    
}
@Test
public void chatlist() throws InterruptedException
{
   /* List<WebElement> chatboxsize = driver.findElements(By.xpath("//table[@class='vH']/tbody"));
    System.out.println("number of people in the gmail chat: "+chatboxsize.size());
    String name="";
    for (int i=1; i <=chatboxsize.size(); i++)
    {
        name = driver.findElement(By.xpath("//table[@class='vH']/tbody["+i+"]/tr[1]//span[1]")).getAttribute("textContent");
        System.out.println(name);
   }*/
    
    try {
        List<WebElement> offline = driver.findElements(By.xpath("//tr[td[img[@alt='Offline']]]//td[2]/span[1]"));
        System.out.println("number of friends offline in the gmail chat: "+offline.size());
        if(offline.size()!=0){
            System.out.println("Name of the friends offline: ");
        }
        for (int i=0; i <offline.size(); i++)
        {
            name = offline.get(i).getAttribute("textContent");
            System.out.println((i+1)+") "+name);
        }
    } catch (NoSuchElementException e) {
        System.out.println("No one is offline.");
    }
}
@AfterMethod
public void closeBrowser(){
    driver.close();
}
}