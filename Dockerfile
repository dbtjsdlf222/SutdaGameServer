#FROM sgrio/java
#ENV APP_HOME=/usr/local/service
#ENV DEBIAN_FRONTEND noninteractive
#COPY /target/SutdaGameServer.jar app.jar
#RUN apt-get update
#RUN apt-get install -y maven
#COPY pom.xml $APP_HOME/pom.xml
#COPY src $APP_HOME
#RUN mvn package
#EXPOSE 4886
#ENTRYPOINT ["java","-jar","app.jar"]


FROM ubuntu:latest
ENV APP_HOME=/usr/local/sutda
COPY pom.xml $APP_HOME/pom.xml
COPY src $APP_HOME
WORKDIR $APP_HOME
RUN apt-get -y update
RUN apt-get install -y maven
RUN apt-get install -y openjdk-11-jdk
RUN mvn package
COPY target/SutdaGameServer-jar-with-dependencies.jar run.jar
EXPOSE 4886
ENTRYPOINT ["java","-jar","run.jar"]