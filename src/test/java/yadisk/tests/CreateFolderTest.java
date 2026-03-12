package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import yadisk.utils.RandomUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateFolderTest extends YandexDiskTest {

    @Test
    void createFolderWithFullCheck() {
        String folderName = RandomUtils.randomFolderName();

        Response createResp = client.createFolder(folderName);
        assertEquals(201, createResp.statusCode(), "Папка не создалась");

        Response getResp = client.getResource(folderName);
        assertEquals(200, getResp.statusCode(), "Папка не найдена после создания");

        String returnedPath = getResp.jsonPath().getString("path");

        if (returnedPath.startsWith("disk:")) {
            returnedPath = returnedPath.substring(5);
        }

        if (returnedPath.startsWith("/")) {
            returnedPath = returnedPath.substring(1);
        }

        assertEquals(folderName, returnedPath, "Путь папки отличается");
    }
}