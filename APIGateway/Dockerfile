FROM openjdk:11
VOLUME /tmp
EXPOSE 8020
# ADD target/SpringDocker-0.0.1-SNAPSHOT.jar SpringDocker-0.0.1-SNAPSHOT.jar
ADD build/libs/*.jar APIGateway.jar
ENTRYPOINT [ "java","-jar","/APIGateway.jar" ]