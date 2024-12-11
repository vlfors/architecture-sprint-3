# Используем официальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем скомпилированный JAR файл в контейнер
COPY target/management-telemetry-0.0.1-SNAPSHOT.jar /app/management-telemetry.jar

# Открываем порт, на котором будет работать приложение
EXPOSE 8081

# Определяем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "management-telemetry.jar"]
