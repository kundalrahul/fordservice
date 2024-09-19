# Stage 1: Build the JAR file
FROM eclipse-temurin:17-jdk-alpine as builder

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle files and application code
COPY build.gradle settings.gradle /app/
COPY gradlew /app/
COPY gradle /app/gradle
COPY src /app/src

# Give execution permission and build the application JAR
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

# Stage 2: Create the final image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
