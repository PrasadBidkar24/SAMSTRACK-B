# Use an official OpenJDK image as the base
FROM openjdk:17

# REMOVE or comment out this line — it's no longer allowed
# VOLUME /tmp

# Add your JAR file
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the app
ENTRYPOINT ["java","-jar","/app.jar"]

