package ru.practicum.kafka.consumer.jokes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.practicum.kafka.dto.JokeDto;

@Component
public class KafkaJokesConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJokesConsumer.class);

    @KafkaListener(
            topics = "${practicum.kafka.consumer.jokes.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(
            @Payload JokeDto joke,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) int offset,
            Acknowledgment acknowledgment
    ) {
        LOGGER.info("Consuming partition = {}, offset = {}, joke = {}", partition, offset, joke);
        acknowledgment.acknowledge();
    }
}
