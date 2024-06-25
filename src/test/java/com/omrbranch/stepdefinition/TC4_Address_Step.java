package com.omrbranch.stepdefinition;

import com.omrbranch.base.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payloadobjectmanager.PayLoadManager;
import com.omrbranch.pojo.address.AddAddress_Output;
import com.omrbranch.pojo.address.DeleteAddress_Output;
import com.omrbranch.pojo.address.GetAddress_Output;
import com.omrbranch.pojo.address.UpdateAddress_output;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class TC4_Address_Step extends BaseClass {
    Response addResponse;
    Response updateResponse;
    Response getResponse;
    Response deleteResponse;
    PayLoadManager manager = new PayLoadManager ();

    @Given ("User add headers and bearer authorization for accesing address endpoints")
    public void user_add_headers_and_bearer_authorization_for_accesing_address_endpoints () {
        addThreeHeaders ("accept", "application/json", "Authorization", "Bearer " + TC1_Login_Step.globalDatas.getLogToken (), "Content-Type", "application/json");

    }

    @When ("User add requestbody for AddNewAddress {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
    public void user_add_requestbody_for_add_new_address (String firstName, String lastName, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
        addRequestBody (manager.getAddressPayload ().addAddressPayLoad (firstName, lastName, mobile, apartment, TC1_Login_Step.globalDatas.getStateIdInInteger (), TC1_Login_Step.globalDatas.getCityIdInInteger (), Integer.parseInt (country), zipcode, address, address_type));
    }

    @When ("User send {string} request for adduseraddress endpoint")
    public void user_send_request_for_adduseraddress_endpoint (String requestType) {
        addResponse = addRequestType (requestType, Endpoints.ADDUSERADDRESS);
        System.out.println (getStatusCode (addResponse));
//        System.out.println (getResponseBodyAsPrettyString (addResponse));
    }

    @Then ("User should verify adduseraddress response message matches {string} and save the addressId")
    public void user_should_verify_adduseraddress_response_message_matches (String expectedAddAddressMessage) {
        Assert.assertEquals ("Verify the add user address success message", expectedAddAddressMessage, addResponse.as (AddAddress_Output.class).getMessage ());
        TC1_Login_Step.globalDatas.setAddressId (Integer.toString (addResponse.as (AddAddress_Output.class).getAddress_id ()));
    }

    @Given ("User add headers and bearer authorization for accesing Updateadddress endpoints")
    public void user_add_headers_and_bearer_authorization_for_accesing_updateadddress_endpoints () {
        addThreeHeaders ("accept", "application/json", "Authorization", "Bearer " + TC1_Login_Step.globalDatas.getLogToken (), "Content-Type", "application/json");
    }

    @When ("User add requestbody for UpdateNewAddress {string}, {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_add_requestbody_for_update_new_address (String addressId, String firstName, String lastName, String mobile, String apartment, String state, String city, String country, String zipcode, String address, String address_type) {
        addRequestBody (manager.getAddressPayload ().updateAddressPayLoad (TC1_Login_Step.globalDatas.getAddressId (), firstName, lastName, mobile, apartment, TC1_Login_Step.globalDatas.getStateIdInInteger (), TC1_Login_Step.globalDatas.getCityIdInInteger (), Integer.parseInt (country), zipcode, address, address_type));
    }

    @When ("User send {string} request for AddUserAddress endpoint")
    public void user_send_request_for_add_user_address_endpoint (String requestType) {
        updateResponse = addRequestType (requestType, Endpoints.UPDATEUSERADDRESS);
        System.out.println (getStatusCode (updateResponse));
//        System.out.println (getResponseBodyAsPrettyString (updateResponse));
    }

    @Then ("User should verify update-address response message matches {string}")
    public void user_should_verify_update_address_response_message_matches (String expectedUpdateAddressMessage) {
        Assert.assertEquals ("Verify the update address success message", expectedUpdateAddressMessage, updateResponse.as (UpdateAddress_output.class).getMessage ());
    }

    @Given ("User add headers and bearer authorization for accesing Getadddress endpoints")
    public void user_add_headers_and_bearer_authorization_for_accesing_getadddress_endpoints () {
        addTwoHeaders ("accept", "application/json", "Authorization", "Bearer " + TC1_Login_Step.globalDatas.getLogToken ());
    }

    @When ("User send {string} request for GetUserAddress endpoint")
    public void user_send_request_for_get_user_address_endpoint (String requestType) {
        getResponse = addRequestType (requestType, Endpoints.GETUSERADDRESS);
        System.out.println (getStatusCode (getResponse));
//        System.out.println (getResponseBodyAsPrettyString (getResponse));
    }

    @Then ("User should verify getuseraddress response message matches {string}")
    public void user_should_verify_getuseraddress_response_message_matches (String expectedGetAddressMessage) {
        Assert.assertEquals ("Verify the get address success message", expectedGetAddressMessage, getResponse.as (GetAddress_Output.class).getMessage ());
    }

    @Given ("User add headers and bearer authorization for accesing Deleteadddress endpoints")
    public void user_add_headers_and_bearer_authorization_for_accesing_deleteadddress_endpoints () {
        addThreeHeaders ("accept", "application/json", "Authorization", "Bearer " + TC1_Login_Step.globalDatas.getLogToken (), "Content-Type", "application/json");
    }

    @When ("User add request body for address ID")
    public void user_add_request_body_for_address_id () {
        addRequestBody (manager.getAddressPayload ().deleteAddressPayLoad (TC1_Login_Step.globalDatas.getAddressId ()));
    }

    @When ("User send {string} request for DeleteAddress endpoint")
    public void user_send_request_for_delete_address_endpoint (String requestType) {
        deleteResponse = addRequestType (requestType, Endpoints.DELETEUSERADDRESS);
        System.out.println (getStatusCode (deleteResponse));
//        System.out.println (getResponseBodyAsPrettyString (deleteResponse));
    }

    @Then ("User should verify DeleteAddress response message matches {string}")
    public void user_should_verify_delete_address_response_message_matches (String expectedDeleteAddressMessage) {
        Assert.assertEquals ("Verify the delete address success message", expectedDeleteAddressMessage, deleteResponse.as (DeleteAddress_Output.class).getMessage ());
    }


}