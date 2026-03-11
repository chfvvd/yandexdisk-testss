package yadisk.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yadisk.client.YandexDiskClient;
import yadisk.utils.RandomUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = yadisk.YandexDiskApplication.class)
public class DeleteFolderTest {

    @Autowired
    private YandexDiskClient client;

    @Test
    void deleteFolderWithCheck() {
        String folderName = RandomUtils.randomFolderName();

        client.createFolder(folderName);

        Response deleteResp = client.deleteFolder(folderName);
        assertEquals(204, deleteResp.statusCode(), "Папка не удалилась");

        Response getResp = client.getResource(folderName);
        assertEquals(404, getResp.statusCode(), "Папка всё ещё существует после удаления");
    }
}