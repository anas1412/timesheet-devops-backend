FROM openjdk:8-jre-alpine
ADD target/appachat.jar appachat.jar
EXPOSE 8089
CMD ["java", "-jar", "/appachat.jar"]