FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
# ADD target/SpringDocker-0.0.1-SNAPSHOT.jar SpringDocker-0.0.1-SNAPSHOT.jar
ADD build/libs/*.jar AdminFlight.jar
ENTRYPOINT [ "java","-jar","/AdminFlight.jar" ]