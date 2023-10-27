#JDK sürümü
FROM amazoncorretto:20.0.0

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
CMD apt-get update-y

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]