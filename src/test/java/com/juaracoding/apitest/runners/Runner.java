package com.juaracoding.apitest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
    "src/test/resources/features/APIGroup.feature"
}, glue = "com.juaracoding.apitest.definitions")
public class Runner extends AbstractTestNGCucumberTests {

}
