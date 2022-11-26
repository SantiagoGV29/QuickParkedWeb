package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.InputSource;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class AppTest 
{
    WebDriver browser;
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/elpad/Desktop/S6/Desarrollo Web/v2/PARCIAL/partialWebDevelopment/traslav5/parcial/src/test/resources/chromedriver.exe");
        browser=new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("http://localhost:4200");
    }

    @Test
    public void testAgregar() throws InterruptedException
    {
        try{
            WebElement botonInicio=browser.findElement(By.id("botonHome"));Thread.sleep(500);
            Thread.sleep(500);
            botonInicio.click();
            browser.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        }catch (Exception e){
            fail();
        }

        try{
            WebElement user = browser.findElement(By.id("inputUserName"));
            WebElement pass = browser.findElement(By.id("inputPassword"));
            WebElement botonInicio=browser.findElement(By.id("loginBtn"));
            Thread.sleep(500);
            user.sendKeys("john");
            Thread.sleep(500);
            pass.sendKeys("12345");
            Thread.sleep(500);
            botonInicio.click();
            browser.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        }catch (Exception e){
            fail();
        }

    }
}
