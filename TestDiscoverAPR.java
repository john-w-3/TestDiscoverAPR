package com.jw3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDiscoverAPR {

    @Test
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // locator definitions
        By creditCardsIcon = By.cssSelector("#main-content-rwd > div > div > div.midnav.aem-GridColumn.aem-GridColumn--default--12 > div.domain-carousel > div.secondary-nav-bar.carousel__track-container > ul > li.carousel__slide.current-slide > a");
        By securedCreditCardApplyNow = By.cssSelector("#siteframe > div > div.root.responsivegrid > div > div.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 > div > div:nth-child(6) > div > div > div.cmp-container.cards-offer-comp.cmp-container__size-3 > div.slider-cchp > div.cmp-container__column.cmp-container__column-3.cmp-container-3 > div:nth-child(2)");
        By skipThisStep = By.cssSelector("#adaptive-skip-this-step");
        By wereSorryText = By.xpath("//*[text()='We\'re sorry']");

        // test starts here
        driver.get("http://www.discover.com");

        // click Credit Cards icon
        wait.until(ExpectedConditions.elementToBeClickable(creditCardsIcon));
        driver.findElement(creditCardsIcon).click();

        // click Apply Now in Secured Credit Card seciton
        wait.until(ExpectedConditions.elementToBeClickable(securedCreditCardApplyNow));
        driver.findElement(securedCreditCardApplyNow).click();

        // click Skip This Step to skip pre-fill
        wait.until(ExpectedConditions.elementToBeClickable(skipThisStep));
        driver.findElement(skipThisStep).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(wereSorryText));

        // There is an error on the website (reproducible manually) with a We're Sorry message after clicking Skip This Step.
        // Unable to assert APR value.
    
        // assertTrue("APR is greater than 20%"", aprValue > 20);

        driver.quit();

    }
}