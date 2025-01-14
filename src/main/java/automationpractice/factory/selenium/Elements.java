package automationpractice.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elements extends BrowserService{

    public static WebElement elemento(By by){
        return driver.findElement(by);
    }

    public static void aguardarElemento(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
