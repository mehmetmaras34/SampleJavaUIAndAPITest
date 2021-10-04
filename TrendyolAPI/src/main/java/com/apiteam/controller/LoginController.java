package com.apiteam.controller;

import com.apiteam.model.request.LoginRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
     private String basePath="/api";
     BaseController baseController;
     public LoginController(){
         super();
         baseController=new BaseController(requestSpecification());
     }
     public RequestSpecification requestSpecification(){
         RequestSpecification requestSpecification=new RequestSpecBuilder()
                 .setBaseUri("API_URL")
                 .setBasePath(basePath)
                 .build();
         return requestSpecification;
     }
     public String getToken(){
         LoginRequest loginRequest= LoginRequest.builder()
                 .username("Mehmet")
                 .password("Trabzon61")
                 .build();
         return baseController.postRequest(loginRequest,"/login").jsonPath().get("token");
     }

}
