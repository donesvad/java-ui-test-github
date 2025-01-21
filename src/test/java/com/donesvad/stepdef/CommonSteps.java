package com.donesvad.stepdef;

import static com.codeborne.selenide.Selenide.page;
import static com.donesvad.util.ReflectionUtil.findAllClassesUsingClassLoader;
import static com.donesvad.util.ReflectionUtil.toUpperCamelCase;

import com.donesvad.page.BasePage;
import io.cucumber.java.en.Then;
import java.util.Map;
import lombok.Getter;

@Getter
public class CommonSteps extends BaseSteps {

  private final Map<String, Class<?>> allClassesUsingClassLoader =
      findAllClassesUsingClassLoader("com.donesvad.page");

  @Then("user is on {string} page")
  public void userIsOnPage(String pageName) {
    String className = toUpperCamelCase(pageName + " page".toLowerCase(), true);
    Class<? extends BasePage> aClass =
        (Class<? extends BasePage>) allClassesUsingClassLoader.get(className);
    BasePage page = page(aClass);
    page.isLoaded();
  }
}
