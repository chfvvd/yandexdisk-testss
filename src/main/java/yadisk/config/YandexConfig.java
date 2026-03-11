package yadisk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class YandexConfig {
    @Value("${yandex.disk.base-url}")
    public String baseUrl;

    @Value("${yandex.disk.token}")
    public String token;
}