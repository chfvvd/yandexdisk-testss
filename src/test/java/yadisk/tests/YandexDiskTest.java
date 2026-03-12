package yadisk.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yadisk.client.YandexDiskClient;

@SpringBootTest
public class YandexDiskTest {

    @Autowired
    protected YandexDiskClient client;

}
