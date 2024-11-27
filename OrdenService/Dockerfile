FROM eclipse-temurin:17.0.12_7-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} OrdenService-1.jar
ENTRYPOINT ["java","-jar","/OrdenService-1.jar"]