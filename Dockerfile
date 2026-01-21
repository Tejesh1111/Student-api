FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Install Maven
RUN apk add --no-cache maven

# Copy pom first to leverage layer caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source and build
COPY src src
RUN mvn clean package -DskipTests

# Copy the built jar to a fixed name so runtime doesn't rely on globs
RUN cp target/*.jar app.jar

# Run the fixed jar
CMD ["java", "-jar", "app.jar"]
