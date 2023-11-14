package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
        loginField.sendKeys("Вставьте логин");



        // Нажимаем кнопку входа
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("Пароль");
        WebElement loginButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton2.click();
        Thread.sleep(2000);
        if ((driver.findElement(By.xpath("//input[@name='password']")))!= null)
        {
            WebElement passwordField2 = driver.findElement(By.xpath("//input[@name='password']"));
            passwordField2.sendKeys("Пароль");
            WebElement passwordField3 = driver.findElement(By.xpath("//input[@name='password_confirm']"));
            passwordField3.sendKeys("Пароль");
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

//         Проходим по каждому элементу меню, переходим на страницу и делаем скриншот

        for (WebElement menuItem : menuItems)
        {
            if (i==2) {
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
        WebElement myPage = driver.findElement(By.partialLinkText("Моя страница"));
        myPage.click();
        Thread.sleep(2000);
        WebElement postField = driver.findElement(By.id("post_field"));
        postField.sendKeys("Я учусь в Учебном центре Netcracker Тольятти https://vk.com/infocom_tlt");
        Thread.sleep(3000);
        WebElement submit = driver.findElement(By.id("send_post"));
        submit.click();
        driver.navigate().refresh();
        String text = "Я учусь в Учебном центре Netcracker Тольятти https://vk.com/infocom_tlt";
        try {
            Thread.sleep(1000);
//           driver.findElement(By.partialLinkText("Я учусь в Учебном центре Netcracker Тольятти https://vk.com/infocom_tlt"));
            WebElement post = driver.findElement(By.className("wall_post_text"));
            if (Objects.equals(post.getText(), text)){
                System.out.println("Текст с постом");
            }

        } catch (NoSuchElementException e) {
            System.out.println("Нет текста с постом");
        }

        driver.navigate().to("https://vk.com/edit");
        Thread.sleep(2000);
        WebElement aboutMe = driver.findElement(By.id("pedit_general_short_information"));
        aboutMe.sendKeys("developer");
        WebElement save = driver.findElement(By.className("FlatButton__content"));
        save.click();
        Thread.sleep(2000);
        WebElement myPage2 = driver.findElement(By.partialLinkText("Моя страница"));
        myPage2.click();
        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//span[contains(text(), 'developer')]"));
            System.out.println("Статус есть");
        } catch (NoSuchElementException e) {
            System.out.println("Нет статуса");
        }
        driver.quit();
    }
}
