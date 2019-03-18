package com.foresee.ssfm.rest;

import com.foresee.icap.framework.rest.RestRequestBuilder;
import com.foresee.ssfm.qo.DemoUserQO;
import com.google.gson.Gson;
import org.springframework.http.MediaType;

public class ChenesTest {
    public static void main(String[] args) {
        Gson gson = new Gson();

        DemoUserQO demoUserDTO=new DemoUserQO();
        demoUserDTO.setUserId(4444444444L);
        demoUserDTO.setUserName("Chenes");
        RestRequestBuilder mockRestRequest = RestRequestBuilder.create("100010001").post("/back/testservice/testparam").userId("111111111111")
                .body(demoUserDTO).contentType(MediaType.APPLICATION_JSON_UTF8);

        System.out.println(gson.toJson(mockRestRequest));
    }
}
