package com.testvagrant;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.testvagrant.utilities.MockServer;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WireMockServer wireMockServer;
    protected BaseTest() {}

    @BeforeMethod
    public void init(){
        wireMockServer = MockServer.startWireMockServer();
    }

    @AfterMethod
    public void tearDown(){
        wireMockServer.stop();
    }
}
