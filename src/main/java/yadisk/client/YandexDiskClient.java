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
                .header("Authorization", config.getToken())
                .get(config.getBaseUrl());
    }

    public Response createFolder(String path) {
        return RestAssured
                .given()
                .header("Authorization", config.getToken())
                .queryParam("path", path)
                .put(config.getBaseUrl() + "/resources");
    }

    public Response getResource(String path) {
        return RestAssured
                .given()
                .header("Authorization", config.getToken())
                .queryParam("path", path)
                .get(config.getBaseUrl() + "/resources");
    }

    public Response deleteFolder(String path) {
        return RestAssured
                .given()
                .header("Authorization", config.getToken())
                .queryParam("path", path)
                .delete(config.getBaseUrl() + "/resources");
    }
}