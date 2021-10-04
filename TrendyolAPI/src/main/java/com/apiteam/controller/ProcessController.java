package com.apiteam.controller;

import com.apiteam.model.request.LoginRequest;
import com.apiteam.model.response.ResultResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class ProcessController {
    private String basePath="/api/";
    BaseController baseController;
    LoginController loginController;

    public ProcessController(LoginController loginController){
        super();
        this.loginController=loginController;
        baseController=new BaseController(requestSpecification());
    }
    public RequestSpecification requestSpecification(){
        RequestSpecification requestSpecification=new RequestSpecBuilder()
                .setBaseUri("API_URL")
                .setBasePath(basePath)
                .build().header("Authorization",loginController.getToken());
        return requestSpecification;
    }
    public ResultResponse postResultResponse(Integer number1, Integer number2,String param){
        return baseController.postRequest(number1,number2,param).as(ResultResponse.class);
    }
    public ResultResponse getResultResponse(Integer number,String param){
        return baseController.getRequest(number,param).as(ResultResponse.class);
    }
}
