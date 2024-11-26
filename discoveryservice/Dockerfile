FROM eclipse-temurin:17.0.12_7-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} discoveryservice-1.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","/discoveryservice-1.jar"]