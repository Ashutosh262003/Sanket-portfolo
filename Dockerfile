FROM openjdk:22-slim-bullseye
WORKDIR /app
COPY target/portfolio-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD [ "java","-jar","app.jar" ]
