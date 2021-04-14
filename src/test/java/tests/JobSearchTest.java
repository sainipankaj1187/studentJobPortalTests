package tests;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.Constants;

public class JobSearchTest extends BaseClass {

@Test (priority = 1)
public void createJobListing() throws Exception{

        RestAssured.baseURI = baseURL;
        JsonObject reqBody = rb.buildRequestBody(Constants.CREATE_JOB_LISTING_JSON_FILE_PATH);
        RequestSpecification request = rb.buildRequest(reqBody);

        Response response = request.post(Constants.CREATE_API);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        }

@Test (priority = 2)
public void searchJobListing() throws Exception{
        RestAssured.baseURI = baseURL;
        JsonObject reqBody = rb.buildRequestBody(Constants.SEARCH_JOB_LISTINNG_JSONN_FILE_PATH);

        RequestSpecification request = rb.buildRequest(reqBody);

        Response response = request.post(Constants.SEARCH_API);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        }
}
