FROM openjdk:16-jdk-slim
ENV Spring.profiles.active=prod
RUN mkdir app
WORKDIR app/
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java","-jar","app.jar"]