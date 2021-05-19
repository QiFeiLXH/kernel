FROM mdsol/java11-jdk:latest
VOLUME /tmp
ADD target/bsoft-starter.jar bsoft-starter.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "/bsoft-starter.jar" ]