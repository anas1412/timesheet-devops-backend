FROM openjdk:8-jre-alpine
ADD target/achat.jar achat.jar
EXPOSE 9090
CMD ["java", "-jar", "/achat.jar"]
