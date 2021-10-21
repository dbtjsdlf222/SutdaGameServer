FROM maven:3.5-jdk-11 AS build
ADD /target/SutDa-0.jar app.jar
EXPOSE 4886
ENTRYPOINT ["java","-jar","app.jar"]