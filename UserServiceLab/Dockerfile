FROM eclipse-temurin:17-jdk-alpine
# Создаем директорию (опционально)
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
