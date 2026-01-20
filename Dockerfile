FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy pom.xml first for dependency caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src src

# Build application
RUN mvn clean package -DskipTests

# Run the jar
CMD ["java", "-jar", "target/*.jar"]
