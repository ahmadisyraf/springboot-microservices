# Use OpenJDK 11 as the base image
FROM openjdk:17-jdk-slim

# Copy the application JAR into the container
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

# Command to run the application
CMD ["java", "-jar", "/app/api-gateway.jar"]