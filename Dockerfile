# Use a base image with Java 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/Cariogram-Backend-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
