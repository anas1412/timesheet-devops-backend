FROM openjdk:8-jre-alpine
ADD target/app-achat.jar app-achat.jar
EXPOSE 8089
CMD ["java", "-jar", "/app-achat.jar"]