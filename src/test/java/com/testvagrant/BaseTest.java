package com.testvagrant;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.testvagrant.utilities.MockServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WireMockServer wireMockServer;
    protected BaseTest() {}

    //Start the mock server
    @BeforeMethod
    public void init(){
        wireMockServer = MockServer.startWireMockServer();
    }

    //Stop the mock server
    @AfterMethod
    public void tearDown(){
        wireMockServer.stop();
    }
}
