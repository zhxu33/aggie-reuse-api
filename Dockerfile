FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/aggie-reuse-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

#mvn clean package
#docker build -t aggie-reuse-api .
#docker run -p 8080:8080 aggie-reuse-api