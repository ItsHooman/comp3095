# Build Stage
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build --no-daemon

# Package Stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]
