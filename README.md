# Translator

## Запуск проекта

1. Установить Docker - https://www.docker.com/get-started/
2. Создать файл `docker-compose.yml` с содержимым:

  ```yaml
version: '3.4'

services:
  translator:
    environment:
      - YANDEX_API_TOKEN=<Your token>
      - YANDEX_FOLDER_ID=<Your folder id>
      - SPRING_DATASOURCE_URL=jdbc:h2:mem:<Your H2 in-memory database name>
      - SPRING_DATASOURCE_USERNAME=<Your H2 username>
      - SPRING_DATASOURCE_PASSWORD=<Your H2 password>
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - "8081:8081/tcp"
```

3. Собрать проект, для этого выполнить команду:

  ```sh
  docker compose build
  ```

4. Запустить собранный проект:

  ```sh
  docker compose up
  ```

5. Для перевода слов использовать endpoint POST `http://<server>:8081/translator/v1`

Входные данные:

```json
{
    "sourceString": "Example of input data",
    "translationOptions": "en-ru"
}
```

Выходные данные:

```json
{
    "text": "Пример от вход данные"
}
```

## Технологии

- `Java 17`
- `Spring Boot`
- `Spring MVC`
- `JDBC`
- `H2 Database`
- `REST`
- `Web-Client`
- `Yandex API`
- `Gradle`
- `Intellij Idea for IDE`
