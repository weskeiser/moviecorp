FROM maven:3-openjdk-18 AS maven
WORKDIR /moviecorp
COPY . .
RUN mvn clean package


FROM openjdk:18 AS runtime
# VOLUME tmp
WORKDIR /moviecorp
# ENV PORT 8080
# ENV SPRING_PROFILE "prod"
# ENV DDL_AUTO "none"
# ENV INIT_MODE "never"
# ENV SHOW_JPA_SQL "false"
ARG JAR_FILE=/moviecorp/target/*.jar
COPY --from=maven ${JAR_FILE} /moviecorp/moviecorp.jar

RUN chown -R 1000:1000 /moviecorp
USER 1000:1000
# ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "-Dspring.profiles.active=${SPRING_PROFILE}", "moviecorp.jar"]
ENTRYPOINT ["java", "-jar", "moviecorp.jar"]
