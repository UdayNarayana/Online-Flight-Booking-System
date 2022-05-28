FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD build/libs/*.jar Sprint-2-app.jar
ENTRYPOINT [ "java","-jar","/Sprint-2-app.jar" ]