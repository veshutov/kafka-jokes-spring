# Spring kafka producer/consumer

### Запуск
- запустить локальную kafka на `localhost:9092`
- создать топик `jokes`
- `mvn clean install`
- запустить приложение producer (java -jav ... или через IDE)
- запустить приложение consumer (java -jav ... или через IDE)

Топик создается автоматически при запуске producer'а.
Сообщение генерируются каждые 4 секунд (можно менять через `practicum.kafka.producer.jokes.scheduled-delay-ms`).

**P.S.** некоторые из анекдотов действительно смешные :)

