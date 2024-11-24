# Build Stage
#FROM openjdk:23-jdk-slim AS build
#WORKDIR /app
#COPY . .
#RUN ./gradlew clean build --no-daemon

# Package Stage
#FROM openjdk:23-jdk-slim
#WORKDIR /app
#COPY --from=build /app/build/libs/*.jar app.jar
#EXPOSE 8086
#ENTRYPOINT ["java", "-jar", "app.jar"]


# Build Stage
FROM openjdk:22-jdk-slim AS build
WORKDIR /app
COPY . .
# Skip tests during the build
RUN ./gradlew clean build -x test --no-daemon

# Package Stage
FROM openjdk:22-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]
