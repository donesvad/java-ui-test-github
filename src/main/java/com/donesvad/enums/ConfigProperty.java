package com.donesvad.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConfigProperty {
  BASE_URL("base.url"),
  BROWSER("browser"),
  HEADLESS("headless"),
  USERNAME("test.username"),
  PASSWORD("test.password");

  private final String value;
}
