FROM gradle:8.14.3-jdk21 AS build
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar --no-daemon


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]