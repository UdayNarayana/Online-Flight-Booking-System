FROM openjdk:11
VOLUME /tmp
EXPOSE 8083
# ADD target/SpringDocker-0.0.1-SNAPSHOT.jar SpringDocker-0.0.1-SNAPSHOT.jar
ADD build/libs/*.jar AirlineTicketBookingSystem.jar
ENTRYPOINT [ "java","-jar","/AirlineTicketBookingSystem.jar" ]