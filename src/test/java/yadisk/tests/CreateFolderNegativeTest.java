package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yadisk.utils.RandomUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateFolderNegativeTest extends YandexDiskTest {

    @Test
    @DisplayName("Не должен создать папку увидив конфликт")
    void cannotCreateFolderThatAlreadyExists() {
        String folderName = RandomUtils.randomFolderName();

        client.createFolder(folderName);

        Response secondCreate = client.createFolder(folderName);
        assertEquals(409, secondCreate.statusCode(), "Ожидался конфликт (409)");
    }

    @Test
    @DisplayName("Не должен создать папку с пустым именем")
    void cannotCreateFolderWithEmptyName() {
        Response resp = client.createFolder("");
        int status = resp.statusCode();
        assertTrue(status == 400 || status == 404, "Ожидался 400 или 404 для пустого имени");
    }

    @Test
    @DisplayName("Не должен создать папку с некорректным именем")
    void cannotCreateFolderWithInvalidCharacters() {
        String badName = "////";
        Response resp = client.createFolder(badName);
        int status = resp.statusCode();
        assertTrue(status == 400 || status == 404, "Ожидался 400 или 404 при некорректном имени");
    }
}