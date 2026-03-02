package org.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {
    public BasePages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void click (By by){
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void type (By by, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
    }

    protected void upload (By by, String path){
        driver.findElement(by).sendKeys(path);
    }
}
