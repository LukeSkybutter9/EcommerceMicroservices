FROM eclipse-temurin:17.0.12_7-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ProductoService-1.jar
ENTRYPOINT ["java","-jar","/ProductoService-1.jar"]