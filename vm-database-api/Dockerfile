FROM openjdk:17-jdk-alpine
EXPOSE 9192
RUN  mkdir /app
RUN  mkdir /app/config
RUN  mkdir /app/logs
WORKDIR /app

COPY target/*.jar /app/

ENTRYPOINT [ "java", "-jar", "/app/vm-database-api.jar" ]