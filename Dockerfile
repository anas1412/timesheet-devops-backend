FROM openjdk:8-jre-alpine
ADD target/app-achat-1.0.jar app-achat-1.0.jar
EXPOSE 8089
CMD ["java", "-jar", "/app-achat-1.0.jar"]