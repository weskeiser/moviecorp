FROM openjdk:19
VOLUME tmp
ADD target/noroffproject-0.0.1-SNAPSHOT.jar noroffproject-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
