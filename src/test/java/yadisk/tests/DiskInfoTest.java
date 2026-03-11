package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yadisk.client.YandexDiskClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = yadisk.YandexDiskApplication.class)
public class DiskInfoTest {

    @Autowired
    private YandexDiskClient client;

    @Test
    void getDiskInfoTest() {
        Response resp = client.getDiskInfo();
        assertEquals(200, resp.statusCode(), "Не удалось получить информацию о диске");
    }
}