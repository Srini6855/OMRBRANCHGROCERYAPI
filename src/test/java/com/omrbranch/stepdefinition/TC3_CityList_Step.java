package com.omrbranch.stepdefinition;

import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payloadobjectmanager.PayLoadManager;
import com.omrbranch.pojo.address.CityList_Output;
import com.omrbranch.pojo.address.DatumCity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class TC3_CityList_Step extends BaseClass {
    Response response;
    PayLoadManager manager = new PayLoadManager ();

    @Given ("User add headers for to get citylist")
    public void user_add_headers_for_to_get_citylist () {
        addTwoHeaders ("accept", "application/json", "Content-Type:", "application/json");
    }

    @When ("User add request body stateId for get city list")
    public void user_add_request_body_state_id_for_get_city_list () {
        addRequestBody (manager.getAddressPayload ().addCityPayLoad (TC1_Login_Step.globalDatas.getStateIdInString ()));
    }

    @When ("User send {string} request for citylist endpoint")
    public void user_send_request_for_citylist_endpoint (String requestType) {
        response = addRequestType (requestType, Endpoints.CITYLIST);
        System.out.println (getStatusCode (response));
//        System.out.println (getResponseBodyAsPrettyString (response));
    }

    @Then ("User verify the citylist response message matches {string} and saved city ID")
    public void user_verify_the_citylist_response_message_matches_and_saved_city_id (String expectedCityName) {
        for (DatumCity datumCity : response.as (CityList_Output.class).getData ()) {
            if (datumCity.getName ().equals (expectedCityName)) {
                TC1_Login_Step.globalDatas.setCityIdInInteger (datumCity.getId ());
                Assert.assertEquals ("Verify the statelist response message matches", expectedCityName, datumCity.getName ());
                break;
            }

        }
    }

}