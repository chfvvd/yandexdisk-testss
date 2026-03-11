package yadisk.utils;

import java.util.UUID;

public class RandomUtils {
    public static String randomFolderName() {
        return "test-folder-" + UUID.randomUUID();
    }
}