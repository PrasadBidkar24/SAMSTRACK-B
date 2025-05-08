# Use an official OpenJDK runtime as the base image
FROM openjdk:17

# Create a volume for temporary files
VOLUME /tmp

# Add your JAR file into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]
