package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiskInfoTest extends YandexDiskTest {
    @Test
    @DisplayName("Должен получить информацию о диске")
    void shouldGetDiskInfoTest() {
        Response resp = client.getDiskInfo();
        assertEquals(200, resp.statusCode(), "Не удалось получить информацию о диске");
    }
}