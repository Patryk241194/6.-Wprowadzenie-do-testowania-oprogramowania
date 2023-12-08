package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_ACCEPT_COOKIES_BUTTON = "//div[contains(@class, '_al64')]/button[2]";
    public static final String XPATH_CREATE_NEW_ACCOUNT_BUTTON = "//div[@class='_6ltg']//a[@data-testid='open-registration-form-button']";
    public static final String XPATH_WAIT_FOR = "//div[contains(@class, '_8fgl') and contains(@class, '_9l2p')]";
    public static final String XPATH_SELECT_BIRTH_DAY = "//div[contains(@class, '_5k_5')]/span[1]/span/select[1]";
    public static final String XPATH_SELECT_BIRTH_MONTH = "//div[contains(@class, '_5k_5')]/span[1]/span/select[2]";
    public static final String XPATH_SELECT_BIRTH_YEAR = "//div[contains(@class, '_5k_5')]/span[1]/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES_BUTTON)).click();
        driver.findElement(By.xpath(XPATH_CREATE_NEW_ACCOUNT_BUTTON)).click();

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_WAIT_FOR)));

        WebElement selectCombo1 = driver.findElement(By.xpath(XPATH_SELECT_BIRTH_DAY));
        Select selectBoard1 = new Select(selectCombo1);
        selectBoard1.selectByIndex(23);

        WebElement selectCombo2 = driver.findElement(By.xpath(XPATH_SELECT_BIRTH_MONTH));
        Select selectBoard2 = new Select(selectCombo2);
        selectBoard2.selectByIndex(10);

        WebElement selectCombo3 = driver.findElement(By.xpath(XPATH_SELECT_BIRTH_YEAR));
        Select selectBoard3 = new Select(selectCombo3);
        selectBoard3.selectByIndex(29);

    }
}
