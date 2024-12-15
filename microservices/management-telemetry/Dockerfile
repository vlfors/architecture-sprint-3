# Используем официальный образ Maven для сборки проекта
FROM maven:3-openjdk-17 AS build
WORKDIR /app

# Копируем pom.xml и скачиваем зависимости Maven для лучшего кэширования
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходный код проекта и собираем JAR
COPY src ./src
RUN mvn clean package -DskipTests

# Используем минимальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Создаём непривилегированного пользователя
RUN useradd -ms /bin/bash appuser
USER appuser

# Копируем скомпилированный JAR файл в контейнер
COPY --from=build  /app/target/management-telemetry-0.0.1-SNAPSHOT.jar /app/management-telemetry.jar

# Открываем порт, на котором будет работать приложение
EXPOSE 8081

# Определяем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "management-telemetry.jar"]
