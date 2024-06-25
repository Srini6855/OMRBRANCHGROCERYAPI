package com.omrbranch.stepdefinition;

import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.DatumState;
import com.omrbranch.pojo.address.StateList_Output;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;

public class TC2_StateList_Step extends BaseClass {
    Response response;

    @Given ("User add Headers for the statelist")
    public void user_add_headers_for_the_statelist () {
        addHeader ("accept", "application/json");
    }

    @When ("User send {string} request for statelist endpoint")
    public void user_send_request_for_statelist_endpoint (String requestType) {
        response = addRequestType (requestType, Endpoints.STATELIST);
        System.out.println (getStatusCode (response));
//        System.out.println (getResponseBodyAsPrettyString (response));
    }

    @Then ("User should verify the statelist response message matches {string} and saved state ID")
    public void user_should_verify_the_statelist_response_message_matches_and_saved_state_id (String expectedState) {
        for (DatumState datumState : response.as (StateList_Output.class).getData ()) {
            if (datumState.getName ().equals (expectedState)) {
                int id = datumState.getId ();
                TC1_Login_Step.globalDatas.setStateIdInInteger (id);
                TC1_Login_Step.globalDatas.setStateIdInString (Integer.toString (id));
                Assert.assertEquals ("Verify the statelist response message matches", expectedState, datumState.getName ());
                break;
            }

        }
    }


}