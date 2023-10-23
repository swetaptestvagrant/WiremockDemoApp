package com.testvagrant.utilities;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ProxySettings;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public final class MockServer {
    public static String mockResponse = "{\n" +
            "  \"error\": {\n" +
            "    \"code\": 429,\n" +
            "    \"message\": \"Too Many Requests: You have exceeded the rate limit. Please try again after 1 hour.\",\n" +
            "    \"details\": \"You have made 500 requests within the past 10 minutes. The rate limit is 100 requests per 10 minutes. Please reduce the frequency of your requests.\",\n" +
            "    \"retry_after\": 3600\n" +
            "  }\n" +
            "}";

    private MockServer() {}
    public static WireMockServer startWireMockServer() {
        // Create a WireMock server instance as a proxy
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().bindAddress("localhost")
                .port(8080).proxyVia(ProxySettings.NO_PROXY));
        wireMockServer.start();
        configureWireMock();
        return wireMockServer;
    }

    public static void configureWireMock() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/users/1"))
                .willReturn(WireMock.aResponse()
                        .withStatus(429)
                        .withHeader("Content-Type", "application/json")
                        .withBody(mockResponse)
                )
        );
    }
}
