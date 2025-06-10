package com.juaracoding.apitest.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hook {
  @BeforeAll
  public static void initialize() {
    System.out.println("BeforeAll jalan");
  }

  @AfterAll
  public static void finalTeardown() {
    System.out.println("AfterAll jalan");
  }
}
