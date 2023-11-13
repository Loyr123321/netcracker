package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://vk.com/feed");

        WebElement loginField = driver.findElement(By.id("index_email"));
        loginField.sendKeys("shev4enko.andrey-ru@yandex.ru");



        // Нажимаем кнопку входа
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("Fahuzoandrei_71");
        WebElement loginButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton2.click();
        Thread.sleep(2000);
        if ((driver.findElement(By.xpath("//input[@name='password']")))!= null)
        {
            WebElement passwordField2 = driver.findElement(By.xpath("//input[@name='password']"));
            passwordField2.sendKeys("Fahuzoandrei_71");
            WebElement passwordField3 = driver.findElement(By.xpath("//input[@name='password_confirm']"));
            passwordField3.sendKeys("Fahuzoandrei_71");
            WebElement loginButton3 = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton3.click();
        }
        Thread.sleep(2000);
        WebElement ol = driver.findElement(By.tagName("ol"));
        List<WebElement> liElements = ol.findElements(By.tagName("li"));

        int i=0;

        // Проходим по каждому элементу списка и кликаем на него
        WebElement menu = driver.findElement(By.className("LeftMenuOld-module__container--tHFVR"));
        List<WebElement> menuItems = menu.findElements(By.tagName("a"));

        // Проходим по каждому элементу меню, переходим на страницу и делаем скриншот

        for (WebElement menuItem : menuItems)
        {
            if (i==8) {
            break;
            }
                menuItem.click();
                Thread.sleep(2000);
                File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshotFile, new File("screenshot_" + menuItem.getText() + ".png"));
                } catch (IOException e) {
                    // обработка исключения
                }
            i++;
        }







        driver.quit();
    }
//    private static void navigateAndCaptureScreenshots(WebDriver driver) {
//        // Пример: переход на страницу "Мои друзья" и сохранение скриншота
//        driver.get("https://vk.com/friends");
//        WebElement olElement = driver.findElement(By.xpath("//nav//ol"));
//        list = ()olElement.findElements(By.tagName("li"));
//        takeScreenshot(driver, "MyFriends");
//
//        // Повторите этот блок для других разделов
//    }
    private static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("путь_к_папке/" + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
