package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.utils.Constants;
import tests.utils.JsonFileReader;
import tests.utils.RequestBuilder;

public class BaseClass {

    public static JsonFileReader jReader;
    public static String baseURL;
    public RequestBuilder rb;

    @BeforeSuite
    public void BaseClass() {
        jReader = new JsonFileReader();
        baseURL = Constants.BASE_URL;
        rb = new RequestBuilder();
    }

    @AfterSuite
    public void afterSuite(){

    }
}
