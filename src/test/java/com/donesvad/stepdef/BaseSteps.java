package com.donesvad.stepdef;

import static com.donesvad.enums.ConfigProperty.BASE_URL;

import com.donesvad.util.ConfigManager;
import lombok.Getter;

@Getter
public class BaseSteps {

  private final String baseUrl = ConfigManager.get(BASE_URL);
}
