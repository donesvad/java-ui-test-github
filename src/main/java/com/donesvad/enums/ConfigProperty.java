package com.donesvad.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ConfigProperty {
  BASE_URL("base.url"),
  BROWSER("browser");

  private final String value;
}
