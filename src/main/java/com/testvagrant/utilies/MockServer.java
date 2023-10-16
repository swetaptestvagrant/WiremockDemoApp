package com.testvagrant.utilies;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ProxySettings;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public final class MockServer {

    private MockServer(){}
    public static WireMockServer startWireMockServer() {
        // Create a WireMock server instance as a proxy
        WireMockServer wireMockServer = new WireMockServer(wireMockConfig().bindAddress("localhost").port(8080).proxyVia(ProxySettings.NO_PROXY));
        wireMockServer.start();
        configureWireMock();
        return wireMockServer;
    }

    public static void configureWireMock() {
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/posts/1"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"userId\": 1, \"id\": 1, \"title\": \"mocked title\", \"body\": \"mocked body\"}")
                )
        );
    }
}
