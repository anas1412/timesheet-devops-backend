FROM openjdk:8-jre-alpine
ADD target/achat.jar achat.jar
EXPOSE 8080
CMD ["java", "-jar", "/achat.jar"]