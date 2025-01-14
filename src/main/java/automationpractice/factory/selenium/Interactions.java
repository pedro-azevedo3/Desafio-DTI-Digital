package automationpractice.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Interactions extends Elements {

    public static void preencherCampo(By by, String text) {
        aguardarElemento(by);
        elemento(by).sendKeys(text);
    }

    public static void clicar(By by) {
        aguardarElemento(by);
        elemento(by).click();
    }

    public static String lerTexto(By by) {
        aguardarElemento(by);
        return elemento(by).getText();
    }

    public static void select(By by, String valor) {
        aguardarElemento(by);
        WebElement selectElement = elemento(by);
        Select select = new Select(selectElement);
        select.selectByValue(valor);
    }

    public static void selectPorIndex(By by, Integer index) {
        aguardarElemento(by);
        WebElement selectElement = elemento(by);
        Select select = new Select(selectElement);
        select.selectByIndex(index);
    }

    public static void limparCampo(By by){
        aguardarElemento(by);
        elemento(by).clear();
    }
}
