package com.omrbranch.stepdefinition;

import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.profilepic.ChangeProfilePic_Output;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

public class TC6_ChangeProfilePic_Step extends BaseClass {
    Response response;

    @Given ("User add headers and bearer authorization for accesing ChangeProfilePic endpoints")
    public void user_add_headers_and_bearer_authorization_for_accesing_change_profile_pic_endpoints () {
        addThreeHeaders ("accept", "application/json", "Authorization", "Bearer " + TC1_Login_Step.globalDatas.getLogToken (), "Content-Type", "multipart/form-data");
    }

    @When ("User add-formData and initialize the file location")
    public void user_add_form_data_and_initialize_the_file_location () {
        addFormData ("profile_picture", new File ("C:\\Users\\SRINIVASU\\IdeaProjects\\OMRBranchGroceryApiAutomation\\images\\Photo.jpg"));
    }

    @When ("User send {string} request for change profile picture endpoint")
    public void user_send_request_for_change_profile_picture_endpoint (String requestType) {
        response = addRequestType (requestType, Endpoints.CHANGEPROFILEPIC);
        System.out.println (getStatusCode (response));
//        System.out.println (getResponseBodyAsPrettyString (response));
    }

    @Then ("User verify the Change Profile Picture response message matches with {string}")
    public void user_verify_the_change_profile_picture_response_message_matches_with (String expectedSuccessMessage) {
        Assert.assertEquals ("Verify the change profile picture success message", expectedSuccessMessage, response.as (ChangeProfilePic_Output.class).getMessage ());
    }

}