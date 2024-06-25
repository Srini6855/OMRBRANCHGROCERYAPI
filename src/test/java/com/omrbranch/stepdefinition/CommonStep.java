package com.omrbranch.stepdefinition;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CommonStep {
    @Then ("User should verify the status code is {int}")
    public void user_should_verify_the_status_code_is (int statusCode) {
        Assert.assertEquals ("Verify the status code", statusCode, TC1_Login_Step.globalDatas.getStatusCode ());
    }
}