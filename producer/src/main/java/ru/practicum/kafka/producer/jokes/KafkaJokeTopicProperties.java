package ru.practicum.kafka.producer.jokes;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("practicum.kafka.producer.jokes.topic")
public class KafkaJokeTopicProperties {
    private String name;
    private int numPartitions;
    private short replicationFactor;
}
