FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
# ADD target/SpringDocker-0.0.1-SNAPSHOT.jar SpringDocker-0.0.1-SNAPSHOT.jar
ADD build/libs/*.jar ServiceDiscovery.jar
ENTRYPOINT [ "java","-jar","/ServiceDiscovery.jar" ]