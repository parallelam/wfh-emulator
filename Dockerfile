FROM openjdk:11-jdk
MAINTAINER Braeden Earp <bearp@lenovo.com>
ENTRYPOINT ["java", "-jar", "/usr/share/xccapiemulator/xccapiemulator.jar"]
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/xccapiemulator/xccapiemulator.jar
EXPOSE 8080