FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
# ADD target/SpringDocker-0.0.1-SNAPSHOT.jar SpringDocker-0.0.1-SNAPSHOT.jar
ADD build/libs/*.jar CloudConfig.jar
ENTRYPOINT [ "java","-jar","/CloudConfig.jar" ]