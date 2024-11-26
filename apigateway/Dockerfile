FROM eclipse-temurin:17.0.12_7-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} apigateway-1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/apigateway-1.jar"]