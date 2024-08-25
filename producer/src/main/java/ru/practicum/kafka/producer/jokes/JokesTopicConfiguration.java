package ru.practicum.kafka.producer.jokes;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JokesTopicConfiguration {

    @Bean
    public NewTopic jokesTopic(KafkaJokeTopicProperties properties) {
        return new NewTopic(properties.getName(), properties.getNumPartitions(), properties.getReplicationFactor());
    }
}
