FROM openjdk:17

COPY target/my-demo-app-0.0.1-SNAPSHOT.jar /app.jar

WORKDIR /

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]

