package ru.practicum.kafka.producer.jokes;

public record Joke(
        int id,
        String category,
        String setup,
        String delivery
) {
}
