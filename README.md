# WireMockDemoApp

This project demonstrates a basic implementation of WireMock tool to mock API responses.

BaseTest contains before and after test. 
Before test starts the wiremock server
After Test stops the wiremock server

MockServer starts instance localhost:8080 as proxy

Configure wiremock as per the mock response you need

Configure http client to use wiremock as proxy

Execute http request

Run the test:
mvn test -Dtest=com.testvagrant.WiremockDemo

