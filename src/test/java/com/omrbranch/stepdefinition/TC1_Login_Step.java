package com.omrbranch.stepdefinition;

import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globaldatas.GlobalDatas;
import com.omrbranch.pojo.login.Login_Output;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class TC1_Login_Step extends BaseClass {
    Response response;
    static GlobalDatas globalDatas = new GlobalDatas ();

    @Given ("User add header")
    public void user_add_header () {
        addHeader ("accept", "application/json");
    }

    @When ("User add basic authentication for login")
    public void user_add_basic_authentication_for_login () {
        addBasicAuth ("srinipmps@gmail.com", "abEuKW6S@asg3Nv");
    }

    @When ("User send {string} request for login endpoint")
    public void user_send_request_for_login_endpoint (String requestType) {
        response = addRequestType (requestType, Endpoints.LOGIN);
        System.out.println (getStatusCode (response));
//        System.out.println (getResponseBodyAsPrettyString (response));
        globalDatas.setStatusCode (getStatusCode (response));

    }


    @Then ("User should verify the login response body First_name present as {string} and get the log-token saved")
    public void user_should_verify_the_login_response_body_first_name_present_as_and_get_the_log_token_saved (String expectedFirstName) {
        Assert.assertEquals ("Verifying the first name", expectedFirstName, response.as (Login_Output.class).getData ().getFirst_name ());
        TC1_Login_Step.globalDatas.setLogToken (response.as (Login_Output.class).getData ().getLogtoken ());
    }


}