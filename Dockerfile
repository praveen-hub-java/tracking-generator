# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim
FROM maven:3.8.4-openjdk-11-slim



# Add Maintainer Info
LABEL maintainer="praveen-tracking"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src

RUN mvn clean install -DskipTests
# The application's jar file
ARG JAR_FILE=target/generator-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
