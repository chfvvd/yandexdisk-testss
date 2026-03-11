package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yadisk.client.YandexDiskClient;
import yadisk.utils.RandomUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = yadisk.YandexDiskApplication.class)
public class CreateFolderNegativeTest {

    @Autowired
    private YandexDiskClient client;

    @Test
    void cannotCreateFolderThatAlreadyExists() {
        String folderName = RandomUtils.randomFolderName();

        client.createFolder(folderName);

        Response secondCreate = client.createFolder(folderName);
        assertEquals(409, secondCreate.statusCode(), "Ожидался конфликт (409)");
    }

    @Test
    void cannotCreateFolderWithEmptyName() {
        Response resp = client.createFolder("");
        int status = resp.statusCode();
        assertTrue(status == 400 || status == 404, "Ожидался 400 или 404 для пустого имени");
    }

    @Test
    void cannotCreateFolderWithInvalidCharacters() {
        String badName = "////";
        Response resp = client.createFolder(badName);
        int status = resp.statusCode();
        assertTrue(status == 400 || status == 404, "Ожидался 400 или 404 при некорректном имени");
    }
}