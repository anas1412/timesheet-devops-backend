FROM openjdk:8-jre-alpine
ADD target/achat.jar achat.jar
EXPOSE 8089
CMD ["java", "-jar", "/achat.jar"]