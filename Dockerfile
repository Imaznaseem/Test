# Use a base image with Maven to build the project
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Set the working directory for the build
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Package the application to generate the JAR file
RUN mvn clean package

# Use a base image with Java to run the application
FROM openjdk:21-jdk-slim

# Set the working directory for the application
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/Cariogram-Backend-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

