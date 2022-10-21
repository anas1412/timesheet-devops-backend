FROM openjdk:8-jre-alpine
EXPOSE 8089
ADD target/appachat.jar appachat.jar
CMD ["java", "-jar", "/achat.jar"]