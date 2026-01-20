# Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy project files
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/*.jar"]
