package models;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseModel extends Driver {
    public String getTitle(){
        return driver.getTitle();
    }

    public String getTextByXpath(String xpath){
        String text= driver.findElement(By.xpath(xpath)).getText();
        return text;
    }
    public void clickByText(String text){
        driver.findElement(By.xpath("//*[text()='"+text+"']")).click();
    }

    public void clickByLintext(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void sendById(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void sendByXpath(String xpath, String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean findElementByXpath(String xpath){
       // return driver.findElement(By.xpath(xpath)) != null;
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }
    public boolean findElementById(String id){
        return driver.findElement(By.id(id)) != null;
    }

    public void clickByClassName(String className) {
        driver.findElement(By.className(className));
    }

    public void sendByName(String name, String value){
        driver.findElement(By.name(name)).sendKeys(value);
    }


}
