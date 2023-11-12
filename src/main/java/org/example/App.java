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
        Thread.sleep(1000);
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("Fahuzoandrei_71");
        WebElement loginButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton2.click();

        if ((driver.findElement(By.xpath("//input[@name='password']")))!= null)
        {
            WebElement passwordField2 = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField2.sendKeys("Fahuzoandrei_71");
            WebElement passwordField3 = driver.findElement(By.xpath("//input[@type='password']"));
            passwordField3.sendKeys("Fahuzoandrei_71");
            WebElement loginButton3 = driver.findElement(By.xpath("//button[@type='submit']"));
            loginButton3.click();
        }
        Thread.sleep(1000);
        WebElement ol = driver.findElement(By.tagName("ol"));
        List<WebElement> liElements = ol.findElements(By.tagName("li"));

        int i=0;

        // Проходим по каждому элементу списка и кликаем на него
        for (WebElement li : liElements) {
            WebElement a = li.findElement(By.tagName("a"));
            a.click();
            try {
                Thread.sleep(1000); // ждать 1 секунду
                File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(screenshot, new File("path_to_save_screenshot" + i + ".png"));
                    i++;
                } catch (IOException e) {
                    //error
                }

                driver.navigate().back();
            } catch (InterruptedException e) {
                // обработка исключения
            }
        }
        // Прокликиваем разделы главной страницы и сохраняем скриншоты
//        String[] sections = {"Моя страница", "Мои друзья", "Мои фотографии"};
//        for (String section : sections) {
//            WebElement sectionLink = driver.findElement(By.linkText(section));
//            sectionLink.click();
//
//        }
//
//        // Размещаем запись на стене
//        WebElement wallPostField = driver.findElement(By.id("post_field"));
//        wallPostField.sendKeys("Я учусь в Учебном центре Netcracker Тольятти https://vk.com/infocom_tlt");
//        WebElement postButton = driver.findElement(By.id("send_post"));
//        postButton.click();
//
//        // Проверяем, что запись появилась на стене
//        WebElement wallPost = driver.findElement(By.xpath("//div[contains(@class, 'wall_post_text')]"));
//        String postText = wallPost.getText();
//        if (postText.equals("Я учусь в Учебном центре Netcracker Тольятти https://vk.com/infocom_tlt")) {
//            System.out.println("Запись успешно размещена на стене");
//        } else {
//            System.out.println("Ошибка размещения записи на стене");
//        }
//
//        // Изменяем личные данные пользователя
//        // ...
//
//        // Проверяем, что изменения вступили в силу
//        // ...
//
//        // Закрываем браузер
//        driver.quit();
    }
}
