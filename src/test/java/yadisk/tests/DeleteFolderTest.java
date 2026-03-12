package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yadisk.utils.RandomUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteFolderTest extends YandexDiskTest {

    @Test
    @DisplayName("Должен удалить папку с полной проверкой")
    void shouldDeleteFolderWithCheck() {
        String folderName = RandomUtils.randomFolderName();

        client.createFolder(folderName);

        Response deleteResp = client.deleteFolder(folderName);
        assertEquals(204, deleteResp.statusCode(), "Папка не удалилась");

        Response getResp = client.getResource(folderName);
        assertEquals(404, getResp.statusCode(), "Папка всё ещё существует после удаления");
    }
}