# Use Gradle with JDK 21 for building the application
FROM gradle:8.5-jdk21 AS builder
WORKDIR /app

# Copy necessary files from the application source code
COPY build.gradle ./
COPY settings.gradle ./
COPY src ./src
# COPY .env ./.env

# Build the application, skipping tests
RUN gradle build --no-daemon -x test

# Use a lightweight JDK 21 image for running the application
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the application's port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
