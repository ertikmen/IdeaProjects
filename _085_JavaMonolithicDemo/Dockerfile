#ilk olarak kullanılacak JDK sürümü seçilir.
FROM openjdk:17
#FROM amazoncorretto:17

# Jar dosyasının docker'a kopyalanması:
#1.yol:
#COPY build/libs/_085_JavaMonolithicDemo-0.0.1-SNAPSHOT.jar
#2.yol:
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Eğer sistemde güncellemelerin yapılmasını isterseniz.
CMD apt-get update -y

# projenin calisacagi ic port
EXPOSE 8080

#Jarı çalıştırma komutu:
ENTRYPOINT ["java","-jar","/app.jar"]

#Argüman kullanarak oluşturulan dockerfile'in çalıştırılması için:
#1.yol:
# docker build --build-arg JAR_FILE=build/libs/_085_JavaMonolithicDemo-0.0.1-SNAPSHOT.jar .

#2.Yol: eğer dockerhub hesabınıza kopyalayacaksanız.
# docker build --build-arg  JAR_FILE=build/libs/_085_JavaMonolithicDemo-0.0.1-SNAPSHOT.jar -t  ertikmen/java-monolithic-demo .
# docker run -d -p 9091:8080 ertikmen/mimaraslan/java-monolithic-demo

# docker build --build-arg  JAR_FILE=build/libs/_085_JavaMonolithicDemo-0.0.1-SNAPSHOT.jar -t  ertikmen/java-monolithic-demo:001 .
# docker run -d -p 9092:8080 ertikmen/mimaraslan/java-monolithic-demo:001

# docker build --build-arg  JAR_FILE=build/libs/_085_JavaMonolithicDemo-0.0.1-SNAPSHOT.jar -t  ertikmen/java-monolithic-demo:v001 .
# docker run -d -p 9093:8080 ertikmen/mimaraslan/java-monolithic-demo:v001
