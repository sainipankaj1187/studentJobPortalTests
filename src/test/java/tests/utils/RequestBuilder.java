package tests.utils;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import tests.BaseClass;

public class RequestBuilder extends BaseClass {

    public RequestBuilder(){}

    public JsonObject buildRequestBody(String reqSourceFile) throws Exception{
        return jReader.readJSONFiles(reqSourceFile);
    }

    public RequestSpecification buildRequest(JsonObject jObj) throws Exception{
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(jObj.toString());
        return request;
    }
}
