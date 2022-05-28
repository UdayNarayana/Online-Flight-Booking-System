FROM openjdk:11
VOLUME /tmp
EXPOSE 8085
# ADD target/SpringDocker-0.0.1-SNAPSHOT.jar SpringDocker-0.0.1-SNAPSHOT.jar
ADD build/libs/*.jar PassengerOnlineTicket2-5.jar
ENTRYPOINT [ "java","-jar","/PassengerOnlineTicket2-5.jar" ]