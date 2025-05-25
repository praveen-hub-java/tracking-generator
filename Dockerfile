# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set workdir inside container
WORKDIR /app

# Copy JAR from Maven build
COPY target/tracking-generator-0.0.1-SNAPSHOT.jar app.jar

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]
