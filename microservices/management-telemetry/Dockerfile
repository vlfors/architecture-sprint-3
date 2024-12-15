# Используем официальный образ Maven для сборки проекта
FROM maven:3-openjdk-17 AS build

# Устанавливаем рабочую директорию для сборки
WORKDIR /app

# Копируем pom.xml и файлы зависимостей в контейнер
COPY pom.xml .

# Загружаем зависимости Maven (это делается отдельно для более эффективного кэширования)
RUN mvn dependency:go-offline

# Копируем исходный код проекта в контейнер
COPY src ./src

# Собираем проект и создаем JAR файл
RUN mvn clean package -DskipTests
# Используем официальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем скомпилированный JAR файл в контейнер
COPY --from=build  target/management-telemetry-0.0.1-SNAPSHOT.jar /app/management-telemetry.jar

# Открываем порт, на котором будет работать приложение
EXPOSE 8081

# Определяем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "management-telemetry.jar"]
