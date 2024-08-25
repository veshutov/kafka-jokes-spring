package ru.practicum.kafka.producer.jokes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class RandomInternetJokeFactory implements JokeFactory {
    private final RestTemplate restTemplate;
    private final RandomInternetJokeFactoryProperties properties;

    @Override
    public Joke generate() {
        try {
            return restTemplate.getForEntity(properties.getSourceUrl(), Joke.class).getBody();
        } catch (Exception e) {
            return new Joke(-1, "Dark", "What do Japanese cannibals eat?", "Raw men");
        }
    }
}
