package com.testvagrant;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import static org.apache.http.impl.client.HttpClients.createDefault;

public class WiremockDemo extends BaseTest{

    @Test
    public void WiremockDemoTest() {
        HttpClient httpClient = createDefault();
        HttpGet httpGet = new HttpGet("http://reqres.in/api/users/1");

        // Configure the HTTP client to use WireMock as a proxy
        HttpHost proxy = new HttpHost("localhost", 8080); // Assuming WireMock is running on localhost:8080
        RequestConfig config = RequestConfig.custom()
                .setProxy(proxy)
                .build();
        httpGet.setConfig(config);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity());

            System.out.println(String.format("\n Response from API %s:", httpGet.getURI()));
            System.out.println(responseBody + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
