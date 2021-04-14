package tests.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider (name = "createJobListingDP")
    public Object[][] createJobListingDP(){
        return new Object[][]{{"Flipkart","Bangalore",5,"random job hai","Permanent","9988776655"},
                {"Microsoft","Delhi",10,"good one","Intern","887353465"},
                {"IBM","Mumbai",8,"time pass","Intern Max","885453465"}};
    }

    @DataProvider (name = "searchJobListingDP")
    public Object[][] searchJobListingDP(){
        return new Object[][]{{"Flipkart", "Bangalore"},
                {null,null},
                {"Microsoft",null},
                {null,"Delhi"}};
    }
}
