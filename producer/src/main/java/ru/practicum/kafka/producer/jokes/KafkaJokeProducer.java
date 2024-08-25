package ru.practicum.kafka.producer.jokes;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.practicum.kafka.dto.JokeDto;

@Component
@RequiredArgsConstructor
public class KafkaJokeProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJokeProducer.class);

    private final KafkaTemplate<String, JokeDto> kafkaTemplate;
    private final JokeFactory jokeFactory;
    private final KafkaJokeTopicProperties topicProperties;

    @Scheduled(fixedDelayString = "${practicum.kafka.producer.jokes.scheduled-delay-ms}")
    void produce() {
        Joke joke = jokeFactory.generate();
        JokeDto jokeDto = toDto(joke);
        LOGGER.info("Producing joke = {}", joke);
        kafkaTemplate.send(topicProperties.getName(), jokeDto);
    }

    private JokeDto toDto(Joke joke) {
        return JokeDto.newBuilder()
                .setId(joke.id())
                .setCategory(joke.category())
                .setSetup(joke.setup())
                .setDelivery(joke.delivery())
                .build();
    }
}
