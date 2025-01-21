package com.donesvad.util;

import java.lang.reflect.Method;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

@Slf4j
public class CustomWebDriverListener implements WebDriverListener {

    @Override
    public void beforeClick(WebElement element) {
        log.info("About to click an element {}", element);
    }

    @Override
    public void beforeGet(WebDriver driver, String url) {
        log.info("About to open a page {}", url);
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        log.info("Element {} has text '{}'", element, result);
    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {
        log.debug("About to find an element in {} by locator {}", element, locator);
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        log.info("Element {} was found by locator {}", result, locator);
    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {
        log.debug("About to find some elements in {} by locator {}", element, locator);
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        log.info("Number of found elements: {} by locator {}", result.size(), locator);
    }

    @Override
    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
        log.trace("About to call a method {} in element {} with parameters {}",
                  method, element, args);
    }

    @Override
    public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
        log.trace("Method {} called in element {} with parameters {} returned {}",
                  method, element, args, result);
    }
}
