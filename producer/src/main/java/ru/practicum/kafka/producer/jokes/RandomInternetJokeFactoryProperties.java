package ru.practicum.kafka.producer.jokes;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("practicum.kafka.producer.jokes.factory")
public class RandomInternetJokeFactoryProperties {
    private String sourceUrl;
}
