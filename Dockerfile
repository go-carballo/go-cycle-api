FROM gradle:8.6.5-jdk17-alpine AS build
COPY --chown=gradle:gradle . /app
RUN gradle bootJar --no-daemon


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "platzi_play.jar"]