package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiskInfoTest extends YandexDiskTest {
    @Test
    void getDiskInfoTest() {
        Response resp = client.getDiskInfo();
        assertEquals(200, resp.statusCode(), "Не удалось получить информацию о диске");
    }
}