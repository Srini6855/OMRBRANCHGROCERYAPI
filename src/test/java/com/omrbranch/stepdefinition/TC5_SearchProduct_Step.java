package com.omrbranch.stepdefinition;

import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payloadobjectmanager.PayLoadManager;
import com.omrbranch.pojo.product.SearchProduct_Output;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class TC5_SearchProduct_Step extends BaseClass {
    Response response;
    PayLoadManager manager = new PayLoadManager ();

    @Given ("User add headers for searching the product")
    public void user_add_headers_for_searching_the_product () {
        addTwoHeaders ("accept", "application/json", "Content-Type", "application/json");
    }

    @When ("User add request body to search {string}")
    public void user_add_request_body_to_search (String productName) {
        addRequestBody (manager.getProductLoad ().searchProduct (productName));
    }

    @When ("User send {string} request for search product endpoint")
    public void user_send_request_for_search_product_endpoint (String requestType) {
        response = addRequestType (requestType, Endpoints.SEARCHPRODUCT);
        System.out.println (getStatusCode (response));
//        System.out.println (getResponseBodyAsPrettyString (response));
    }

    @Then ("User should verify Searchproduct response message matches {string}")
    public void user_should_verify_searchproduct_response_message_matches (String expectedSearchSuccessMessage) {
        Assert.assertEquals ("Verify the search product success message", expectedSearchSuccessMessage, response.as (SearchProduct_Output.class).getMessage ());
    }

}