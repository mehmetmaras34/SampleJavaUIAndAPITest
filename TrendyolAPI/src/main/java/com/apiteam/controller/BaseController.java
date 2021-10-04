package com.apiteam.controller;

import static io.restassured.RestAssured.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class BaseController {
    private RequestSpecification spec;
    Gson gson=new GsonBuilder().create();

    public BaseController(RequestSpecification requestSpecification){
        this.spec=requestSpecification;
    }

    protected Response postRequest(Object body,String endPoint){
        Response response= given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(gson.toJson(body))
                .when()
                .post(endPoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        return response;
    }
    protected Response postRequest(Integer number1,Integer number2,String param){
        Response response= given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .queryParams(param,number1,number2)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        return response;
    }
    protected Response getRequest(Integer number,String param){
        Response response= given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .queryParam(param,number)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        return response;
    }
}
