FROM openjdk:11
ADD /target/SutdaGameServer.jar app.jar
EXPOSE 4886
ENTRYPOINT ["java","-jar","app.jar"]