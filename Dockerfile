FROM openjdk:8-jre-alpine
EXPOSE 8089
CMD ["java", "-jar", "/achat.jar"]