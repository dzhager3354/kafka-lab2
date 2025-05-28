FROM gradle:8.4.0-jdk17 as build
LABEL authors="dzhager3354"
WORKDIR /app
COPY . .
RUN gradle build
RUN ls build/libs

FROM alpine
RUN apk update \
    && apk add openjdk17-jre 
WORKDIR /app
COPY --from=build ./app/build/libs/ .
EXPOSE 8080/tcp
CMD ["java", "-jar", "apiService-build.jar"]