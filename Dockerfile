FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/aggie-reuse-api-0.0.1-SNAPSHOT.jar app.jar

COPY .env .env

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

#add .env
#user = user
#password = password
#db_url = connection_link
#port = 5432
#database = database_name

#mvn clean package
#docker build -t aggie-reuse-spring .
#docker run -p 8080:8080 aggie-reuse-spring

#aws login: https://stackoverflow.com/questions/60807697/docker-login-error-storing-credentials-the-stub-received-bad-data