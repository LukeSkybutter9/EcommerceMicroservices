FROM eclipse-temurin:17.0.12_7-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ProductoService-1.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","/ProductoService-1.jar"]