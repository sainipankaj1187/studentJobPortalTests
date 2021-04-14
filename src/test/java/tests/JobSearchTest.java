package tests;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.Constants;
import tests.utils.DataProviders;

public class JobSearchTest extends BaseClass {

@Test (priority = 1, dataProvider = "createJobListingDP", dataProviderClass = DataProviders.class)
public void createJobListing(String company, String location, int reqExperience, String description, String type, String contactHR) throws Exception{

        RestAssured.baseURI = baseURL;
        JsonObject reqBody = rb.buildRequestBody(Constants.CREATE_JOB_LISTING_JSON_FILE_PATH);
        reqBody.addProperty("company", company);
        reqBody.addProperty("location", location);
        reqBody.addProperty("reqExperience", reqExperience);
        reqBody.addProperty("description", description);
        reqBody.addProperty("type", type);
        reqBody.addProperty("contactHR", contactHR);

        RequestSpecification request = rb.buildRequest(reqBody);

        Response response = request.post(Constants.CREATE_API);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println("New job listing created with id: "+response.jsonPath().get("id").toString());
        }

@Test (priority = 2, dataProvider = "searchJobListingDP", dataProviderClass = DataProviders.class)
public void searchJobListing(String company, String location) throws Exception{
        RestAssured.baseURI = baseURL;
        JsonObject reqBody = rb.buildRequestBody(Constants.SEARCH_JOB_LISTING_JSON_FILE_PATH);

        JsonObject nestedObj = new JsonObject();
        nestedObj.addProperty("company", company);
        nestedObj.addProperty("location", location);

        reqBody.add("filters", nestedObj);
        RequestSpecification request = rb.buildRequest(reqBody);

        Response response = request.post(Constants.SEARCH_API);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        System.out.println("Jobs found: "+response.getBody().asString());
        }
}
