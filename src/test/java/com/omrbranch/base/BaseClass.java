package com.omrbranch.base;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseClass {
    RequestSpecification requestSpecification;
    Response response;

    public void addHeader (String headerName, String headerValue) {
        requestSpecification = RestAssured.given ().header (headerName, headerValue);
    }

    public void addHeaders (Headers headers) {
        requestSpecification = RestAssured.given ().headers (headers);
    }

    public void addRequestBody (String body) {
        requestSpecification = requestSpecification.body (body);
    }

    public void addRequestBody (Object body) {
        requestSpecification = requestSpecification.body (body);
    }

    public Response addRequestType (String type, String endPoint) {
        switch (type) {
            case "GET":
                response = requestSpecification.get (endPoint);
                break;
            case "POST":
                response = requestSpecification.post (endPoint);
                break;
            case "PUT":
                response = requestSpecification.put (endPoint);
                break;
            case "DELETE":
                response = requestSpecification.delete (endPoint);
                break;
            case "PATCH":
                response = requestSpecification.patch (endPoint);
                break;
            case "HEAD":
                response = requestSpecification.head (endPoint);
                break;
            case "OPTIONS":
                response = requestSpecification.options (endPoint);
                break;

        }
        return response;
    }

    public static String getProjectPath () {
        String property = System.getProperty ("user.dir");
        return property;

    }

    public static String getPropertyValue (String key) throws IOException, IOException, FileNotFoundException {
        Properties properties = new Properties ();
        properties.load (new FileInputStream (getProjectPath () + "\\config\\config.properties"));
        Object object = properties.get (key);
        String value = (String) object;
        return value;

    }

    public int getStatusCode (Response response) {
        return response.getStatusCode ();
    }

    public String getResponseBodyAsString (Response response) {
        return response.getBody ().asString ();
    }

    public String getResponseBodyAsPrettyString (Response response) {
        return response.getBody ().asPrettyString ();
    }

    public void addBasicAuth (String userName, String password) {
        requestSpecification = RestAssured.given ().auth ().preemptive ().basic (userName, password);
    }

    public void addThreeHeaders (String key1, String value1, String key2, String value2, String key3, String value3) {
        List <Header> headers = new ArrayList <> ();
        headers.add (new Header (key1, value1));
        headers.add (new Header (key2, value2));
        headers.add (new Header (key3, value3));
        addHeaders (new Headers (headers));
    }

    public void addTwoHeaders (String key1, String value1, String key2, String value2) {
        List <Header> headers = new ArrayList <> ();
        headers.add (new Header (key1, value1));
        headers.add (new Header (key2, value2));
        addHeaders (new Headers (headers));
    }

    public void addFormData (String key, File filePath) {
        requestSpecification = requestSpecification.multiPart (key, filePath);
    }

}