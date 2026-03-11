package yadisk.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yadisk.config.YandexConfig;

@Component
public class YandexDiskClient {

    @Autowired
    private YandexConfig config;

    public Response getDiskInfo() {
        return RestAssured
                .given()
                .header("Authorization", config.token)
                .get(config.baseUrl);
    }

    public Response createFolder(String path) {
        return RestAssured
                .given()
                .header("Authorization", config.token)
                .queryParam("path", path)
                .put(config.baseUrl + "/resources");
    }

    public Response getResource(String path) {
        return RestAssured
                .given()
                .header("Authorization", config.token)
                .queryParam("path", path)
                .get(config.baseUrl + "/resources");
    }

    public Response deleteFolder(String path) {
        return RestAssured
                .given()
                .header("Authorization", config.token)
                .queryParam("path", path)
                .delete(config.baseUrl + "/resources");
    }
}